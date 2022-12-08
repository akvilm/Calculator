package com.example.calculator;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testWhenBtnOneIsPressedOneIsEnteredToTxtView() {

        final String expectedResult = "1";

        //Not working: https://stackoverflow.com/questions/20436968/espresso-typetext-not-working
        //onView(withId(R.id.txtMain)).perform(click(), typeText(givenString));

        onView(withId(R.id.num1)).perform(click());
        onView(withId(R.id.workingsTextView)).check(matches(withText(expectedResult)));
    }

    @Test
    public void testWhenBtnTwoIsPressedTwoIsEnteredToTxtView() {

        final String expectedResult = "2";

        //Not working: https://stackoverflow.com/questions/20436968/espresso-typetext-not-working
        //onView(withId(R.id.txtMain)).perform(click(), typeText(givenString));

        onView(withId(R.id.num2)).perform(click());
        onView(withId(R.id.workingsTextView)).check(matches(withText(expectedResult)));
    }

    @Test
    public void testWhenTwoNumbersAddedResultIsEnteredToTxtView() {
        final String expectedResult = "5.0";

        //Not working: https://stackoverflow.com/questions/20436968/espresso-typetext-not-working
        //onView(withId(R.id.txtMain)).perform(click(), typeText(givenString));

        onView(withId(R.id.num2)).perform(click());
        onView(withId(R.id.plus)).perform(click());
        onView(withId(R.id.num3)).perform(click());
        onView(withId(R.id.equal)).perform(click());
        onView(withId(R.id.resultsTextView)).check(matches(withText(expectedResult)));
    }

    @Test
    public void testWhenThreeNumbersIsEnteredThenBackBtnIsClickedLastNumberIsDeleted() {
        final String expectedResult = "25";

        //Not working: https://stackoverflow.com/questions/20436968/espresso-typetext-not-working
        //onView(withId(R.id.txtMain)).perform(click(), typeText(givenString));

        onView(withId(R.id.num2)).perform(click());
        onView(withId(R.id.num5)).perform(click());
        onView(withId(R.id.num2)).perform(click());
        onView(withId(R.id.back)).perform(click());
        onView(withId(R.id.workingsTextView)).check(matches(withText(expectedResult)));
    }

    @Test
    public void testWhenThreeNumbersIsEnteredThenDeleteBtnIsClickedAllNumbersIsDeleted() {
        final String expectedResult = "";

        //Not working: https://stackoverflow.com/questions/20436968/espresso-typetext-not-working
        //onView(withId(R.id.txtMain)).perform(click(), typeText(givenString));

        onView(withId(R.id.num2)).perform(click());
        onView(withId(R.id.dot)).perform(click());
        onView(withId(R.id.num5)).perform(click());
        onView(withId(R.id.clearEverything)).perform(click());
        onView(withId(R.id.workingsTextView)).check(matches(withText(expectedResult)));
    }
}