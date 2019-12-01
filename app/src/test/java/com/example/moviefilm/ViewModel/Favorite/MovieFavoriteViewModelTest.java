package com.example.moviefilm.ViewModel.Favorite;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.ValueObject.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieFavoriteViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private MovieFavoriteViewModel movieFavoriteViewModel;
    private MovieFilmRepository movieFilmRepository = mock(MovieFilmRepository.class);

    @Before
    public void setUp() {
        movieFavoriteViewModel = new MovieFavoriteViewModel(movieFilmRepository);

    }

    @Test
    public void getFavorite() {
        MutableLiveData<Resource<PagedList<MovieEntity>>> dummyMovie= new MutableLiveData<>();
        PagedList<MovieEntity> pagedList= mock(PagedList.class);
        dummyMovie.setValue(Resource.success(pagedList));
        when(movieFilmRepository.getFavoriteMoviePage()).thenReturn(dummyMovie);
        Observer<Resource<PagedList<MovieEntity>>> observer= mock(Observer.class);
        movieFavoriteViewModel.getFavoriteMovie().observeForever(observer);
        verify(observer).onChanged(Resource.success(pagedList));

    }
}