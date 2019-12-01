package com.example.moviefilm.Ui.Main.Fragment.Favorite.MovieFavorite;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviefilm.R;
import com.example.moviefilm.ViewModel.Favorite.MovieFavoriteViewModel;
import com.example.moviefilm.ViewModel.ViewModelFactory;

public class MovieFavoriteFragment extends Fragment {

    private RecyclerView recyclerM;
    private View view;
    private MovieFavoriteViewModel movieFavoriteViewModel;
    private MovieFavoriteAdapter adapter;

    public MovieFavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_movie_favorite, container, false);
        recyclerM = view.findViewById(R.id.recycler_favoritm);
        movieFavoriteViewModel = obtainViewModel(getActivity());
        adapter = new MovieFavoriteAdapter();
        movieFavoriteViewModel.getFavoriteMovie().observe(this, movie -> {
            if (movie != null) {
                switch (movie.status) {
                    case LOADING:
                        break;
                    case SUCCESS:
                        adapter.submitList(movie.data);
                        adapter.notifyDataSetChanged();
                        recyclerM.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recyclerM.setHasFixedSize(true);
                        recyclerM.setAdapter(adapter);
                        break;
                    case ERROR:
                        break;

                }
            }
        });

        return view;

    }

    @NonNull
    private static MovieFavoriteViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(MovieFavoriteViewModel.class);
    }

}
