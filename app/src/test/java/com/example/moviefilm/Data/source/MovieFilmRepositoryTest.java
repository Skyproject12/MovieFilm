package com.example.moviefilm.Data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.Data.source.local.TvshowEntity;
import com.example.moviefilm.Data.source.remote.RemoteRepository;
import com.example.moviefilm.Data.source.remote.Response.MovieResponse;
import com.example.moviefilm.Data.source.remote.Response.TvShowResponse;
import com.example.moviefilm.Utils.FakeDataDummy;
import com.example.moviefilm.Utils.LiveDataTestUtils;

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

public class MovieFilmRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule= new InstantTaskExecutorRule();
    private RemoteRepository remote= Mockito.mock(RemoteRepository.class);
    private FakeMovieFilmRepository movieFilmRepository= new FakeMovieFilmRepository(remote);
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
        doAnswer(invocation -> {
            // melakukan pengecekan untuk repository
            ((RemoteRepository.LoadMovieCallback) invocation.getArguments()[0]).onSuccess(movie);
            return null;
        }).when(remote).getMovie(any(RemoteRepository.LoadMovieCallback.class));
        List<Movie> result= LiveDataTestUtils.getValue(movieFilmRepository.getMovieAll());
        verify(remote, times(1)).getMovie(any(RemoteRepository.LoadMovieCallback.class));
        assertNotNull(result);
        assertEquals(movie.size(), result.size());
    }

    @Test
    public void getAllTvshow(){
        // melakukan pengecekan apakah fake data sesuai dengan response dari aplikasi
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTvshowCallback) invocation.getArguments()[0]).onSuccess(tvshow);
            return null;
        }).when(remote).getTvshow(any(RemoteRepository.LoadTvshowCallback.class));
        List<TvshowEntity> result= LiveDataTestUtils.getValue(movieFilmRepository.getTvshowAll());
        verify(remote, times(1)).getTvshow(any(RemoteRepository.LoadTvshowCallback.class));
        assertNotNull(result);
        assertEquals(tvshow.size(), result.size());

    }

    @Test
    public void getMovieId(){
        doAnswer(invocation -> {
            ((RemoteRepository.LoadMovieCallback) invocation.getArguments()[1]).onSuccess(movie);
            return null;
        }).when(remote).getMovieById(eq(movieId), any(RemoteRepository.LoadMovieCallback.class));
        List<Movie> result= LiveDataTestUtils.getValue(movieFilmRepository.getMovieId(movieId));
        verify(remote, times(1)).getMovieById(eq(movieId), any(RemoteRepository.LoadMovieCallback.class));
        assertNotNull(result);
        assertEquals(movieResponseId.size(), result.size());
    }

    @Test
    public void getShowId(){
        doAnswer(invocation -> {
            ((RemoteRepository.LoadTvshowCallback) invocation.getArguments()[1]).onSuccess(tvshow);
            return null;
        }).when(remote).getTvshowById(eq(tvshowId), any(RemoteRepository.LoadTvshowCallback.class));
        List<TvshowEntity> result= LiveDataTestUtils.getValue(movieFilmRepository.getTvshowId(tvshowId));
        verify(remote, times(1)).getTvshowById(eq(tvshowId), any(RemoteRepository.LoadTvshowCallback.class));
        assertNotNull(result);
        assertEquals(tvShowResponseId.size(), result.size());

    }

}