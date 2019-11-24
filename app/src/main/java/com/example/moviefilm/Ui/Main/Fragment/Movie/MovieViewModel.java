package com.example.moviefilm.Ui.Main.Fragment.Movie;

import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.remote.Response.Movie;
import com.example.moviefilm.Util.DataDummy;

import java.util.List;

public class MovieViewModel extends ViewModel {

    public List<Movie> getMovie(){
        return DataDummy.generateMovie();
    }

}
