package com.example.moviefilm.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Di.Injection;
import com.example.moviefilm.ViewModel.Detail.DetailShowViewModel;
import com.example.moviefilm.ViewModel.Detail.DetailViewModel;
import com.example.moviefilm.ViewModel.Favorite.MovieFavoriteViewModel;
import com.example.moviefilm.ViewModel.Favorite.TvshowFavoriteViewModel;
import com.example.moviefilm.ViewModel.Movie.MovieViewModel;
import com.example.moviefilm.ViewModel.TvShow.ShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    MovieFilmRepository movieFilmRepository;

    private ViewModelFactory(MovieFilmRepository movieFilmRepository) {
        this.movieFilmRepository = movieFilmRepository;
    }

    public static ViewModelFactory getInstance(Application application) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
                }
            }
        }
        return INSTANCE;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(movieFilmRepository);

        } else if (modelClass.isAssignableFrom(ShowViewModel.class)) {
            return (T) new ShowViewModel(movieFilmRepository);

        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(movieFilmRepository);

        } else if (modelClass.isAssignableFrom(DetailShowViewModel.class)) {
            return (T) new DetailShowViewModel(movieFilmRepository);

        } else if (modelClass.isAssignableFrom(MovieFavoriteViewModel.class)) {
            return (T) new MovieFavoriteViewModel(movieFilmRepository);

        }
        else if(modelClass.isAssignableFrom(TvshowFavoriteViewModel.class)){
            return (T) new TvshowFavoriteViewModel(movieFilmRepository);

        }
        throw new IllegalArgumentException("Unknow ViewModel" + modelClass.getName());

    }
}
