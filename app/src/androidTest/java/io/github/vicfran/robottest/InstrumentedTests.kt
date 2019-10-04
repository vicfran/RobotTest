package io.github.vicfran.robottest

import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class InstrumentedTests {

    @get:Rule
    val activityRule = ActivityTestRule(CreateAdActivity::class.java)

    @Test
    fun setPriceAndSizeCreateIsSuccess() {
        CreateAdRobot()
            .price(750.0f)
            .size(250.0f)
            .create()
            .isSuccess()
    }

    @Test
    fun unsetPriceAndSizeCreateError() {
        CreateAdRobot()
            .create()
            .isError()
    }

    @Test
    fun setPriceUnsetSizeCreateError() {
        CreateAdRobot()
            .price(750f)
            .create()
            .isError()
    }
    
    @Test
    fun unsetPriceSetSizeCreateError() {
        CreateAdRobot()
            .size(250f)
            .create()
            .isError()
    }

}
