package com.example.moviefilm.Data.source.local.Room.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.moviefilm.Data.source.local.Room.Dao.MovieFilmDao;
import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;

@Database(entities = {MovieEntity.class, TvshowEntity.class}, version = 1, exportSchema = false)
public abstract class MovieFilmDatabase extends RoomDatabase {
    private static MovieFilmDatabase INSTANCE;

    public abstract MovieFilmDao movieFilmDao();

    private static final Object slock = new Object();

    public static MovieFilmDatabase getInstance(Context context) {
        synchronized (slock) {
            if (INSTANCE == null)
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MovieFilmDatabase.class, "MovieFilm.db").build();
        }
        return INSTANCE;
    }
}
