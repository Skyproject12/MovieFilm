package com.example.moviefilm.Ui.Main.Fragment.TvShow;

import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.remote.Response.Movie;
import com.example.moviefilm.Util.DataDummy;

import java.util.List;

public class ShowViewModel extends ViewModel {

    public List<Movie> getShow(){
        return DataDummy.generateShow();

    }

}
