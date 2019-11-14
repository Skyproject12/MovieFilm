package com.example.moviefilm.Priview.Detail;

import com.example.moviefilm.Data.Request.Movie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailShowViewModelTest {

    private DetailShowViewModel detailShowViewModel;
    @Before
    public void setUp(){
        detailShowViewModel= new DetailShowViewModel();
    }

    @Test
    public  void getDetail(){

        Movie list= detailShowViewModel.getListm(1);
        assertNotNull(list);
        assertEquals("Arrow",list.getJudul());

    }

}