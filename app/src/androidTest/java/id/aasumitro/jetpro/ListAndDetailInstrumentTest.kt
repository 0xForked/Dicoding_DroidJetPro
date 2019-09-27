package id.aasumitro.jetpro

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
import id.aasumitro.jetpro.utils.EspressoIdlingResource
import androidx.test.espresso.IdlingRegistry
import org.junit.After
import org.junit.Before



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

    @Before
    fun setUp() {
        IdlingRegistry.getInstance()
            .register(EspressoIdlingResource.espressoIdlingResourceForMainActivity)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance()
            .unregister(EspressoIdlingResource.espressoIdlingResourceForMainActivity)
    }

    @Test
    fun view_pager_test() {
        onView(withId(R.id.main_tab_layout)).check(matches(isDisplayed()))
        val shows = allOf(
            withText("TV SHOWS"),
            isDescendantOfA(withId(R.id.main_tab_layout))
        )
        val movies = allOf(
            withText("MOVIES"),
            isDescendantOfA(withId(R.id.main_tab_layout))
        )
        onView(shows).perform(click())
        onView(movies).perform(click())
        onView(shows).perform(click())
    } // passed

    @Test
    fun movies_list_data_count_test() {
        onView(withId(R.id.movie_recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_recycler_view)).check(hasItemCount(20))
    } // passed

    @Test
    fun movie_detail_test() {
        onView(withId(R.id.movie_recycler_view)).check(hasItemCount(20))
        onView(withId(R.id.movie_recycler_view))
            .check(matches(isDisplayed()))
            .perform(
            RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        pressBack()
        onView(withId(R.id.movie_recycler_view))
            .check(matches(isDisplayed()))
            .perform(ViewActions.swipeUp())
        onView(withId(R.id.movie_recycler_view))
            .check(matches(isDisplayed()))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(9, click()))
    } // passed

    @Test
    fun shows_list_data_count_test() {
        onView(withId(R.id.main_tab_layout)).check(matches(isDisplayed()))
        val shows = allOf(
            withText("TV SHOWS"),
            isDescendantOfA(withId(R.id.main_tab_layout))
        )
        onView(shows).perform(click())
        onView(withId(R.id.show_recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.show_recycler_view)).check(hasItemCount(20))
    } // passed

    @Test
    fun show_detail_test() {
        val shows = allOf(
            withText("TV SHOWS"),
            isDescendantOfA(withId(R.id.main_tab_layout))
        )
        onView(shows).perform(click())
        onView(withId(R.id.show_recycler_view)).check(matches(isDisplayed()))
        onView(withId(R.id.show_recycler_view)).check(hasItemCount(20))
        onView(withId(R.id.show_recycler_view))
            .check(matches(isDisplayed()))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        pressBack()
        onView(withId(R.id.show_recycler_view))
            .check(matches(isDisplayed()))
            .perform(ViewActions.swipeUp())
        onView(withId(R.id.show_recycler_view))
            .check(matches(isDisplayed()))
            .perform(
                RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(9, click()))
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
                check(view is RecyclerView) { "The asserted view is not RecyclerView" }
                checkNotNull(view.adapter) { "No adapter is assigned to RecyclerView" }
                assertThat(
                    "RecyclerView item count",
                    view.adapter?.itemCount,
                    CoreMatchers.equalTo(count)
                )
            }
        }

    }
}
