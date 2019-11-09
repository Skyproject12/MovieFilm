package com.example.moviefilm.Priview.Main.Fragment.TvShow;

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

public class TvShowFragmentTest {


        @Rule
        public ActivityTestRule<SingleFragmentActivity> activityTestRule= new ActivityTestRule<>(SingleFragmentActivity.class);
        private TvShowFragment academyFragment= new TvShowFragment();
        @Before
        public void setUp(){
            // set fragment to until tes
            activityTestRule.getActivity().setFragment(academyFragment);
        }
        @Test
        public void loadCourses(){
            onView(withId(R.id.recycler_tvshow)).check(matches(isDisplayed()));
            // membandingkan jumlah item dalam recyclerview
            onView(withId(R.id.recycler_tvshow)).check(new RecyclerViewItemCountAssertion(10));
        }



}