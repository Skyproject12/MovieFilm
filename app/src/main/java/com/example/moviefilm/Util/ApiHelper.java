package com.example.moviefilm.Util;

import android.app.Application;
import android.util.Log;

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

    // memparse json into String format
    private String parsingFileToString(String fileName){
        try {
            // memberi parameter untuk input fileName
            InputStream is= application.getAssets().open(fileName);
            byte[] buffer= new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);
        }
        catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }

    // covert json to array format
    public List<TvShowResponse> loadCourse(){
        ArrayList<TvShowResponse> list= new ArrayList<>();
        try {
            // take object file json
            JSONObject responseObject= new JSONObject(parsingFileToString("tvshow.json"));
            // take array course
            JSONArray listArray= responseObject.getJSONArray("tvshow");
            for (int i = 0; i < listArray.length() ; i++) {
                // take object array
                JSONObject course= listArray.getJSONObject(i);
                int id= course.getInt("id");
                String title= course.getString("image");
                String description= course.getString("judul");
                String date= course.getString("deskripsi");
                String imagePath= course.getString("tanggalRilis");
                // tampung dalam object
                TvShowResponse courseResponse= new TvShowResponse(id, title, description, date, imagePath);
                list.add(courseResponse);
                Log.d("berhasil dalam", "loadCourse: "+list.get(0).getTanggalRilis());
            }
        }
        catch(JSONException e){
            Log.d("jsonerror", "loadCourse: "+e.getMessage());
            e.printStackTrace();
        }
        Log.d("berhasil", "loadCourse: "+list.get(0).getTanggalRilis());
        return list;
    }

}
