package com.example.moviefilm.Data.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.Data.source.remote.RemoteRepository;
import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;

import java.util.ArrayList;
import java.util.List;

public class FakeMovieFilmRepository implements MovieFilmDataSource {

    private volatile static FakeMovieFilmRepository movieFilmRepository;
    private final RemoteRepository remoteRepository;
    private volatile static FakeMovieFilmRepository INSTANCE = null;

    public FakeMovieFilmRepository(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static FakeMovieFilmRepository getInstance(RemoteRepository remoteRepository) {
        if (INSTANCE == null) {
            synchronized (FakeMovieFilmRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FakeMovieFilmRepository(remoteRepository);

                }
            }
        }
        return INSTANCE;

    }


    @Override
    public LiveData<ArrayList<MovieEntity>> getMovieAll() {
        final MutableLiveData<ArrayList<MovieEntity>> movieEntity = new MutableLiveData<>();
        remoteRepository.getMovie(new RemoteRepository.LoadMovieCallback() {
            @Override
            public void onSuccess(List<MovieResponse> movieResponses) {
                ArrayList<MovieEntity> listMovieEntity = new ArrayList<>();
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse movieResponse = movieResponses.get(i);
                    MovieEntity movieEntityTemp = new MovieEntity(
                            movieResponse.getId(),
                            movieResponse.getImage(),
                            movieResponse.getJudul(),
                            movieResponse.getDeskripsi(),
                            movieResponse.getTanggalRilis()
                    );
                    listMovieEntity.add(movieEntityTemp);
                }
                movieEntity.postValue(listMovieEntity);
            }

            @Override
            public void onNotAvailable() {

            }
        });
        return movieEntity;

    }

    @Override
    public LiveData<ArrayList<TvshowEntity>> getTvshowAll() {
        final MutableLiveData<ArrayList<TvshowEntity>> tvshowEntity = new MutableLiveData<>();
        remoteRepository.getTvshow(new RemoteRepository.LoadTvshowCallback() {
            @Override
            public void onSuccess(List<TvShowResponse> tvShowResponses) {
                ArrayList<TvshowEntity> listTvshow = new ArrayList<>();
                for (int i = 0; i < tvShowResponses.size(); i++) {
                    TvShowResponse tvShowResponse = tvShowResponses.get(i);
                    TvshowEntity tvshowTemp = new TvshowEntity(
                            tvShowResponse.getId(),
                            tvShowResponse.getImage(),
                            tvShowResponse.getJudul(),
                            tvShowResponse.getDeskripsi(),
                            tvShowResponse.getTanggalRilis()
                    );
                    listTvshow.add(tvshowTemp);
                }
                tvshowEntity.postValue(listTvshow);
            }

            @Override
            public void onNotAvailbale() {

            }
        });
        return tvshowEntity;

    }

    @Override
    public LiveData<ArrayList<MovieEntity>> getMovieId(int id) {
        MutableLiveData<ArrayList<MovieEntity>> movieEntity = new MutableLiveData<>();
        remoteRepository.getMovieById(id, new RemoteRepository.LoadMovieCallback() {
            @Override
            public void onSuccess(List<MovieResponse> movieResponses) {
                ArrayList<MovieEntity> listMovieEntity = new ArrayList<>();
                for (int i = 0; i < movieResponses.size(); i++) {
                    MovieResponse movieResponse = movieResponses.get(i);
                    if (id == movieResponse.getId()) {
                        MovieEntity movieEntityTemp = new MovieEntity(
                                movieResponse.getId(),
                                movieResponse.getImage(),
                                movieResponse.getJudul(),
                                movieResponse.getDeskripsi(),
                                movieResponse.getTanggalRilis()
                        );
                        listMovieEntity.add(movieEntityTemp);
                    }
                }
                movieEntity.postValue(listMovieEntity);
            }

            @Override
            public void onNotAvailable() {

            }
        });
        return movieEntity;

    }

    @Override
    public LiveData<ArrayList<TvshowEntity>> getTvshowId(int id) {
        MutableLiveData<ArrayList<TvshowEntity>> tvshowEntity = new MutableLiveData<>();
        remoteRepository.getTvshowById(id, new RemoteRepository.LoadTvshowCallback() {
            @Override
            public void onSuccess(List<TvShowResponse> tvshowResponses) {
                ArrayList<TvshowEntity> listTvshow = new ArrayList<>();
                for (int i = 0; i < tvshowResponses.size(); i++) {
                    TvShowResponse tvShowResponse = tvshowResponses.get(i);
                    if (id == tvShowResponse.getId()) {
                        TvshowEntity tvshowTemp = new TvshowEntity(
                                tvShowResponse.getId(),
                                tvShowResponse.getImage(),
                                tvShowResponse.getJudul(),
                                tvShowResponse.getDeskripsi(),
                                tvShowResponse.getTanggalRilis()
                        );
                        listTvshow.add(tvshowTemp);
                    }
                }
                tvshowEntity.postValue(listTvshow);
            }

            @Override
            public void onNotAvailbale() {

            }
        });
        return tvshowEntity;

    }

}
