package com.example.moviefilm.Ui.Main.Fragment.Favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.moviefilm.R;
import com.example.moviefilm.Ui.Main.Fragment.Favorite.MovieFavorite.MovieFragment;
import com.example.moviefilm.Ui.Main.Fragment.Favorite.TvshowFavorite.TvshowFragment;
import com.google.android.material.tabs.TabLayout;

public class FavoriteFragment extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        profilViewPager();
        return view;
    }

    private void profilViewPager() {
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager());
        adapter.addFragment(new MovieFragment()); // index 2
        adapter.addFragment(new TvshowFragment()); //index 1
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.profil_viewPager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabsProfil);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(getString(R.string.movies));
        tabLayout.getTabAt(1).setText(getString(R.string.tvshow));
    }
}