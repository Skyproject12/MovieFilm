package com.example.moviefilm.ViewModel.TvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;

import java.util.ArrayList;

public class ShowViewModel extends ViewModel {

    MovieFilmRepository movieFilmRepository;

    public ShowViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<ArrayList<TvshowEntity>> getShow(){
        return movieFilmRepository.getTvshowAll();
    }

}
