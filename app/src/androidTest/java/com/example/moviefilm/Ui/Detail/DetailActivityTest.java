package com.example.moviefilm.Ui.Detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.moviefilm.Data.source.local.Room.Entity.MovieEntity;
import com.example.moviefilm.R;
import com.example.moviefilm.Util.IddlingTesting;
import com.example.moviefilm.utils.FakeDataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailActivityTest {

    private MovieEntity movieEntity =FakeDataDummy.generateMovie().get(0);
    @Rule
    public ActivityTestRule<DetailActivity> activityTestRule= new ActivityTestRule<DetailActivity>(DetailActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Context targetContext= InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result= new Intent(targetContext, DetailActivity.class);
            result.putExtra("film", movieEntity);
            return result;

        }
    };

    @Before
    public void setUp(){
        // set fragment to until tes
        IdlingRegistry.getInstance().register(IddlingTesting.getIddlingTesting());
    }
    @After
    public void tearDown(){
        IdlingRegistry.getInstance().unregister(IddlingTesting.getIddlingTesting());

    }
    @Test
    public void loadMovie(){
        onView(withId(R.id.tex_judulmovie)).check(matches(isDisplayed()));
        onView(withId(R.id.tex_judulmovie)).check(matches(withText(movieEntity.getJudul())));

        onView(withId(R.id.text_deskripsimovie)).check(matches(isDisplayed()));
        onView(withId(R.id.text_deskripsimovie)).check(matches(withText(movieEntity.getDeskripsi())));

    }

}