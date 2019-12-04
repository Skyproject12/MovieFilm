package com.example.moviefilm.Data.source.remote;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;
import com.example.moviefilm.Util.ApiHelper;
import com.example.moviefilm.Util.IddlingTesting;
import com.example.moviefilm.Util.Static;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class RemoteRepository {
    private static RemoteRepository INSTANCE;
    private ApiHelper apiHelper;

    public RemoteRepository(ApiHelper apiHelper) {
        this.apiHelper = apiHelper;
    }

    public static RemoteRepository getInstance(ApiHelper apiHelper) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteRepository(apiHelper);
        }
        return INSTANCE;
    }

    public LiveData<ApiResponse<List<TvShowResponse>>> getAllTvshow() {
        MutableLiveData<ApiResponse<List<TvShowResponse>>> result = new MutableLiveData<>();
        result.setValue(ApiResponse.success(apiHelper.loadTvshow()));
        return result;
    }

    public LiveData<ApiResponse<List<MovieResponse>>> getAllMovie() {
        MutableLiveData<ApiResponse<List<MovieResponse>>> result = new MutableLiveData<>();
        result.setValue(ApiResponse.success(apiHelper.loadMovie()));
        return result;
    }
    public LiveData<ApiResponse<List<MovieResponse>>> getIdMovie(int idObject) {
        MutableLiveData<ApiResponse<List<MovieResponse>>> result = new MutableLiveData<>();
        result.setValue(ApiResponse.success(apiHelper.loadIdMovie(idObject)));
        return result;
    }
    public LiveData<ApiResponse<List<TvShowResponse>>> getIdTvshow(int idObject) {
        MutableLiveData<ApiResponse<List<TvShowResponse>>> result = new MutableLiveData<>();
        result.setValue(ApiResponse.success(apiHelper.loadIdTvshow(idObject)));
        return result;
    }
}
