package com.example.moviefilm.Ui.Detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.R;
import com.example.moviefilm.ViewModel.Detail.DetailShowViewModel;
import com.example.moviefilm.ViewModel.ViewModelFactory;
import com.squareup.picasso.Picasso;

public class DetailShowActivity extends AppCompatActivity {

    TvshowEntity movie;
    ImageView imageMovie;
    TextView textJudulMovie;
    TextView texttanggalMovie;
    TextView textDeskripsiMovie;
    private DetailShowViewModel detailShowViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        movie = getIntent().getParcelableExtra("tvshow");
        initial();
        setText();
    }

    private void initial() {
        imageMovie = findViewById(R.id.image_movie);
        textJudulMovie = findViewById(R.id.tex_judulmovie);
        texttanggalMovie = findViewById(R.id.textjadwal_movie);
        textDeskripsiMovie = findViewById(R.id.text_deskripsimovie);
        detailShowViewModel = obtainViewModel(DetailShowActivity.this);

    }

    private void setText() {
        detailShowViewModel.getTvshoId(movie.getId()).observe(this, tvshowId -> {
            if (tvshowId != null) {
                switch (tvshowId.status) {
                    case LOADING:
                        break;
                    case SUCCESS:
                        Picasso.get().load(tvshowId.data.get(0).getImage()).into(imageMovie);
                        textJudulMovie.setText(tvshowId.data.get(0).getJudul());

                        texttanggalMovie.setText(tvshowId.data.get(0).getTanggalRilis());
                        textDeskripsiMovie.setText(tvshowId.data.get(0).getDeskripsi());
                        getSupportActionBar().setTitle("Detail MovieEntity");
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                        break;
                    case ERROR:
                        break;

                }
            }
        });
    }

    private static DetailShowViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(DetailShowViewModel.class);
    }
}
