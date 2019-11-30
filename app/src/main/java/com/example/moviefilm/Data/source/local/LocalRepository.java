package com.example.moviefilm.Data.source.local;

import androidx.lifecycle.LiveData;

import com.example.moviefilm.Data.source.local.Room.Dao.MovieFilmDao;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;

import java.util.List;

public class LocalRepository{
    private final MovieFilmDao movieFilmDao;

    public LocalRepository(MovieFilmDao movieFilmDao) {
        this.movieFilmDao = movieFilmDao;
    }

    private static LocalRepository INSTANCE;
    public static LocalRepository getInstance(MovieFilmDao movieFilmDao){
        if(INSTANCE==null){
            INSTANCE= new LocalRepository(movieFilmDao);
        }
        return INSTANCE;
    }

    public LiveData<List<MovieEntity>> getAllMovie(){
        return movieFilmDao.getMovie();
    }
    public LiveData<List<TvshowEntity>> getAllTvshow(){
        return movieFilmDao.getTvshow();
    }
    public LiveData<MovieEntity> getAllMovieById(String movieId){
        return movieFilmDao.getMovieById(movieId);
    }
    public LiveData<TvshowEntity> getAllTvshoeById(String tvshowId){
        return movieFilmDao.getTvshowId(tvshowId);
    }
}