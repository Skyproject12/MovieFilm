package com.example.moviefilm.Ui.Main.Fragment.Movie;

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
        try {
            Thread.sleep(10000);
        }
        catch(InterruptedException e){
            e.printStackTrace();

        }
        onView(withId(R.id.recycler_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_movie)).check(new RecyclerViewItemCountAssertion(20));
    }

}