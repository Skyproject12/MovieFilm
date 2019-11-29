package com.example.moviefilm.Ui.Detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Utils.FakeDataDummy;
import com.example.moviefilm.ViewModel.Detail.DetailViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule= new InstantTaskExecutorRule();

    private DetailViewModel detailViewModel;
    private MovieEntity movieEntity = FakeDataDummy.generateMovie().get(0);
    private ArrayList<MovieEntity> listDummy= new ArrayList<>();
    private MovieFilmRepository movieFilmRepository= mock(MovieFilmRepository.class);
    private int movieId= movieEntity.getId();

    @Before
    public void setUp(){
        detailViewModel= new DetailViewModel(movieFilmRepository);
        detailViewModel.setMovieId(movieId);
    }

    @Test
    public  void getDetail(){
        listDummy.add(movieEntity);
        MutableLiveData<ArrayList<MovieEntity>> modulEntity= new MutableLiveData<>();
        ArrayList<MovieEntity> listM= new ArrayList<>();
        listM.add(movieEntity);
        modulEntity.setValue(listM);
        when(movieFilmRepository.getMovieId(movieId)).thenReturn(modulEntity);
        Observer<ArrayList<MovieEntity>> observer= mock(Observer.class);
        detailViewModel.getMovieId(movieId).observeForever(observer);
        verify(observer).onChanged(listDummy);
    }

}