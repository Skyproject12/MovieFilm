package com.example.moviefilm.ViewModel.Favorite;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.ValueObject.Resource;

public class TvshowFavoriteViewModel extends ViewModel {
    private MovieFilmRepository movieFilmRepository;

    public TvshowFavoriteViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }
    public LiveData<Resource<PagedList<TvshowEntity>>> getFavoriteTvshow(){
        return movieFilmRepository.getFavoriteTvshowPage();

    }
}
