package com.example.moviefilm.Ui.Detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.moviefilm.Data.source.local.Movie;
import com.example.moviefilm.Data.source.local.TvshowEntity;
import com.example.moviefilm.R;
import com.example.moviefilm.utils.FakeDataDummy;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailShowActivityTest {

    private TvshowEntity show= FakeDataDummy.generateShow().get(0);
    @Rule
    public ActivityTestRule<DetailShowActivity> activityTestRule= new ActivityTestRule<DetailShowActivity>(DetailShowActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Context targetContext= InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result= new Intent(targetContext, DetailShowActivity.class);
            result.putExtra("tvshow", show);
            return result;

        }
    };
    @Test
    public void loadMovie(){
        try {
            Thread.sleep(10000);
        }
        catch(InterruptedException e){
            e.printStackTrace();

        }
        onView(withId(R.id.tex_judulmovie)).check(matches(isDisplayed()));
        onView(withId(R.id.tex_judulmovie)).check(matches(withText(show.getJudul())));
        try {
            Thread.sleep(10000);
        }
        catch(InterruptedException e){
            e.printStackTrace();

        }
        onView(withId(R.id.text_deskripsimovie)).check(matches(isDisplayed()));
        onView(withId(R.id.text_deskripsimovie)).check(matches(withText(show.getDeskripsi())));

    }

}