package com.example.moviefilm.Data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.ValueObject.Resource;

import java.util.ArrayList;
import java.util.List;


public interface MovieFilmDataSource {
    LiveData<Resource<List<MovieEntity>>> getMovieAll();
    LiveData<Resource<List<TvshowEntity>>> getTvshowAll();
    LiveData<Resource<List<MovieEntity>>> getMovieId(int id);
    LiveData<Resource<List<TvshowEntity>>> getTvshowId(int id);
    LiveData<Resource<PagedList<MovieEntity>>> getFavoriteMoviePage();
    void setMovieFavorite(MovieEntity movie, boolean state);
    void setTvshowFavorite(TvshowEntity tvshow, boolean state);
    LiveData<Resource<PagedList<TvshowEntity>>> getFavoriteTvshowPage();
    void deleteById(int movieId);

}
