package com.example.moviefilm.Ui.Main.Fragment.Movie;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviefilm.Data.source.remote.Response.Movie;
import com.example.moviefilm.Ui.Detail.DetailActivity;
import com.example.moviefilm.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {


    public MoviesFragment() {
        // Required empty public constructor
    }
    String dataFilm[];
    String dataDeskripsi[];
    String tanggalRilis[];
    String pembuat[];
    TypedArray dataPhoto;

    RecyclerView recyclerView;
    MovieViewModel movieViewModel;
    ImageView imageMovie;
    TextView textJudulMovie;
    TextView textPembuatMovie;
    TextView texttanggalMovie;
    TextView textDeskripsiMovie;
    ConstraintLayout constraintMovie;
    Movie filmFavorit;
    MovieAdapter movieAdapter;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Movie> list;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_movies, container, false);
        initial();
        addItem();
        movieAdapter= new MovieAdapter(getActivity(), list);
       // movieAdapter.setList(list);
        linearLayoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(movieAdapter);
        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        IntentToFile();
        return view;
    }
    public void initial(){
        recyclerView= view.findViewById(R.id.recycler_movie);
        constraintMovie= view.findViewById(R.id.constraint_film);
        list= new ArrayList<>();
        movieViewModel= ViewModelProviders.of(getActivity()).get(MovieViewModel.class);

    }
    private void addItem(){
        list.addAll(movieViewModel.getMovie());
    }

    private void IntentToFile(){
        movieAdapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
            @Override
            public void onItmCliked(Movie movie) {
                Intent moveObjectIntent= new Intent(getActivity(), DetailActivity.class);
                moveObjectIntent.putExtra("film",movie);
                moveObjectIntent.putExtra("status", "movie");
                startActivity(moveObjectIntent);
            }
        });
    }

}
