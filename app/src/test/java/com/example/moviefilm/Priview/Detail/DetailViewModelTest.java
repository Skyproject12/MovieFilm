package com.example.moviefilm.Priview.Detail;

import com.example.moviefilm.Data.Request.Movie;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DetailViewModelTest {

    private DetailViewModel detailViewModel;
    @Before
    public void setUp(){
        detailViewModel= new DetailViewModel();
    }

    @Test
    public  void getDetail(){

        Movie list= detailViewModel.getList(1);
        assertNotNull(list);
        assertEquals("Advenger Invinity",list.getJudul());

    }
    @Test
    public void getDetailm(){

        Movie list= detailViewModel.getListm(1);
        assertNotNull(list);
        assertEquals("glass", list.getJudul());

    }

}