package com.example.moviefilm.Ui.Main.Fragment.Favorite.TvshowFavorite;


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
import com.example.moviefilm.ViewModel.Favorite.TvshowFavoriteViewModel;
import com.example.moviefilm.ViewModel.ViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvshowFavoriteFragment extends Fragment {

    private RecyclerView recyclers;
    private View view;
    private TvshowFavoriteViewModel tvshowFavoriteViewModel;
    private TvshowFavoriteAdapter adapter;


    public TvshowFavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tvshow_favorite, container, false);
        tvshowFavoriteViewModel = obtainViewModel(getActivity());
        recyclers = view.findViewById(R.id.recyclers);
        adapter = new TvshowFavoriteAdapter();
        tvshowFavoriteViewModel.getFavoriteTvshow().observe(this, movie -> {
            if (movie != null) {
                switch (movie.status) {
                    case LOADING:
                        break;
                    case SUCCESS:
                        adapter.submitList(movie.data);
                        adapter.notifyDataSetChanged();
                        recyclers.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recyclers.setHasFixedSize(true);
                        recyclers.setAdapter(adapter);
                        break;
                    case ERROR:
                        break;

                }
            }
        });

        return view;
    }

    @NonNull
    private static TvshowFavoriteViewModel obtainViewModel(FragmentActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return ViewModelProviders.of(activity, factory).get(TvshowFavoriteViewModel.class);
    }

}
