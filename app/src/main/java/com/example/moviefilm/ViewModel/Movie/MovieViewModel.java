package com.example.moviefilm.ViewModel.Movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.Util.DataDummy;

import java.util.ArrayList;
import java.util.List;

public class MovieViewModel extends ViewModel {

    private MovieFilmRepository movieFilmRepository;

    public MovieViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<ArrayList<Movie>> getMovie(){
        return movieFilmRepository.getMovieAll();

    }

}
