package com.example.moviefilm.Ui.Detail;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.Utils.FakeDataDummy;
import com.example.moviefilm.ViewModel.Detail.DetailShowViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule= new InstantTaskExecutorRule();

    private DetailShowViewModel detailShowViewModel;
    private TvshowEntity tvshowEntity= FakeDataDummy.generateShow().get(0);
    private ArrayList<TvshowEntity> listDummy= new ArrayList<>();
    private MovieFilmRepository movieFilmRepository= mock(MovieFilmRepository.class);
    private int tvshowId= tvshowEntity.getId();

    @Before
    public void setUp(){
        detailShowViewModel= new DetailShowViewModel(movieFilmRepository);
        detailShowViewModel.setTvshowId(tvshowId);
    }

    @Test
    public  void getDetail(){
        listDummy.add(tvshowEntity);
        MutableLiveData<ArrayList<TvshowEntity>> modulEntity= new MutableLiveData<>();
        ArrayList<TvshowEntity> listM= new ArrayList<>();
        listM.add(tvshowEntity);
        modulEntity.setValue(listM);
        when(movieFilmRepository.getTvshowId(tvshowId)).thenReturn(modulEntity);
        Observer<ArrayList<TvshowEntity>> observer= mock(Observer.class);
        detailShowViewModel.getTvshoId(tvshowId).observeForever(observer);
        verify(observer).onChanged(listDummy);
    }

}