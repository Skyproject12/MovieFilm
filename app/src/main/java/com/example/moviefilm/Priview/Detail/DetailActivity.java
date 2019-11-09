package com.example.moviefilm.Priview.Detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

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
    private DetailViewModel detailViewModel; 
    private String local;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        movie= getIntent().getParcelableExtra("film"); 
        local= getIntent().getStringExtra("status");
        initial();
        setText();
    }
    private void initial(){
        imageMovie= findViewById(R.id.image_movie);
        textJudulMovie= findViewById(R.id.tex_judulmovie);
        textPembuatMovie= findViewById(R.id.text_pembuatmovie);
        texttanggalMovie= findViewById(R.id.textjadwal_movie);
        textDeskripsiMovie= findViewById(R.id.text_deskripsimovie);
        detailViewModel= ViewModelProviders.of(DetailActivity.this).get(DetailViewModel.class);


    }
    private void setText(){
        
        Movie list = null;
        if(local.equals("movie")) {
            list = detailViewModel.getList(movie.getId()); 
            
        } 
        else if(local.equals("tvshow")){ 
            list= detailViewModel.getListm(movie.getId()); 
            
        }
        imageMovie.setImageResource(list.getImage());
        textJudulMovie.setText(list.getJudul());
        textPembuatMovie.setText(list.getPembuat());
        texttanggalMovie.setText(list.getTanggalRilis());
        textDeskripsiMovie.setText(list.getDeskripsi());
        getSupportActionBar().setTitle("Detail Movie");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
