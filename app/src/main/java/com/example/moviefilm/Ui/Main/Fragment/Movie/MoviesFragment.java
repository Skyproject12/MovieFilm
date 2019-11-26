package com.example.moviefilm.Ui.Main.Fragment.Movie;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.R;
import com.example.moviefilm.Ui.Detail.DetailActivity;
import com.example.moviefilm.ViewModel.Movie.MovieViewModel;
import com.example.moviefilm.ViewModel.ViewModelFactory;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {


    public MoviesFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    MovieViewModel movieViewModel;
    ConstraintLayout constraintMovie;
    MovieAdapter movieAdapter;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Movie> list;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_movies, container, false);
        initial();
        movieViewModel.getMovie().observe(this, movie->{
            movieAdapter = new MovieAdapter();
            movieAdapter.setList(movie);
            linearLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(movieAdapter);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
            recyclerView.addItemDecoration(dividerItemDecoration);
            movieAdapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
                @Override
                public void onItmCliked(Movie movie) {
                    Intent moveObjectIntent = new Intent(getActivity(), DetailActivity.class);
                    moveObjectIntent.putExtra("film", movie);
                    moveObjectIntent.putExtra("status", "movie");
                    startActivity(moveObjectIntent);
                }
            });
        });
        return view;
    }

    public void initial() {
        recyclerView = view.findViewById(R.id.recycler_movie);
        constraintMovie = view.findViewById(R.id.constraint_film);
        list = new ArrayList<>();
        movieViewModel= obtainViewModel(getActivity());

    }
    private static MovieViewModel obtainViewModel(FragmentActivity activity){
        ViewModelFactory factory= ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }

}
