package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ScrollTest {

        @get:Rule
        var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

        @Test
        fun testCase1(){
            //to check First fragment is displayed
            onView(ViewMatchers.withId(R.id.button_first))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            onView(ViewMatchers.withId(R.id.textview_first))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

            //swipe action
            onView(withId(R.id.textview_first))
                .perform(ViewActions.swipeDown())
            Thread.sleep(4000)
            //asserting with the last word of the text
            onView(withId(R.id.textview_first)).check(ViewAssertions.matches(withSubstring("dignissim")))
            onView(withId(R.id.textview_first))
               .perform(ViewActions.swipeUp())

            //navigate to next fragment
            onView(withId(R.id.button_first))
                .perform(ViewActions.click())
             onView(ViewMatchers.withId(R.id.button_second))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        }

}
