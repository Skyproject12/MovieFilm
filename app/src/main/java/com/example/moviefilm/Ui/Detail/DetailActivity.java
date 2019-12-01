package com.example.moviefilm.Ui.Detail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.R;
import com.example.moviefilm.Ui.Main.MainActivity;
import com.example.moviefilm.ViewModel.Detail.DetailViewModel;
import com.example.moviefilm.ViewModel.ViewModelFactory;
import com.squareup.picasso.Picasso;

import static com.example.moviefilm.ValueObject.Status.ERROR;
import static com.example.moviefilm.ValueObject.Status.LOADING;
import static com.example.moviefilm.ValueObject.Status.SUCCESS;

public class DetailActivity extends AppCompatActivity {

    MovieEntity movieEntity;
    ImageView imageMovie;
    TextView textJudulMovie;
    TextView texttanggalMovie;
    TextView textDeskripsiMovie;
    private DetailViewModel detailViewModel;
    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        movieEntity = getIntent().getParcelableExtra("film");
        initial();
        setText();
    }

    private void initial() {
        imageMovie = findViewById(R.id.image_movie);
        textJudulMovie = findViewById(R.id.tex_judulmovie);
        texttanggalMovie = findViewById(R.id.textjadwal_movie);
        textDeskripsiMovie = findViewById(R.id.text_deskripsimovie);
        detailViewModel = obtainViewModel(DetailActivity.this);


    }

    private void setText() {
        detailViewModel.setMovieId(movieEntity.getId());
        detailViewModel.getMovieId.observe(this, movieId->{
            if (movieId != null) {
                switch (movieId.status) {
                    case LOADING:
                        break;
                    case SUCCESS:
                        Log.d("DetailActivity", "setText: " + movieId.data.get(0).getImage());
                        Picasso.get().load(movieId.data.get(0).getImage()).into(imageMovie);
                        textJudulMovie.setText(movieId.data.get(0).getJudul());
                        texttanggalMovie.setText(movieId.data.get(0).getTanggalRilis());
                        textDeskripsiMovie.setText(movieId.data.get(0).getDeskripsi());
                        getSupportActionBar().setTitle("Detail MovieEntity");
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                        break;
                    case ERROR:
                        break;

                }
            }
        });

    }

    private static DetailViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(DetailViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu= menu;
        getMenuInflater().inflate(R.menu.menu_favorite, menu);
        detailViewModel.getMovieId.observe(this, movieId->{
            if(movieId!=null){
                switch (movieId.status){
                    case LOADING:
                        break;
                    case SUCCESS:
                        // menyelect status dari favorite
                        boolean state=movieId.data.get(0).isFavorite();
                        setFavoriteState(state);
                }
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void setFavoriteState(boolean state){
        if(menu==null) return;
        MenuItem menuItem=menu.findItem(R.id.favorite);
        if(state){
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_border));
        }
        else{
            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_star));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //MenuItem menuItem= menu.findItem(R.id.favorite);
        switch (item.getItemId()) {
            case R.id.favorite:
                // ketika favorite dipilih maka akan merubah status dari favorite
                detailViewModel.setFavorite();
                break;
            case R.id.home:
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
