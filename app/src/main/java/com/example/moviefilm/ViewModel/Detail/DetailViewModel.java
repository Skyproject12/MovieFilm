package com.example.moviefilm.ViewModel.Detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.Util.DataDummy;

import java.util.ArrayList;

public class DetailViewModel extends ViewModel {

    MovieFilmRepository movieFilmRepository;

    public DetailViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<ArrayList<Movie>> getMovieId(int id){
        //return DataDummy.getIdMovie( id);
        return movieFilmRepository.getMovieId(id);
    }

}
