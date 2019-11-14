package com.example.moviefilm.Priview.Detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.moviefilm.Data.Request.Movie;
import com.example.moviefilm.R;

public class DetailShowActivity extends AppCompatActivity {

    Movie movie;
    ImageView imageMovie;
    TextView textJudulMovie;
    TextView textPembuatMovie;
    TextView texttanggalMovie;
    TextView textDeskripsiMovie;
    private DetailShowViewModel detailShowViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        movie= getIntent().getParcelableExtra("tvshow");
        initial();
        setText();
    }
    private void initial(){
        imageMovie= findViewById(R.id.image_movie);
        textJudulMovie= findViewById(R.id.tex_judulmovie);
        textPembuatMovie= findViewById(R.id.text_pembuatmovie);
        texttanggalMovie= findViewById(R.id.textjadwal_movie);
        textDeskripsiMovie= findViewById(R.id.text_deskripsimovie);
        detailShowViewModel= ViewModelProviders.of(DetailShowActivity.this).get(DetailShowViewModel.class);


    }
    private void setText(){
        Movie list = null;
        list= detailShowViewModel.getListm(movie.getId());
        imageMovie.setImageResource(list.getImage());
        textJudulMovie.setText(list.getJudul());
        textPembuatMovie.setText(list.getPembuat());
        texttanggalMovie.setText(list.getTanggalRilis());
        textDeskripsiMovie.setText(list.getDeskripsi());
        getSupportActionBar().setTitle("Detail Movie");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
