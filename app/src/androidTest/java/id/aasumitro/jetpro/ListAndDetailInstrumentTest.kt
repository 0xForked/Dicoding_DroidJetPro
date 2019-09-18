package id.aasumitro.jetpro

import android.os.SystemClock
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import id.aasumitro.jetpro.ListAndDetailInstrumentTest.CustomAssertions.Companion.hasItemCount
import id.aasumitro.jetpro.ui.activities.main.MainActivity
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by A. A. Sumitro on 19/08/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

@RunWith(AndroidJUnit4ClassRunner::class)
class ListAndDetailInstrumentTest {

    @Rule
    @JvmField var activityMainRule =
        ActivityTestRule(MainActivity::class.java)

    @Test
    fun view_pager_test() {
        SystemClock.sleep(1800)
        onView(withId(R.id.main_tab_layout)).check(matches(isDisplayed()))
        val shows = allOf(
            withText("TV SHOWS"),
            isDescendantOfA(withId(R.id.main_tab_layout))
        )
        val movies = allOf(
            withText("MOVIES"),
            isDescendantOfA(withId(R.id.main_tab_layout))
        )
        SystemClock.sleep(1800)
        onView(shows).perform(click())
        SystemClock.sleep(1800)
        onView(movies).perform(click())
        SystemClock.sleep(1800)
        onView(shows).perform(click())
    } // passed

    @Test
    fun movies_list_data_count_test() {
        SystemClock.sleep(1800)
        onView(withId(R.id.movie_recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_recycler_view)).check(hasItemCount(20))
        SystemClock.sleep(1800)
    } // passed

    @Test
    fun movie_detail_test() {
        SystemClock.sleep(1800)
        onView(withId(R.id.movie_recycler_view)).check(hasItemCount(20))
        SystemClock.sleep(1800)
        onView(withId(R.id.movie_recycler_view))
            .check(matches(isDisplayed()))
            .perform(
            RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        pressBack()
        SystemClock.sleep(1800)
        onView(withId(R.id.movie_recycler_view))
            .check(matches(isDisplayed()))
            .perform(ViewActions.swipeUp())
        SystemClock.sleep(1800)
        onView(withId(R.id.movie_recycler_view))
            .check(matches(isDisplayed()))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(9, click()))
        SystemClock.sleep(1800)
    } // passed

    @Test
    fun shows_list_data_count_test() {
        SystemClock.sleep(1800)
        onView(withId(R.id.main_tab_layout)).check(matches(isDisplayed()))
        val shows = allOf(
            withText("TV SHOWS"),
            isDescendantOfA(withId(R.id.main_tab_layout))
        )
        SystemClock.sleep(1800)
        onView(shows).perform(click())
        onView(withId(R.id.show_recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.show_recycler_view)).check(hasItemCount(20))
    } // passed

    @Test
    fun show_detail_test() {
        SystemClock.sleep(1800)
        val shows = allOf(
            withText("TV SHOWS"),
            isDescendantOfA(withId(R.id.main_tab_layout))
        )
        SystemClock.sleep(1800)
        onView(shows).perform(click())
        onView(withId(R.id.show_recycler_view)).check(matches(isDisplayed()))
        SystemClock.sleep(1800)
        onView(withId(R.id.show_recycler_view)).check(hasItemCount(20))
        SystemClock.sleep(1800)
        onView(withId(R.id.show_recycler_view))
            .check(matches(isDisplayed()))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        pressBack()
        SystemClock.sleep(1800)
        onView(withId(R.id.show_recycler_view))
            .check(matches(isDisplayed()))
            .perform(ViewActions.swipeUp())
        SystemClock.sleep(1800)
        onView(withId(R.id.show_recycler_view))
            .check(matches(isDisplayed()))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(9, click()))
        SystemClock.sleep(1800)

    } // passed

    private class CustomAssertions {
        companion object {
            fun hasItemCount(count: Int): ViewAssertion =
                RecyclerViewItemCountAssertion(count)
        }

        private class RecyclerViewItemCountAssertion(private val count: Int) : ViewAssertion {
            override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
                if (noViewFoundException != null)
                    throw noViewFoundException
                if (view !is RecyclerView)
                    throw IllegalStateException("The asserted view is not RecyclerView")
                if (view.adapter == null)
                    throw IllegalStateException("No adapter is assigned to RecyclerView")
                assertThat(
                    "RecyclerView item count",
                    view.adapter?.itemCount,
                    CoreMatchers.equalTo(count)
                )
            }
        }

    }
}
