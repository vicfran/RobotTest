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
        ad {
            price(750f)
            size(250f)
        } create {
            isSuccess()
        }
    }

    @Test
    fun unsetPriceAndSizeCreateError() {
        ad {

        } create {
            isError()
        }
    }

    @Test
    fun setPriceUnsetSizeCreateError() {
        ad {
            price(750f)
        } create {
            isError()
        }
    }
    
    @Test
    fun unsetPriceSetSizeCreateError() {
        ad {
            size(250f)
        } create {
            isError()
        }
    }

}
