package com.example.moviefilm.Data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.example.moviefilm.Data.source.local.LocalRepository;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.Data.source.remote.RemoteRepository;
import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;
import com.example.moviefilm.Utils.FakeDataDummy;
import com.example.moviefilm.Utils.InstantAppExecutors;
import com.example.moviefilm.Utils.LiveDataTestUtils;
import com.example.moviefilm.ValueObject.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieEntityFilmRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule= new InstantTaskExecutorRule();
    private LocalRepository local= Mockito.mock(LocalRepository.class);
    private RemoteRepository remote= Mockito.mock(RemoteRepository.class);
    InstantAppExecutors instantAppExecutors= Mockito.mock(InstantAppExecutors.class);
    private FakeMovieFilmRepository movieFilmRepository= new FakeMovieFilmRepository(local,remote, instantAppExecutors);
    private ArrayList<MovieResponse> movie= FakeDataDummy.generateMovieResponse();
    private int movieId= movie.get(0).getId();
    private ArrayList<MovieResponse> movieResponseId= FakeDataDummy.getMovieResponseId(movieId);
    private ArrayList<TvShowResponse> tvshow= FakeDataDummy.generateShowResponse();
    private int tvshowId= tvshow.get(0).getId();
    private ArrayList<TvShowResponse> tvShowResponseId=FakeDataDummy.getShowResponseId(tvshowId);
    @Before
    public void setUp(){

    }
    @After
    public void tearDown(){

    }
    @Test
    public void getAllMovie(){
        MutableLiveData<List<MovieEntity>> dummyMovie= new MutableLiveData<>();
        dummyMovie.setValue(FakeDataDummy.generateMovie());
        when(local.getAllMovie()).thenReturn(dummyMovie);
        Resource<List<MovieEntity>> result= LiveDataTestUtils.getValue(movieFilmRepository.getMovieAll());
        verify(local).getAllMovie();
        assertNotNull(result.data);
        assertEquals(movie.size(), result.data.size());
    }

    @Test
    public void getAllTvshow(){
        MutableLiveData<List<TvshowEntity>> dummyMovie= new MutableLiveData<>();
        dummyMovie.setValue(FakeDataDummy.generateShow());
        when(local.getAllTvshow()).thenReturn(dummyMovie);
        Resource<List<TvshowEntity>> result= LiveDataTestUtils.getValue(movieFilmRepository.getTvshowAll());
        verify(local).getAllTvshow();
        assertNotNull(result.data);
        assertEquals(tvshow.size(), result.data.size());

    }

    @Test
    public void getMovieId(){
        MutableLiveData<List<MovieEntity>> dummyMovie= new MutableLiveData<>();
        dummyMovie.setValue(FakeDataDummy.generateMovieWithFavorite(FakeDataDummy.generateMovie().get(0), false));
        when(local.getAllMovieById(movieId)).thenReturn(dummyMovie);
        Resource<List<MovieEntity>> result= LiveDataTestUtils.getValue(movieFilmRepository.getMovieId(movieId));
        verify(local).getAllMovieById(movieId);

        assertNotNull(result.data);
        assertNotNull(result.data.get(0).getJudul());
        assertEquals(movie.get(0).getJudul(), result.data.get(0).getJudul());

    }

    @Test
    public void getShowId(){
        MutableLiveData<List<TvshowEntity>> dummyMovie= new MutableLiveData<>();
        dummyMovie.setValue(FakeDataDummy.generateTvshowWithFavorite(FakeDataDummy.generateShow().get(0), false));
        when(local.getAllTvshoeById(tvshowId)).thenReturn(dummyMovie);
        Resource<List<TvshowEntity>> result= LiveDataTestUtils.getValue(movieFilmRepository.getTvshowId(tvshowId));
        verify(local).getAllTvshoeById(tvshowId);

        assertNotNull(result.data);
        assertNotNull(result.data.get(0).getJudul());
        assertEquals(tvshow.get(0).getJudul(), result.data.get(0).getJudul());

    }

}