package com.example.moviefilm.Data.source.remote;

import android.util.Log;

import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;
import com.example.moviefilm.Util.ApiHelper;
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

    public void getMovie(LoadMovieCallback callback) {
        final ArrayList<MovieResponse> list = new ArrayList<>();
        AsyncHttpClient client = new AsyncHttpClient();
        String Url = "https://api.themoviedb.org/3/discover/movie?api_key=" + Static.API_KEY + "&language=en-US";
        client.get(Url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                try {
                    JSONObject responseJson = new JSONObject(result);
                    JSONArray listArray = responseJson.getJSONArray("results");
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
                        callback.onSuccess(list);
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
        final ArrayList<TvShowResponse> list = new ArrayList<>();
        AsyncHttpClient client = new AsyncHttpClient();
        String Url = "https://api.themoviedb.org/3/discover/tv?api_key=" + Static.API_KEY + "&language=en-US";
        client.get(Url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result = new String(responseBody);
                try {
                    JSONObject responseJson = new JSONObject(result);
                    JSONArray listArray = responseJson.getJSONArray("results");
                    for (int i = 0; i < listArray.length(); i++) {
                        JSONObject show = listArray.getJSONObject(i);
                        TvShowResponse tvShowResponse = new TvShowResponse(
                                show.getInt("id"),
                                "https://image.tmdb.org/t/p/w185/"+show.getString("poster_path"),
                                show.getString("name"),
                                show.getString("overview"),
                                show.getString("first_air_date")
                        );
                        list.add(tvShowResponse);
                        callback.onSuccess(list);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("error", "error show: "+e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public interface LoadMovieCallback {
        void onSuccess(List<MovieResponse> movieResponses);

        void onNotAvailable();

    }

    public interface LoadTvshowCallback {
        void onSuccess(List<TvShowResponse> tvShowResponses);

        void onNotAvailbale();

    }
}
