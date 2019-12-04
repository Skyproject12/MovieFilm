package com.example.moviefilm.Ui.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.R;
import com.example.moviefilm.Ui.Main.MainActivity;
import com.example.moviefilm.ViewModel.Detail.DetailShowViewModel;
import com.example.moviefilm.ViewModel.ViewModelFactory;
import com.squareup.picasso.Picasso;

public class DetailShowActivity extends AppCompatActivity {

    MovieEntity movie;
    ImageView imageMovie;
    TextView textJudulMovie;
    TextView texttanggalMovie;
    TextView textDeskripsiMovie;
    private DetailShowViewModel detailShowViewModel;
    private Menu menu;


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
        detailShowViewModel.setTvshowId(movie.getId());
        detailShowViewModel.getTvshowId.observe(this, tvshowId -> {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_favorite, menu);
        detailShowViewModel.getTvshowId.observe(this, tvshowId -> {
            if (tvshowId != null) {
                switch (tvshowId.status) {
                    case LOADING:
                        break;
                    case SUCCESS:
                        boolean state = tvshowId.data.get(0).getFavorite();
                        setFavoriteState(state);
                        break;
                    case ERROR:
                        break;

                }
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void setFavoriteState(boolean state) {
        if (menu == null) return;
        MenuItem menuItem = menu.findItem(R.id.favorite);
        if (state) {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_star));

        } else {
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_border));

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorite:
                detailShowViewModel.setFavorite();
                break;
            case R.id.home:
                Intent intent = new Intent(DetailShowActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
