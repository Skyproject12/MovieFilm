package com.example.moviefilm.ViewModel.Detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.ValueObject.Resource;

import java.util.List;

public class DetailShowViewModel extends ViewModel {

    private MovieFilmRepository tvshowMovieFilmRepository;
    private MutableLiveData<Integer> tvshowId = new MutableLiveData<>();

    public DetailShowViewModel(MovieFilmRepository movieFilmRepository) {
        this.tvshowMovieFilmRepository = movieFilmRepository;
    }

    public LiveData<Resource<List<TvshowEntity>>> getTvshowId = Transformations.switchMap(tvshowId, tvshowId -> tvshowMovieFilmRepository.getTvshowId(tvshowId));

    public void setTvshowId(int tvshowid) {
        this.tvshowId.setValue(tvshowid);
    }

    public Integer getterMovieId() {
        if (tvshowId.getValue() != 0) return null;
        return tvshowId.getValue();

    }

    public void setFavorite() {
        List<TvshowEntity> list = getTvshowId.getValue().data;
        TvshowEntity tvshowEntity = null;
        for (int i = 0; i < list.size(); i++) {
            tvshowEntity = new TvshowEntity(
                    list.get(i).getId(),
                    list.get(i).getImage(),
                    list.get(i).getJudul(),
                    list.get(i).getDeskripsi(),
                    list.get(i).getTanggalRilis(),
                    list.get(i).getFavorite()
            );
        }
        boolean newState = !tvshowEntity.getFavorite();
        tvshowMovieFilmRepository.setTvshowFavorite(tvshowEntity, newState);

    }
}
