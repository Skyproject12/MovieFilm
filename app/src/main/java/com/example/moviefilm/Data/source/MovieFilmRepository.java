package com.example.moviefilm.Data.source;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.moviefilm.Data.source.local.LocalRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.Data.source.remote.ApiResponse;
import com.example.moviefilm.Data.source.remote.RemoteRepository;
import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;
import com.example.moviefilm.Util.AppExecutors;
import com.example.moviefilm.Util.IddlingTesting;
import com.example.moviefilm.ValueObject.Resource;

import java.util.ArrayList;
import java.util.List;

public class MovieFilmRepository implements MovieFilmDataSource {

    private volatile static MovieFilmRepository movieFilmRepository;
    private final RemoteRepository remoteRepository;
    private volatile static MovieFilmRepository INSTANCE = null;
    private final LocalRepository localRepository;
    private final AppExecutors appExecutor;

    public MovieFilmRepository(@NonNull LocalRepository localRepository, @NonNull RemoteRepository remoteRepository, AppExecutors appExecutor) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
        this.appExecutor = appExecutor;
    }

    public static MovieFilmRepository getInstance(LocalRepository localRepository, RemoteRepository remoteRepository, AppExecutors appExecutor) {
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
        IddlingTesting.increment();
        return new NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutor) {
            @Override
            protected LiveData<List<MovieEntity>> loadFromDB() {
                return localRepository.getAllMovie();

            }

            @Override
            protected Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteRepository.getAllMovie();

            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                List<MovieEntity> movieEntityList = new ArrayList<>();
                for (MovieResponse movieResponse : data) {
                    movieEntityList.add(new MovieEntity(
                            movieResponse.getId(),
                            movieResponse.getImage(),
                            movieResponse.getJudul(),
                            movieResponse.getDeskripsi(),
                            movieResponse.getTanggalRilis(),
                            null
                    ));
                }
                localRepository.insertMovie(movieEntityList);
                Log.d("MovieTesting", "saveCallResult: masuk");
                if (!IddlingTesting.getIddlingTesting().isIdleNow()) {
                    IddlingTesting.decrement();
                }
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<List<TvshowEntity>>> getTvshowAll() {
        IddlingTesting.increment();
        return new NetworkBoundResource<List<TvshowEntity>, List<TvShowResponse>>(appExecutor) {
            @Override
            protected LiveData<List<TvshowEntity>> loadFromDB() {
                if (!IddlingTesting.getIddlingTesting().isIdleNow()) {
                    Log.d("TvshowTesting", "saveCallResult: decrement");
                    IddlingTesting.decrement();
                }
                return localRepository.getAllTvshow();

            }

            @Override
            protected Boolean shouldFetch(List<TvshowEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                return remoteRepository.getAllTvshow();
            }

            @Override
            protected void saveCallResult(List<TvShowResponse> data) {
                List<TvshowEntity> tvshowEntityList = new ArrayList<>();
                for (TvShowResponse tvShowResponse : data) {
                    tvshowEntityList.add(new TvshowEntity(
                            tvShowResponse.getId(),
                            tvShowResponse.getImage(),
                            tvShowResponse.getJudul(),
                            tvShowResponse.getDeskripsi(),
                            tvShowResponse.getTanggalRilis(),
                            null
                    ));
                }
                localRepository.insertTvshow(tvshowEntityList);
                Log.d("TvshowTesting", "saveCallResult: masuk");
                if (!IddlingTesting.getIddlingTesting().isIdleNow()) {
                    Log.d("TvshowTesting", "saveCallResult: decrement");
                    IddlingTesting.decrement();
                }
                else{
                    Log.d("TvshowTesting", "saveCallResult: error");
                }
            }
        }.asLiveData();

    }

    @Override
    public LiveData<Resource<List<MovieEntity>>> getMovieId(int id) {
        return new NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutor) {
            @Override
            protected LiveData<List<MovieEntity>> loadFromDB() {
                return localRepository.getAllMovieById(id);
            }

            @Override
            protected Boolean shouldFetch(List<MovieEntity> data) {
                return (data == null) || (data.size() == 0);

            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                MutableLiveData<ApiResponse<List<MovieResponse>>> movieResponse = new MutableLiveData<>();
                remoteRepository.getMovieById(id, new RemoteRepository.LoadMovieCallback() {
                    @Override
                    public void onSuccess(ApiResponse<List<MovieResponse>> movieSend) {
                        movieResponse.setValue(movieSend);
                    }

                    @Override
                    public void onNotAvailable() {

                    }
                });
                return movieResponse;

            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                List<MovieEntity> movieEntityList = new ArrayList<>();
                for (MovieResponse movieResponse : data) {
                    movieEntityList.add(new MovieEntity(
                            movieResponse.getId(),
                            movieResponse.getImage(),
                            movieResponse.getJudul(),
                            movieResponse.getDeskripsi(),
                            movieResponse.getTanggalRilis(),
                            null
                    ));
                }
                localRepository.insertMovie(movieEntityList);
            }
        }.asLiveData();

    }

    @Override
    public LiveData<Resource<List<TvshowEntity>>> getTvshowId(int id) {
        return new NetworkBoundResource<List<TvshowEntity>, List<TvShowResponse>>(appExecutor) {
            @Override
            protected LiveData<List<TvshowEntity>> loadFromDB() {
                return localRepository.getAllTvshoeById(id);

            }

            @Override
            protected Boolean shouldFetch(List<TvshowEntity> data) {
                return (data == null) || (data.size() == 0);

            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                MutableLiveData<ApiResponse<List<TvShowResponse>>> tvshowResponse = new MutableLiveData<>();

                remoteRepository.getTvshowById(id, new RemoteRepository.LoadTvshowCallback() {
                    @Override
                    public void onSuccess(ApiResponse<List<TvShowResponse>> tvshowSend) {
                        tvshowResponse.setValue(tvshowSend);

                    }

                    @Override
                    public void onNotAvailbale() {

                    }
                });
                return tvshowResponse;

            }

            @Override
            protected void saveCallResult(List<TvShowResponse> data) {
                List<TvshowEntity> tvshowEntityList = new ArrayList<>();
                for (TvShowResponse tvShowResponse : data) {
                    tvshowEntityList.add(new TvshowEntity(
                            tvShowResponse.getId(),
                            tvShowResponse.getImage(),
                            tvShowResponse.getJudul(),
                            tvShowResponse.getDeskripsi(),
                            tvShowResponse.getTanggalRilis(),
                            null
                    ));
                }
                localRepository.insertTvshow(tvshowEntityList);
            }
        }.asLiveData();

    }

    @Override
    public LiveData<Resource<PagedList<MovieEntity>>> getFavoriteMoviePage() {
        return new NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutor) {
            @Override
            protected LiveData<PagedList<MovieEntity>> loadFromDB() {
                return new LivePagedListBuilder<>(localRepository.getFavoritePaged(), 20).build();

            }

            @Override
            protected Boolean shouldFetch(PagedList<MovieEntity> data) {
                return false;
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
    public void setMovieFavorite(MovieEntity movie, boolean state) {
        Runnable runnable = () -> localRepository.setMovieFavorite(movie, state);
        appExecutor.diskIO().execute(runnable);

    }

    @Override
    public void setTvshowFavorite(TvshowEntity tvshow, boolean state) {
        Runnable runnable = () -> localRepository.setTvshowFavorite(tvshow, state);
        appExecutor.diskIO().execute(runnable);

    }

    @Override
    public LiveData<Resource<PagedList<TvshowEntity>>> getFavoriteTvshowPage() {
        return new NetworkBoundResource<PagedList<TvshowEntity>, List<TvShowResponse>>(appExecutor) {
            @Override
            protected LiveData<PagedList<TvshowEntity>> loadFromDB() {
                Log.d("favoritepage", "loadFromDB: "+localRepository.getTvshowFavoritePage());
                return new LivePagedListBuilder<>(localRepository.getTvshowFavoritePage(), 20).build();
            }

            @Override
            protected Boolean shouldFetch(PagedList<TvshowEntity> data) {
                return false;
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                return null;
            }

            @Override
            protected void saveCallResult(List<TvShowResponse> data) {

            }
        }.asLiveData();
    }

    @Override
    public void deleteById(int movieId) {
        Runnable runnable= () -> localRepository.deleteMovie(movieId);
        appExecutor.diskIO().execute(runnable);

    }
}
