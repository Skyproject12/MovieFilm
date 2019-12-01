package com.example.moviefilm.Ui.Detail;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.Utils.FakeDataDummy;
import com.example.moviefilm.ValueObject.Resource;
import com.example.moviefilm.ViewModel.Detail.DetailShowViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        Resource<List<TvshowEntity>> resource= Resource.success(FakeDataDummy.generateTvshowWithFavorite(tvshowEntity, true));
        MutableLiveData<Resource<List<TvshowEntity>>> dummyMovie= new MutableLiveData<>();
        dummyMovie.setValue(resource);
        when(movieFilmRepository.getTvshowId(tvshowId)).thenReturn(dummyMovie);
        Observer<Resource<List<TvshowEntity>>> observer= mock(Observer.class);
        detailShowViewModel.getTvshowId.observeForever(observer);
        verify(observer).onChanged(resource);
    }

}