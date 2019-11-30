package com.example.moviefilm.ViewModel.Detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.ValueObject.Resource;

import java.util.ArrayList;
import java.util.List;

public class DetailViewModel extends ViewModel {

    MovieFilmRepository movieFilmRepository;
    private int movieId;

    public DetailViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<Resource<List<MovieEntity>>> getMovieId(int id){
        //return DataDummy.getIdMovie( id);
        return movieFilmRepository.getMovieId(id);
    }


    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
