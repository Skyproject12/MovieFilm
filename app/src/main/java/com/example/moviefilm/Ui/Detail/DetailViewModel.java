package com.example.moviefilm.Ui.Detail;

import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.source.remote.Response.Movie;
import com.example.moviefilm.Util.DataDummy;

public class DetailViewModel extends ViewModel {

    Movie getList(int id){
        return DataDummy.getIdMovie( id);
    }

}
