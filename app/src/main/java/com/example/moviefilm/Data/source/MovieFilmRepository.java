package com.example.moviefilm.Data.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.Data.source.remote.RemoteRepository;
import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;
import com.example.moviefilm.ValueObject.Resource;

import java.util.ArrayList;
import java.util.List;

public class MovieFilmRepository implements MovieFilmDataSource {

    private volatile static MovieFilmRepository movieFilmRepository;
    private final RemoteRepository remoteRepository;
    private volatile static MovieFilmRepository INSTANCE = null;

    public MovieFilmRepository(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static MovieFilmRepository getInstance(RemoteRepository remoteRepository) {
        if (INSTANCE == null) {
            synchronized (MovieFilmRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieFilmRepository(remoteRepository);

                }
            }
        }
        return INSTANCE;

    }


    @Override
    public LiveData<Resource<ArrayList<MovieEntity>>> getMovieAll() {
        return null;
    }

    @Override
    public LiveData<Resource<ArrayList<TvshowEntity>>> getTvshowAll() {
        return null;
    }

    @Override
    public LiveData<Resource<ArrayList<MovieEntity>>> getMovieId(int id) {
        return null;
    }

    @Override
    public LiveData<Resource<ArrayList<TvshowEntity>>> getTvshowId(int id) {
        return null;
    }
}
