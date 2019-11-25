package com.example.moviefilm.Ui.Detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.R;
import com.example.moviefilm.ViewModel.Detail.DetailViewModel;
import com.example.moviefilm.ViewModel.ViewModelFactory;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    Movie movie;
    ImageView imageMovie;
    TextView textJudulMovie;
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
        detailViewModel= obtainViewModel(DetailActivity.this);


    }

    private void setText() {
        detailViewModel.getMovieId(movie.getId()).observe(this, movieId-> {
            Picasso.get().load(movieId.get(0).getImage()).into(imageMovie);
            textJudulMovie.setText(movieId.get(0).getJudul());
            texttanggalMovie.setText(movieId.get(0).getTanggalRilis());
            textDeskripsiMovie.setText(movieId.get(0).getDeskripsi());
            getSupportActionBar().setTitle("Detail Movie");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        });
    }

    private static DetailViewModel obtainViewModel(AppCompatActivity activity){
        ViewModelFactory factory= ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(DetailViewModel.class);
    }
}
