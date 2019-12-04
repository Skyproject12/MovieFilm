package com.example.moviefilm.Util;

import android.app.Application;

import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ApiHelper {

    private Application application;

    public ApiHelper(Application application) {
        this.application = application;
    }

    private String parsingFileToString(String fileName) {
        try {
            InputStream is = application.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<TvShowResponse> loadTvshow() {
        ArrayList<TvShowResponse> list = new ArrayList<>();
        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("tvshow.json"));
            // take array course
            JSONArray listArray = responseObject.getJSONArray("tvshow");
            for (int i = 0; i < listArray.length(); i++) {
                // take object array
                JSONObject course = listArray.getJSONObject(i);
                int id = course.getInt("id");
                String title = course.getString("image");
                String description = course.getString("judul");
                String date = course.getString("deskripsi");
                String imagePath = course.getString("tanggalRilis");
                // tampung dalam object
                TvShowResponse courseResponse = new TvShowResponse(id, title, description, date, imagePath);
                list.add(courseResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<MovieResponse> loadMovie() {
        ArrayList<MovieResponse> list = new ArrayList<>();
        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("movie.json"));
            // take array course
            JSONArray listArray = responseObject.getJSONArray("movie");
            for (int i = 0; i < listArray.length(); i++) {
                // take object array
                JSONObject course = listArray.getJSONObject(i);
                int id = course.getInt("id");
                String title = course.getString("image");
                String description = course.getString("judul");
                String date = course.getString("deskripsi");
                String imagePath = course.getString("tanggalRilis");
                // tampung dalam object
                MovieResponse courseResponse = new MovieResponse(id, title, description, date, imagePath);
                list.add(courseResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<MovieResponse> loadIdMovie(int idObject) {
        ArrayList<MovieResponse> list = new ArrayList<>();
        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("movie.json"));
            // take array course
            JSONArray listArray = responseObject.getJSONArray("movie");
            for (int i = 0; i < listArray.length(); i++) {
                // take object array
                JSONObject course = listArray.getJSONObject(i);
                int id = course.getInt("id");
                if(idObject==id) {
                    String title = course.getString("image");
                    String description = course.getString("judul");
                    String date = course.getString("deskripsi");
                    String imagePath = course.getString("tanggalRilis");
                    // tampung dalam object
                    MovieResponse courseResponse = new MovieResponse(id, title, description, date, imagePath);
                    list.add(courseResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<TvShowResponse> loadIdTvshow(int idObject) {
        ArrayList<TvShowResponse> list = new ArrayList<>();
        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("tvshow.json"));
            // take array course
            JSONArray listArray = responseObject.getJSONArray("tvshow");
            for (int i = 0; i < listArray.length(); i++) {
                // take object array
                JSONObject course = listArray.getJSONObject(i);
                int id = course.getInt("id");
                if(idObject==id) {
                    String title = course.getString("image");
                    String description = course.getString("judul");
                    String date = course.getString("deskripsi");
                    String imagePath = course.getString("tanggalRilis");
                    // tampung dalam object
                    TvShowResponse courseResponse = new TvShowResponse(id, title, description, date, imagePath);
                    list.add(courseResponse);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}
