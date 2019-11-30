package com.example.moviefilm.Data.source;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.moviefilm.Data.source.remote.ApiResponse;
import com.example.moviefilm.Util.AppExecutors;
import com.example.moviefilm.ValueObject.Resource;

// class ini akan berjalan ketika local tidak menyediakan data secara actual
public abstract class NetworkBoundResource<ResultType, RequestType> {

    private MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    private AppExecutors mExecutors;

    protected void onFetchFailed() {
    }

    protected abstract LiveData<ResultType> loadFromDB();

    protected abstract Boolean shouldFetch(ResultType data);

    protected abstract LiveData<ApiResponse<RequestType>> createCall();

    protected abstract void saveCallResult(RequestType data);

    public NetworkBoundResource(AppExecutors appExecutors) {
        this.mExecutors = appExecutors;
        result.setValue(Resource.loading(null));

        LiveData<ResultType> dbSource = loadFromDB();

        if(dbSource!=null) {
            result.addSource(dbSource, data -> {
                  result.removeSource(dbSource);
                if (shouldFetch(data)) {
                fetchFromNetwork(dbSource);
                } else {
                 result.addSource(dbSource, newData -> result.setValue(Resource.success(newData)));
                }
            });
        }
        else{
            Log.d("ErrorNull", "NetworkBoundResource: null");
        }

    }

    private void fetchFromNetwork(LiveData<ResultType> dbSource) {

        LiveData<ApiResponse<RequestType>> apiResponse = createCall();

        result.addSource(dbSource, newData ->
                result.setValue(Resource.loading(newData))
        );
        result.addSource(apiResponse, response -> {

            result.removeSource(apiResponse);
            result.removeSource(dbSource);

            switch (response.status) {
                case SUCCESS:
                    mExecutors.diskIO().execute(() -> {

                        saveCallResult(response.body);

                        mExecutors.mainThread().execute(() ->
                                result.addSource(loadFromDB(),
                                        newData -> result.setValue(Resource.success(newData))));

                    });
                    break;

                case EMPTY:
                    mExecutors.mainThread().execute(() ->
                            result.addSource(loadFromDB(),
                                    newData -> result.setValue(Resource.success(newData))));

                    break;
                case ERROR:
                    onFetchFailed();
                    result.addSource(dbSource, newData ->
                            result.setValue(Resource.error(response.message, newData)));
                    break;
            }
        });
    }

    public LiveData<Resource<ResultType>> asLiveData() {
        return result;
    }


}
