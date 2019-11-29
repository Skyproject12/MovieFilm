package com.example.moviefilm.Data.source;

import androidx.lifecycle.LiveData;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;

import java.util.ArrayList;

public interface MovieFilmDataSource {
    LiveData<ArrayList<MovieEntity>> getMovieAll();
    LiveData<ArrayList<TvshowEntity>> getTvshowAll();
    LiveData<ArrayList<MovieEntity>> getMovieId(int id);
    LiveData<ArrayList<TvshowEntity>> getTvshowId(int id);

}
