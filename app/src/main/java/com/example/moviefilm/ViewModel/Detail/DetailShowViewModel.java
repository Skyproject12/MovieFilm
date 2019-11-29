package com.example.moviefilm.ViewModel.Detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;

import java.util.ArrayList;

public class DetailShowViewModel extends ViewModel {

    private MovieFilmRepository movieFilmRepository;
    private  int tvshowId;

    public DetailShowViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<ArrayList<TvshowEntity>> getTvshoId(int id){
        return movieFilmRepository.getTvshowId(id);
    }

    public void setTvshowId(int tvshowId) {
        this.tvshowId = tvshowId;
    }
}
