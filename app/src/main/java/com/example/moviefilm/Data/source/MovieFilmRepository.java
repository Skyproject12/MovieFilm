package com.example.moviefilm.Data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviefilm.Data.source.local.LocalRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.Data.source.remote.ApiResponse;
import com.example.moviefilm.Data.source.remote.RemoteRepository;
import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;
import com.example.moviefilm.Util.AppExecutors;
import com.example.moviefilm.ValueObject.Resource;

import java.util.ArrayList;
import java.util.List;

public class MovieFilmRepository implements MovieFilmDataSource {

    private volatile static MovieFilmRepository movieFilmRepository;
    private final RemoteRepository remoteRepository;
    private volatile static MovieFilmRepository INSTANCE = null;
    private final LocalRepository localRepository;
    private final AppExecutors appExecutor;

    public MovieFilmRepository(@NonNull LocalRepository localRepository,@NonNull RemoteRepository remoteRepository, AppExecutors appExecutor) {
        this.localRepository= localRepository;
        this.remoteRepository = remoteRepository;
        this.appExecutor= appExecutor;
    }

    public static MovieFilmRepository getInstance(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository, AppExecutors appExecutor) {
        if (INSTANCE == null) {
            synchronized (MovieFilmRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieFilmRepository(localRepository, remoteRepository, appExecutor);

                }
            }
        }
        return INSTANCE;

    }


    @Override
    public LiveData<Resource<List<MovieEntity>>> getMovieAll() {
        return new NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutor) {
            @Override
            protected LiveData<List<MovieEntity>> loadFormDB() {
                return null;
            }

            @Override
            protected Boolean shouldFetch(List<MovieEntity> data) {
                return null;
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {

            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<ArrayList<TvshowEntity>>> getTvshowAll() {
        return null;
    }

    @Override
    public LiveData<Resource<ArrayList<MovieEntity>>> getMovieId(int id) {
        return null;
    }

    @Override
    public LiveData<Resource<ArrayList<TvshowEntity>>> getTvshowId(int id) {
        return null;
    }
}
