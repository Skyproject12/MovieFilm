package com.example.moviefilm.Ui.Main.Fragment.TvShow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.Utils.FakeDataDummy;
import com.example.moviefilm.ViewModel.TvShow.ShowViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShowViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule= new InstantTaskExecutorRule();

    private ShowViewModel showViewModel;
    private MovieFilmRepository movieFilmRepository = mock(MovieFilmRepository.class);

    @Before
    public void setUp() {
        showViewModel = new ShowViewModel(movieFilmRepository);

    }

    @Test
    public void getShow() {
        ArrayList<TvshowEntity> dummyTvshow = FakeDataDummy.generateShow();
        MutableLiveData<ArrayList<TvshowEntity>> tvshow = new MutableLiveData<>();
        tvshow.setValue(dummyTvshow);
        when(movieFilmRepository.getTvshowAll()).thenReturn(tvshow);
        Observer<List<TvshowEntity>> observer = mock(Observer.class);
        showViewModel.getShow().observeForever(observer);
        verify(observer).onChanged(dummyTvshow);
    }

}