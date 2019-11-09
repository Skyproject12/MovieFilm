package com.example.moviefilm.Priview.Main.Fragment.Movie;

import androidx.test.rule.ActivityTestRule;

import com.example.moviefilm.R;
import com.example.moviefilm.testing.SingleFragmentActivity;
import com.example.moviefilm.utils.RecyclerViewItemCountAssertion;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MoviesFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityTestRule= new ActivityTestRule<>(SingleFragmentActivity.class);
    private MoviesFragment moviesFragment= new MoviesFragment();
    @Before
    public void setUp(){
        activityTestRule.getActivity().setFragment(moviesFragment);
    }
    @Test
    public void loadMovie(){
        onView(withId(R.id.recycler_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_movie)).check(new RecyclerViewItemCountAssertion(11));

    }

}