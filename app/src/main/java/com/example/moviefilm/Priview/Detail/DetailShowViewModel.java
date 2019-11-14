package com.example.moviefilm.Priview.Detail;

import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.Request.Movie;
import com.example.moviefilm.Util.DataDummy;

public class DetailShowViewModel extends ViewModel {

    Movie getListm(int id){
        return DataDummy.getIdShow(id);
    }

}
