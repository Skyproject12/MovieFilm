package com.example.moviefilm.ViewModel.TvShow;

import android.util.Log;

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
        LiveData<Resource<List<TvshowEntity>>> data  = movieFilmRepository.getTvshowAll();
        Log.d("hasil", "getShow: "+movieFilmRepository.getTvshowAll().getValue().data);
        return movieFilmRepository.getTvshowAll();
    }

}
