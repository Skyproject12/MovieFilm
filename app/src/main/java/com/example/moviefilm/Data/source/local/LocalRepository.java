package com.example.moviefilm.Data.source.local;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.example.moviefilm.Data.source.local.Room.Dao.MovieFilmDao;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;

import java.util.List;

public class LocalRepository {
    private final MovieFilmDao movieFilmDao;

    public LocalRepository(MovieFilmDao movieFilmDao) {
        this.movieFilmDao = movieFilmDao;
    }

    private static LocalRepository INSTANCE;

    public static LocalRepository getInstance(MovieFilmDao movieFilmDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalRepository(movieFilmDao);
        }
        return INSTANCE;
    }

    public LiveData<List<MovieEntity>> getAllMovie() {
        return movieFilmDao.getMovie();
    }

    public LiveData<List<TvshowEntity>> getAllTvshow() {
        return movieFilmDao.getTvshow();
    }

    public LiveData<List<MovieEntity>> getAllMovieById(int movieId) {
        return movieFilmDao.getMovieById(movieId);
    }

    public LiveData<List<TvshowEntity>> getAllTvshoeById(int tvshowId) {
        return movieFilmDao.getTvshowId(tvshowId);
    }

    public void insertMovie(List<MovieEntity> movie) {
        movieFilmDao.insertMovie(movie);

    }

    public void insertTvshow(List<TvshowEntity> tvshow) {
        movieFilmDao.insertTvshow(tvshow);

    }

    public DataSource.Factory<Integer, MovieEntity> getFavoritePaged() {
        Log.d("localfavorite", "getMovieFavoritePage: "+movieFilmDao.getTvshowAsPage());
        return movieFilmDao.getMovieAsPage();

    }

    public void setMovieFavorite(MovieEntity movie, boolean state) {
        // mengeset favorite berdasarkan state
        movie.setFavorite(state);
        // lalu mengupdate favoritemovie berdasarkan yang terbaru
        movieFilmDao.updateMovie(movie);

    }

    public DataSource.Factory<Integer, TvshowEntity> getTvshowFavoritePage() {
        Log.d("localfavorite", "getTvshowFavoritePage: "+movieFilmDao.getTvshowAsPage());
        return movieFilmDao.getTvshowAsPage();
    }

    public void setTvshowFavorite(TvshowEntity tvshow, boolean state) {
        tvshow.setFavorite(state);
        movieFilmDao.updateTvshow(tvshow);

    }
}