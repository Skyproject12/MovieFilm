package com.example.moviefilm.Priview.Main.Fragment.TvShow;


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

import com.example.moviefilm.Data.Request.Movie;
import com.example.moviefilm.Priview.Detail.DetailActivity;
import com.example.moviefilm.Priview.Detail.DetailShowActivity;
import com.example.moviefilm.Priview.Main.Fragment.TvShow.ShowAdapter;
import com.example.moviefilm.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {


    private ShowViewModel showViewModel;
    String dataFilm[];
    String dataDeskripsi[];
    String tanggalRilis[];
    String pembuat[];
    TypedArray dataPhoto;

    RecyclerView recyclerView;
    ImageView imageMovie;
    TextView textJudulMovie;
    TextView textPembuatMovie;
    TextView texttanggalMovie;
    TextView textDeskripsiMovie;
    ConstraintLayout constraintMovie;
    Movie filmFavorit;
    ShowAdapter movieAdapter;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Movie> list;
    View view;

    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_tv_show, container, false);
        initial();
        addItem();
        movieAdapter= new ShowAdapter(getActivity(), list );
        linearLayoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(movieAdapter);
        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        IntentToFile();
        return view;
    }
    public void initial(){
        recyclerView= view.findViewById(R.id.recycler_tvshow);
        list= new ArrayList<>();
        constraintMovie= view.findViewById(R.id.constraint_film);
        showViewModel= ViewModelProviders.of(getActivity()).get(ShowViewModel.class);

    }
    private void addItem(){
        list.addAll(showViewModel.getShow());

    }
    private void IntentToFile(){
        movieAdapter.setOnItemClickCallback(new ShowAdapter.OnItemClickCallback() {
            @Override
            public void onItmCliked(Movie movie) {
                Intent moveObjectIntent= new Intent(getActivity(), DetailShowActivity.class);
                moveObjectIntent.putExtra("tvshow",movie);
                String status="tvshow";
                moveObjectIntent.putExtra("status",status );
                startActivity(moveObjectIntent);
            }
        });
    }

}
