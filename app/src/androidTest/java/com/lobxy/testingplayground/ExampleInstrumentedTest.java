package com.lobxy.testingplayground;

import android.content.Context;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.TestCase.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = getTargetContext();
//
//        assertEquals("com.lobxy.testingplayground", appContext.getPackageName());
//    }

    @Test
    public void check_text_value() {
        onView(withId(R.id.main_text)).check(matches(withText("Main Activity")));
    }

    @Test
    public void enter_text_in_edit() {
        onView(withId(R.id.main_edit)).perform(typeText("Entered Value"));
    }

    @Test
    public void show_entered_text() {
        onView(withId(R.id.main_edit)).perform(typeText("Entered Value"));
        onView(withId(R.id.main_btn_set_text)).perform(click());
        onView(withId(R.id.main_text)).check(matches(withText("Entered Value")));
    }

    @Test
    public void check_alert_dialog() {
        onView(withId(R.id.main_check_dialog)).check(matches(isNotChecked())).perform(click());
    }

    @Test
    public void check_alert_toast() {
        onView(withId(R.id.main_check_toast)).check(matches(isChecked())).perform(click());
    }

//    @Test
//    public void show_alert_toast() {
//    }
//
//    @Test
//    public void show_alert_dialog() {
//    }

    @Test
    public void start_new_activity() {
        onView(withId(R.id.main_btn_start_new_activity)).perform(click());
        intended(hasComponent(SecondaryActivity.class.getName()));
    }
}
