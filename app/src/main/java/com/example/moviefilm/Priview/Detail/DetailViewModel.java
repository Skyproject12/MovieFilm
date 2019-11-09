package com.example.moviefilm.Priview.Detail;

import androidx.lifecycle.ViewModel;

import com.example.moviefilm.Data.Request.Movie;
import com.example.moviefilm.Util.DataDummy;

public class DetailViewModel extends ViewModel {

    Movie getList(int id){

        return DataDummy.getIdMovie( id);

    }
    Movie getListm(int id){

        return DataDummy.getIdShow(id);

    }

}
