package com.example.moviefilm.ViewModel.Favorite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.ValueObject.Resource;

public class MovieFavoriteViewModel extends ViewModel {
    private MovieFilmRepository movieFilmRepository;

    public MovieFavoriteViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }
    // get data where favorite ==1
    public LiveData<Resource<PagedList<MovieEntity>>> getFavoriteMovie(){
        return movieFilmRepository.getFavoriteMoviePage();

    }
}
