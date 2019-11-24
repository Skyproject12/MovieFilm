package com.example.moviefilm.Util;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ApiHelper {

    private Application application;

    public ApiHelper(Application application) {
        this.application = application;
    }

    public List<TvShowResponse> getTvShow(){
        final ArrayList<TvShowResponse> list= new ArrayList<>();
        AsyncHttpClient client= new AsyncHttpClient();
        String Url= "https://api.themoviedb.org/3/discover/tv?api_key=" + Static.API_KEY + "&language=en-US";
        client.get(Url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String result= new String(responseBody);
                try {
                    JSONObject responseJson= new JSONObject(result);
                    JSONArray listArray= responseJson.getJSONArray("results");
                    for (int i = 0; i <listArray.length() ; i++) {
                        JSONObject show= listArray.getJSONObject(i);
                        TvShowResponse tvShowResponse= new TvShowResponse(
                                show.getInt("id"),
                                show.getString("poster_path"),
                                show.getString("original_title"),
                                show.getString("overview"),
                                show.getString("release_date")
                        );
                        list.add(tvShowResponse);

                    }
                }
                catch(JSONException e){
                    e.printStackTrace();

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return list;
    }
}
