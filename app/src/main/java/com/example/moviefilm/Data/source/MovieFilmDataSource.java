package com.example.moviefilm.Data.source;

import androidx.lifecycle.LiveData;

import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.Data.source.local.TvshowEntity;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

public interface MovieFilmDataSource {
    LiveData<ArrayList<Movie>> getMovieAll();
    LiveData<ArrayList<TvshowEntity>> getTvshowAll();

}
