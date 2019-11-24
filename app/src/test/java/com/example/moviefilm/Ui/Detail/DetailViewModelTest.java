package com.example.moviefilm.Ui.Detail;

import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.ViewModel.Detail.DetailViewModel;

import org.junit.Before;
import org.junit.Test;

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

}