package com.example.moviefilm.Priview.Main.Fragment.TvShow;

import com.example.moviefilm.Data.Request.Movie;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ShowViewModelTest {

    private ShowViewModel showViewModel;
    @Before
    public void setUp(){

        showViewModel= new ShowViewModel();

    }

    @Test
    public void getShow(){

        List<Movie> movies= showViewModel.getShow();
        assertNotNull(movies);
        assertEquals(10, movies.size());

    }

}