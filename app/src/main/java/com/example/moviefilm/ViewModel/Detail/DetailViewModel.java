package com.example.moviefilm.ViewModel.Detail;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.ValueObject.Resource;

import java.util.List;

public class DetailViewModel extends ViewModel {

    MovieFilmRepository movieFilmRepository;
    private MutableLiveData<Integer> movieId= new MutableLiveData<>();

    public DetailViewModel(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public LiveData<Resource<List<MovieEntity>>> getMovieId = Transformations.switchMap(movieId, movieId-> movieFilmRepository.getMovieId(movieId));


    public void setMovieId(int movieId) {
        this.movieId.setValue(movieId);
    }

    public Integer getterMovieId() {
        if(movieId.getValue()!=0)return null;
        return movieId.getValue();
    }

    public void setFavorite(){
        List<MovieEntity> list= getMovieId.getValue().data;
        MovieEntity movieEntity = null;
        for (int i=0; i<list.size(); i++){
            movieEntity= new MovieEntity(
                    list.get(i).getId(),
                    list.get(i).getImage(),
                    list.get(i).getJudul(),
                    list.get(i).getDeskripsi(),
                    list.get(i).getTanggalRilis(),
                    list.get(i).isFavorite()
            );
        }
        // mengeset status dari state akan beruhah ketika diklik
        boolean newState= !movieEntity.isFavorite();
        // mengupdate statusfavorite
        movieFilmRepository.setMovieFavorite(movieEntity, newState);

    }
}
