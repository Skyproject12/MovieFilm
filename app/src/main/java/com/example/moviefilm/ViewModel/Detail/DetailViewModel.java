package com.example.moviefilm.ViewModel.Detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;

import java.util.ArrayList;

public class DetailViewModel extends ViewModel {

    MovieFilmRepository movieFilmRepository;
    private int movieId;

    public DetailViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<ArrayList<MovieEntity>> getMovieId(int id){
        //return DataDummy.getIdMovie( id);
        return movieFilmRepository.getMovieId(id);
    }


    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
