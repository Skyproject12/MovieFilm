package com.example.moviefilm.ViewModel.TvShow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.Data.source.local.TvshowEntity;
import com.example.moviefilm.Util.DataDummy;

import java.util.ArrayList;
import java.util.List;

public class ShowViewModel extends ViewModel {

    MovieFilmRepository movieFilmRepository;

    public ShowViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<ArrayList<TvshowEntity>> getShow(){
        return movieFilmRepository.getTvshowAll();
    }

}
