package com.example.moviefilm.ViewModel.Favorite;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.ValueObject.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TvshowFavoriteViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule= new InstantTaskExecutorRule();
    private TvshowFavoriteViewModel tvshowFavoriteViewModel;
    private MovieFilmRepository movieFilmRepository = mock(MovieFilmRepository.class);

    @Before
    public void setUp() {
        tvshowFavoriteViewModel = new TvshowFavoriteViewModel(movieFilmRepository);

    }

    @Test
    public void getFavorite() {
        MutableLiveData<Resource<PagedList<TvshowEntity>>> dummyMovie= new MutableLiveData<>();
        PagedList<TvshowEntity> pagedList= mock(PagedList.class);
        dummyMovie.setValue(Resource.success(pagedList));
        when(movieFilmRepository.getFavoriteTvshowPage()).thenReturn(dummyMovie);
        Observer<Resource<PagedList<TvshowEntity>>> observer= mock(Observer.class);
        tvshowFavoriteViewModel.getFavoriteTvshow().observeForever(observer);
        verify(observer).onChanged(Resource.success(pagedList));

    }
}