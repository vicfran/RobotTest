package io.github.vicfran.robottest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

class CreateAdRobot {


    fun price(price: Float) {
        onView(withId(R.id.priceEditText)).perform(typeText(price.toString()))
    }

    fun size(size: Float) {
        onView(withId(R.id.sizeEditText)).perform(typeText(size.toString()))
    }

    infix fun create(func: CreateAdRobot.() -> Unit): CreateAdRobot {
        onView(withId(R.id.createButton)).perform(click())
        return CreateAdRobot().apply { func() }
    }

    fun isSuccess() {
        onView(withId(R.id.successTextView)).check(matches(isDisplayed()))
    }

    fun isError() {
        onView(withId(R.id.errorTextView)).check(matches(isDisplayed()))
    }

}

fun ad(func: CreateAdRobot.() -> Unit) = CreateAdRobot().apply { func() }