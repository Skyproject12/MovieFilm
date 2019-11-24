package com.example.moviefilm.Ui.Detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.R;
import com.example.moviefilm.ViewModel.Detail.DetailViewModel;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    Movie movie;
    ImageView imageMovie;
    TextView textJudulMovie;
    TextView textPembuatMovie;
    TextView texttanggalMovie;
    TextView textDeskripsiMovie;
    private DetailViewModel detailViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        movie = getIntent().getParcelableExtra("film");
        initial();
        setText();
    }

    private void initial() {
        imageMovie = findViewById(R.id.image_movie);
        textJudulMovie = findViewById(R.id.tex_judulmovie);
        texttanggalMovie = findViewById(R.id.textjadwal_movie);
        textDeskripsiMovie = findViewById(R.id.text_deskripsimovie);
        detailViewModel = ViewModelProviders.of(DetailActivity.this).get(DetailViewModel.class);


    }

    private void setText() {
        Movie list = null;
        list = detailViewModel.getList(movie.getId());
        Picasso.get().load(list.getImage()).into(imageMovie);
        textJudulMovie.setText(list.getJudul());
        texttanggalMovie.setText(list.getTanggalRilis());
        textDeskripsiMovie.setText(list.getDeskripsi());
        getSupportActionBar().setTitle("Detail Movie");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
