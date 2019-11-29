package com.example.moviefilm.Di;

import android.app.Application;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.remote.RemoteRepository;
import com.example.moviefilm.Util.ApiHelper;

public class Injection {
    public static MovieFilmRepository provideRepository(Application application){
        RemoteRepository remoteRepository= RemoteRepository.getInstance(new ApiHelper(application));
        return MovieFilmRepository.getInstance(remoteRepository);

    }
}
