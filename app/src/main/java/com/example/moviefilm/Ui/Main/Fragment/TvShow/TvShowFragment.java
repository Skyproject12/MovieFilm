package com.example.moviefilm.Ui.Main.Fragment.TvShow;


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
import com.example.moviefilm.Data.source.local.Room.Entity.TvshowEntity;
import com.example.moviefilm.R;
import com.example.moviefilm.Ui.Detail.DetailShowActivity;
import com.example.moviefilm.ViewModel.TvShow.ShowViewModel;
import com.example.moviefilm.ViewModel.ViewModelFactory;

import java.util.ArrayList;

public class TvShowFragment extends Fragment {


    private ShowViewModel showViewModel;
    RecyclerView recyclerView;
    ConstraintLayout constraintMovie;
    ShowAdapter showAdapter;
    LinearLayoutManager linearLayoutManager;
    View view;
    ProgressBar tvprogressTvshow;

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        initial();
        showViewModel.getShow().observe(this, tvshow->{
            if(tvshow!=null){
                switch (tvshow.status){
                    case LOADING:
                        tvprogressTvshow.setVisibility(View.VISIBLE);
                        break;
                    case SUCCESS:
                        tvprogressTvshow.setVisibility(View.GONE);
                        showAdapter = new ShowAdapter();
                        showAdapter.setList(tvshow.data);
                        linearLayoutManager = new LinearLayoutManager(getActivity());
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(showAdapter);
                        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), linearLayoutManager.getOrientation());
                        recyclerView.addItemDecoration(dividerItemDecoration);
                        showAdapter.setOnItemClickCallback(new ShowAdapter.OnItemClickCallback() {
                            @Override
                            public void onItmCliked(TvshowEntity movie) {
                                Intent moveObjectIntent = new Intent(getActivity(), DetailShowActivity.class);
                                moveObjectIntent.putExtra("tvshow", movie);
                                startActivity(moveObjectIntent);
                            }
                        });
                    case ERROR:
                        Toast.makeText(getActivity(), "error"+tvshow.data, Toast.LENGTH_SHORT).show();
                        tvprogressTvshow.setVisibility(View.GONE);
                        break;

                }
            }
        });
        return view;
    }

    public void initial() {
        recyclerView = view.findViewById(R.id.recycler_tvshow);
        constraintMovie = view.findViewById(R.id.constraint_film);
        showViewModel = obtainViewModel(getActivity());
        tvprogressTvshow= view.findViewById(R.id.progress_tvshow);

    }

    private static ShowViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(ShowViewModel.class);

    }

}
