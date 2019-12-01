package com.example.moviefilm.Ui.Main.Fragment.TvShow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.Utils.FakeDataDummy;
import com.example.moviefilm.ValueObject.Resource;
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
        Resource<List<TvshowEntity>> resource= Resource.success(FakeDataDummy.generateShow());
        MutableLiveData<Resource<List<TvshowEntity>>> dummyTvshow= new MutableLiveData<>();
        dummyTvshow.setValue(resource);
        when(movieFilmRepository.getTvshowAll()).thenReturn(dummyTvshow);
        Observer<Resource<List<TvshowEntity>>> observer= mock(Observer.class);
        showViewModel.getShow().observeForever(observer);
        verify(observer).onChanged(resource);
    }

}