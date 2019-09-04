package com.example.moviefilm.Priview.Main.Fragment;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        convert();
        addItem();
        movieAdapter= new MovieAdapter(getActivity(), list);
        linearLayoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(movieAdapter);
        DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        return view;
    }
    public void initial(){
        recyclerView= view.findViewById(R.id.recycler_movie);
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

}
