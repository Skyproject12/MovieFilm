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

}
