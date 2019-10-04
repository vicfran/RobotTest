package io.github.vicfran.robottest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

class CreateAdRobot {

    fun price(price: Float): CreateAdRobot {
        onView(withId(R.id.priceEditText)).perform(typeText(price.toString()))
        return this
    }

    fun size(size: Float): CreateAdRobot {
        onView(withId(R.id.sizeEditText)).perform(typeText(size.toString()))
        return this
    }

    fun create(): CreateAdRobot {
        onView(withId(R.id.createButton)).perform(click())
        return this
    }

    fun isSuccess(): CreateAdRobot {
        onView(withId(R.id.successTextView)).check(matches(isDisplayed()))
        return this
    }

    fun isError(): CreateAdRobot {
        onView(withId(R.id.errorTextView)).check(matches(isDisplayed()))
        return this
    }

}