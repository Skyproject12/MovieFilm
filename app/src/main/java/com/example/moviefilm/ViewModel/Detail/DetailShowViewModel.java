package com.example.moviefilm.ViewModel.Detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.ValueObject.Resource;

import java.util.ArrayList;
import java.util.List;

public class DetailShowViewModel extends ViewModel {

    private MovieFilmRepository movieFilmRepository;
    private  int tvshowId;

    public DetailShowViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<Resource<List<TvshowEntity>>> getTvshoId(int id){
        return movieFilmRepository.getTvshowId(id);
    }

    public void setTvshowId(int tvshowId) {
        this.tvshowId = tvshowId;
    }
}
