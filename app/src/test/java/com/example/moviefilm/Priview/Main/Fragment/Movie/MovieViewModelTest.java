package com.example.moviefilm.Priview.Main.Fragment.Movie;

import com.example.moviefilm.Data.Request.Movie;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {

    private MovieViewModel movieViewModel;
    @Before
    public void setUp(){
        movieViewModel= new MovieViewModel();

    }
    @Test
    public void getMovie(){

        List<Movie> movie= movieViewModel.getMovie();
        // check apakah movie kosong atau tidak
        assertNotNull(movie);
        // check expectation and actual size
        assertEquals(11,movie.size());

    }

}