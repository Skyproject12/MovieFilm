package com.example.moviefilm.Ui.Detail;

import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.remote.Response.Movie;
import com.example.moviefilm.Util.DataDummy;

public class DetailShowViewModel extends ViewModel {

    Movie getListm(int id){
        return DataDummy.getIdShow(id);
    }

}
