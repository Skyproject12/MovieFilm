package com.example.moviefilm.Ui.Main.Fragment.Movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Utils.FakeDataDummy;
import com.example.moviefilm.ValueObject.Resource;
import com.example.moviefilm.ViewModel.Movie.MovieViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class MovieEntityViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel movieViewModel;
    private MovieFilmRepository movieFilmRepository = mock(MovieFilmRepository.class);

    @Before
    public void setUp() {
        movieViewModel = new MovieViewModel(movieFilmRepository);

    }

    @Test
    public void getMovie() {
        Resource<List<MovieEntity>> resource= Resource.success(FakeDataDummy.generateMovie());
        MutableLiveData<Resource<List<MovieEntity>>> dummyMovie= new MutableLiveData<>();
        dummyMovie.setValue(resource);
        when(movieFilmRepository.getMovieAll()).thenReturn(dummyMovie);
        Observer<Resource<List<MovieEntity>>> observer= mock(Observer.class);
        movieViewModel.getMovie().observeForever(observer);
        verify(observer).onChanged(resource);
    }

}