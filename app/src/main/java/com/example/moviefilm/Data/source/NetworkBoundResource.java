package com.example.moviefilm.Data.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.moviefilm.Data.source.remote.ApiResponse;
import com.example.moviefilm.Util.AppExecutors;
import com.example.moviefilm.ValueObject.Resource;

public abstract class NetworkBoundResource<ResultType, RequestType> {
    public String message;
    private MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();
    private AppExecutors executors;

    protected void onFetchFailed(){

    }

    // medefinisikan class abstract
    protected abstract LiveData<ResultType> loadFormDB();
    protected abstract Boolean shouldFetch(ResultType data);
    protected abstract LiveData<ApiResponse<RequestType>> createCall();
    protected abstract void saveCallResult(RequestType data);

    public NetworkBoundResource(AppExecutors appExecutors){
        this.executors= appExecutors;
        result.setValue(Resource.loading(null));
        // get data from database
        LiveData<ResultType> dbSource= loadFormDB();
        result.addSource(dbSource, data->{
            result.removeSource(dbSource);
            // melakukan pengecekan apakah data kosong atau tidak
            if(shouldFetch(data)){
                // jika ya maka request ke intenet
                fetchFromNetwork(dbSource);
            }
            else{
                result.addSource(dbSource, newData-> result.setValue(Resource.success(newData)));
            }
        });
    }

    // fetch data from network
    private void fetchFromNetwork(LiveData<ResultType> dbSOurce){
        // melakukan menampilkan  all data from internet
        LiveData<ApiResponse<RequestType>> apiResponse= createCall();
        result.addSource(dbSOurce, mData-> result.setValue(Resource.loading(mData)));
        result.addSource(apiResponse, response->{
            result.removeSource(apiResponse);
            result.removeSource(dbSOurce);
            switch (response.status){
                case SUCCESS:
                    // jiks menampilkan data from internet success
                    executors.diskIO().execute(()->{
                        // maka saveData dari intenet into database
                        saveCallResult(response.body);
                        executors.mainThread().execute(()->result.addSource(loadFormDB(), newData-> result.setValue(Resource.success(newData))));
                    });
                    break;
                case EMPTY:
                    executors.mainThread().execute(()-> result.addSource(loadFormDB(), newData->result.setValue(Resource.success(newData))));
                    break;
                case ERROR:
                    onFetchFailed();
                    result.addSource(dbSOurce, newData->result.setValue(Resource.error(response.message, newData)));
                    break;
            }
        });
    }

    // memberi nilai berupa hasil pengembalian dimana berupa beberapa hasil dari livedata
    public LiveData<Resource<ResultType>> asLiveData(){
        return result;
    }


    // mediator livedata dapat menampung beberapa live data
}
