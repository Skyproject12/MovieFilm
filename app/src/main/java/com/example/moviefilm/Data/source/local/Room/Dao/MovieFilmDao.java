package com.example.moviefilm.Data.source.local.Room.Dao;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;

import java.util.List;

@Dao
public interface MovieFilmDao {
  @WorkerThread
  @Query("SELECT * FROM movie")
  LiveData<List<MovieEntity>> getMovie();

  @WorkerThread
  @Query(("SELECT * FROM tvshow"))
  LiveData<List<TvshowEntity>> getTvshow();

  @Transaction
  @Query("SELECT * FROM movie WHERE movieId = :movieId")
  LiveData<List<MovieEntity>> getMovieById(int movieId);

  @Transaction
  @Query("SELECT * FROM tvshow WHERE tvshowId= :tvshowId")
  LiveData<List<TvshowEntity>> getTvshowId(int tvshowId);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long[] insertMovie(List<MovieEntity> movie);

  @Insert(onConflict= OnConflictStrategy.REPLACE)
  long[] insertTvshow(List<TvshowEntity> tvshow);

}
