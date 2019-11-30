package com.example.moviefilm.ViewModel.Movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.ValueObject.Resource;

import java.util.List;

public class MovieViewModel extends ViewModel {

    private MovieFilmRepository movieFilmRepository;

    public MovieViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<Resource<List<MovieEntity>>> getMovie() {
        return movieFilmRepository.getMovieAll();

    }

}
