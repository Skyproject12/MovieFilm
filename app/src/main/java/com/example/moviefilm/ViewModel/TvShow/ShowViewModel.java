package com.example.moviefilm.ViewModel.TvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.ValueObject.Resource;

import java.util.ArrayList;
import java.util.List;

public class ShowViewModel extends ViewModel {

    MovieFilmRepository movieFilmRepository;

    public ShowViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<Resource<List<TvshowEntity>>> getShow(){
        return movieFilmRepository.getTvshowAll();
    }

}
