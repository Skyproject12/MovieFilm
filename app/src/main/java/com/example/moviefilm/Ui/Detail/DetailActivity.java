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
import androidx.lifecycle.ViewModelProviders;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.R;
import com.example.moviefilm.Ui.Main.MainActivity;
import com.example.moviefilm.ViewModel.Detail.DetailViewModel;
import com.example.moviefilm.ViewModel.ViewModelFactory;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    MovieEntity movieEntity;
    ImageView imageMovie;
    TextView textJudulMovie;
    TextView texttanggalMovie;
    TextView textDeskripsiMovie;
    private DetailViewModel detailViewModel;


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
        detailViewModel= obtainViewModel(DetailActivity.this);


    }

    private void setText() {
        detailViewModel.getMovieId(movieEntity.getId()).observe(this, movieId-> {
            Log.d("DetailActivity", "setText: "+movieId.get(0).getImage());
            Picasso.get().load(movieId.get(0).getImage()).into(imageMovie);
            textJudulMovie.setText(movieId.get(0).getJudul());
            texttanggalMovie.setText(movieId.get(0).getTanggalRilis());
            textDeskripsiMovie.setText(movieId.get(0).getDeskripsi());
            getSupportActionBar().setTitle("Detail MovieEntity");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        });
    }

    private static DetailViewModel obtainViewModel(AppCompatActivity activity){
        ViewModelFactory factory= ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(DetailViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //this.menu= menu;
        getMenuInflater().inflate(R.menu.menu_favorite, menu);
        MenuItem menuItem= menu.findItem(R.id.favorite);
//        if(favoriteHelper.getAllByMovieId(movieEntity.getId())){
//            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_star));
//        }else if(!favoriteHelper.getAllByMovieId(movieEntity.getId())){
//            menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_border));
//        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //MenuItem menuItem= menu.findItem(R.id.favorite);
        switch (item.getItemId()){
            case R.id.favorite:
//                if(favoriteHelper.getAllByMovieId(movieEntity.getId())){
//                    Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
//                    menuItem.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_border));
//                    favoriteHelper.deleteFavoriteMovie(movieEntity.getId());
//                }else if(!favoriteHelper.getAllByMovieId(movieEntity.getId())){
//                    Toast.makeText(this, "masuk", Toast.LENGTH_SHORT).show();
//                    menuItem.setIcon(ContextCompat.getDrawable(this,R.drawable.ic_star));
//                    favoriteHelper.insertFavoriteMovie(movieEntity);
//                }
                break;
            case R.id.home:
                Intent intent= new  Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
