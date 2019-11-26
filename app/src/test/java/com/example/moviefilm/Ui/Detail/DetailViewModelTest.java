package com.example.moviefilm.Ui.Detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.Utils.FakeDataDummy;
import com.example.moviefilm.ViewModel.Detail.DetailViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule= new InstantTaskExecutorRule();

    private DetailViewModel detailViewModel;
    private Movie movie= FakeDataDummy.generateMovie().get(0);
    private ArrayList<Movie> listDummy= new ArrayList<>();
    private MovieFilmRepository movieFilmRepository= mock(MovieFilmRepository.class);
    private int movieId= movie.getId();

    @Before
    public void setUp(){
        detailViewModel= new DetailViewModel(movieFilmRepository);
        detailViewModel.setMovieId(movieId);
    }

    @Test
    public  void getDetail(){
        listDummy.add(movie);
        MutableLiveData<ArrayList<Movie>> modulEntity= new MutableLiveData<>();
        ArrayList<Movie> listM= new ArrayList<>();
        listM.add(movie);
        modulEntity.setValue(listM);
        when(movieFilmRepository.getMovieId(movieId)).thenReturn(modulEntity);
        Observer<ArrayList<Movie>> observer= mock(Observer.class);
        detailViewModel.getMovieId(movieId).observeForever(observer);
        verify(observer).onChanged(listDummy);
    }

}