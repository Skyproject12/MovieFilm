package com.example.moviefilm.Di;

import android.app.Application;

import com.example.moviefilm.Data.source.MovieFilmRepository;
import com.example.moviefilm.Data.source.local.LocalRepository;
import com.example.moviefilm.Data.source.local.Room.Database.MovieFilmDatabase;
import com.example.moviefilm.Data.source.remote.RemoteRepository;
import com.example.moviefilm.Util.ApiHelper;
import com.example.moviefilm.Util.AppExecutors;

public class Injection {
    public static MovieFilmRepository provideRepository(Application application){
        MovieFilmDatabase database= MovieFilmDatabase.getInstance(application);
        LocalRepository localRepository= LocalRepository.getInstance(database.movieFilmDao());
        RemoteRepository remoteRepository= RemoteRepository.getInstance(new ApiHelper(application));
        AppExecutors appExecutors= new AppExecutors();
        return MovieFilmRepository.getInstance(localRepository, remoteRepository, appExecutors);


    }
}
