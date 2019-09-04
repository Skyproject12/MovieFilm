package com.example.moviefilm.Priview.Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviefilm.Data.Request.Movie;
import com.example.moviefilm.R;

public class DetailActivity extends AppCompatActivity {

    Movie movie;
    ImageView imageMovie;
    TextView textJudulMovie;
    TextView textPembuatMovie;
    TextView texttanggalMovie;
    TextView textDeskripsiMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        movie= getIntent().getParcelableExtra("film");
        initial();
        setText();
    }
    private void initial(){
        imageMovie= findViewById(R.id.image_movie);
        textJudulMovie= findViewById(R.id.tex_judulmovie);
        textPembuatMovie= findViewById(R.id.text_pembuatmovie);
        texttanggalMovie= findViewById(R.id.textjadwal_movie);
        textDeskripsiMovie= findViewById(R.id.text_deskripsimovie);
    }
    private void setText(){
        imageMovie.setImageResource(movie.getImage());
        textJudulMovie.setText(movie.getJudul());
        textPembuatMovie.setText(movie.getPembuat());
        texttanggalMovie.setText(movie.getTanggalRilis());
        textDeskripsiMovie.setText(movie.getDeskripsi());
        getSupportActionBar().setTitle("Detail Movie");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
