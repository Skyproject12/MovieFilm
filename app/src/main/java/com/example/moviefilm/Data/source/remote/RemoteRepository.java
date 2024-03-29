package com.example.moviefilm.Data.source.remote;

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

    public void getAllMovie(LoadMovieCallback callback) {
        IddlingTesting.increment();
        // menampung hasil dari request jsonHelper.loadCourse
        AsyncHttpClient client = new AsyncHttpClient();
        String Url = "https://api.themoviedb.org/3/discover/movie?api_key=" + Static.API_KEY + "&language=en-US";
        client.get(Url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                try {
                    JSONObject responseJson = new JSONObject(result);
                    JSONArray listArray = responseJson.getJSONArray("results");
                    List<MovieResponse> list = new ArrayList<>();
                    for (int i = 0; i < listArray.length(); i++) {
                        JSONObject movie = listArray.getJSONObject(i);
                        MovieResponse movieResponse = new MovieResponse(
                                movie.getInt("id"),
                                "https://image.tmdb.org/t/p/w185/" + movie.getString("poster_path"),
                                movie.getString("original_title"),
                                movie.getString("overview"),
                                movie.getString("release_date")
                        );
                        list.add(movieResponse);
                        callback.onSuccess(ApiResponse.success(list));
                        if (!IddlingTesting.getIddlingTesting().isIdleNow()) {
                            IddlingTesting.decrement();
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("Helper", "onFailed: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void getTvshow(LoadTvshowCallback callback) {
        IddlingTesting.increment();
        AsyncHttpClient client = new AsyncHttpClient();
        String Url = "https://api.themoviedb.org/3/discover/tv?api_key=" + Static.API_KEY + "&language=en-US";
        client.get(Url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                try {
                    JSONObject responseJson = new JSONObject(result);
                    JSONArray listArray = responseJson.getJSONArray("results");
                    List<TvShowResponse> list = new ArrayList<>();
                    for (int i = 0; i < listArray.length(); i++) {
                        JSONObject show = listArray.getJSONObject(i);
                        TvShowResponse tvShowResponse = new TvShowResponse(
                                show.getInt("id"),
                                "https://image.tmdb.org/t/p/w185/" + show.getString("poster_path"),
                                show.getString("name"),
                                show.getString("overview"),
                                show.getString("first_air_date")
                        );
                        list.add(tvShowResponse);
                        callback.onSuccess(ApiResponse.success(list));

                        if (!IddlingTesting.getIddlingTesting().isIdleNow()) {
                            IddlingTesting.decrement();
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("error", "error show: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void getMovieById(int id, LoadMovieCallback calback) {
        IddlingTesting.increment();
        AsyncHttpClient client = new AsyncHttpClient();
        String Url = "https://api.themoviedb.org/3/discover/movie?api_key=" + Static.API_KEY + "&language=en-US";
        client.get(Url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                try {
                    JSONObject responseJson = new JSONObject(result);
                    JSONArray listArray = responseJson.getJSONArray("results");
                    List<MovieResponse> list = new ArrayList<>();
                    for (int i = 0; i < listArray.length(); i++) {
                        JSONObject movieId = listArray.getJSONObject(i);
                        if (id == movieId.getInt("id")) {
                            MovieResponse movieResponse = new MovieResponse(
                                    movieId.getInt("id"),
                                    "https://image.tmdb.org/t/p/w185/" + movieId.getString("poster_path"),
                                    movieId.getString("original_title"),
                                    movieId.getString("overview"),
                                    movieId.getString("release_date")
                            );
                            list.add(movieResponse);
                            calback.onSuccess(ApiResponse.success(list));

                            if (!IddlingTesting.getIddlingTesting().isIdleNow()) {
                                IddlingTesting.decrement();
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


    public void getTvshowById(int id, LoadTvshowCallback calback) {
        IddlingTesting.increment();
        AsyncHttpClient client = new AsyncHttpClient();
        String Url = "https://api.themoviedb.org/3/discover/tv?api_key=" + Static.API_KEY + "&language=en-US";
        client.get(Url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                try {
                    JSONObject responseJson = new JSONObject(result);
                    JSONArray listArray = responseJson.getJSONArray("results");
                    List<TvShowResponse> list = new ArrayList<>();

                    for (int i = 0; i < listArray.length(); i++) {
                        JSONObject tvshowId = listArray.getJSONObject(i);
                        if (id == tvshowId.getInt("id")) {
                            TvShowResponse tvShowResponse = new TvShowResponse(
                                    tvshowId.getInt("id"),
                                    "https://image.tmdb.org/t/p/w185/" + tvshowId.getString("poster_path"),
                                    tvshowId.getString("name"),
                                    tvshowId.getString("overview"),
                                    tvshowId.getString("first_air_date")
                            );
                            list.add(tvShowResponse);
                            calback.onSuccess(ApiResponse.success(list));

                            if (!IddlingTesting.getIddlingTesting().isIdleNow()) {
                                IddlingTesting.decrement();
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
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

    public interface LoadMovieCallback {
        void onSuccess(ApiResponse<List<MovieResponse>> movieResponse);

        void onNotAvailable();

    }

    public interface LoadTvshowCallback {
        void onSuccess(ApiResponse<List<TvShowResponse>> tvshowResponse);

        void onNotAvailbale();

    }
}
