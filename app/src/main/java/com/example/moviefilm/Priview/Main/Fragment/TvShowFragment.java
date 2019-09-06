package com.example.moviefilm.Priview.Main.Fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
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
import com.example.moviefilm.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {


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
    MovieAdapter movieAdapter;
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
        convert();
        addItem();
        movieAdapter= new MovieAdapter(getActivity(), list);
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
        constraintMovie= view.findViewById(R.id.constraint_film);

    }
    private void addItem(){
        list= new ArrayList<>();
        for (int i = 0; i <dataFilm.length ; i++) {
            filmFavorit= new Movie();
            filmFavorit.setJudul(dataFilm[i]);
            filmFavorit.setDeskripsi(dataDeskripsi[i]);
            filmFavorit.setImage(dataPhoto.getResourceId(i, -1));
            filmFavorit.setPembuat(pembuat[i]);
            filmFavorit.setTanggalRilis(tanggalRilis[i]);
            list.add(filmFavorit);
        }
    }

    private void convert(){
        dataFilm= getResources().getStringArray(R.array.nama_film);
        dataDeskripsi= getResources().getStringArray(R.array.deskripsi_film);
        dataPhoto= getResources().obtainTypedArray(R.array.data_photo);
        tanggalRilis= getResources().getStringArray(R.array.tanggal_film);
        pembuat= getResources().getStringArray(R.array.production);
    }
    private void IntentToFile(){
        movieAdapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
            @Override
            public void onItmCliked(Movie movie) {
                Intent moveObjectIntent= new Intent(getActivity(), DetailActivity.class);
                moveObjectIntent.putExtra("film",movie);
                startActivity(moveObjectIntent);
            }
        });
    }

}
