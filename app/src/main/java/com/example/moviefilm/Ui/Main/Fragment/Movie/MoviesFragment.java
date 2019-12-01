package com.example.moviefilm.Ui.Main.Fragment.Movie;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.R;
import com.example.moviefilm.Ui.Detail.DetailActivity;
import com.example.moviefilm.ViewModel.Movie.MovieViewModel;
import com.example.moviefilm.ViewModel.ViewModelFactory;

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
    View view;
    ProgressBar progressMovie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_movies, container, false);
        initial();
        movieViewModel.getMovie().observe(this, movie -> {
            if (movie != null) {
                switch (movie.status) {
                    case LOADING:
                        progressMovie.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        movieAdapter = new MovieAdapter();
                        progressMovie.setVisibility(View.GONE);

                        movieAdapter.setList(movie.data);
                        linearLayoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(movieAdapter);
                        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
                        recyclerView.addItemDecoration(dividerItemDecoration);
                        movieAdapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
                            @Override
                            public void onItmCliked(MovieEntity movieEntity) {
                                Intent moveObjectIntent = new Intent(getActivity(), DetailActivity.class);
                                moveObjectIntent.putExtra("film", movieEntity);
                                moveObjectIntent.putExtra("status", "movieEntity");
                                startActivity(moveObjectIntent);
                            }
                        });
                        break;
                    case ERROR:
                        Toast.makeText(getActivity(), "error"+movie.data.get(0).getDeskripsi(), Toast.LENGTH_SHORT).show();
                        progressMovie.setVisibility(View.GONE);
                        break;
                }
            }
        });
        return view;
    }

    public void initial() {
        recyclerView = view.findViewById(R.id.recycler_movie);
        constraintMovie = view.findViewById(R.id.constraint_film);
        movieViewModel = obtainViewModel(getActivity());
        progressMovie = view.findViewById(R.id.progress_movie);

    }

    private static MovieViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }

}
