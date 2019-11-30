package com.example.moviefilm.Data.source;

import androidx.lifecycle.LiveData;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.ValueObject.Resource;

import java.util.ArrayList;
import java.util.List;


public interface MovieFilmDataSource {
    LiveData<Resource<List<MovieEntity>>> getMovieAll();
    LiveData<Resource<ArrayList<TvshowEntity>>> getTvshowAll();
    LiveData<Resource<ArrayList<MovieEntity>>> getMovieId(int id);
    LiveData<Resource<ArrayList<TvshowEntity>>> getTvshowId(int id);
}
