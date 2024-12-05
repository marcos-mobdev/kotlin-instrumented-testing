package br.com.appforge.kotlininstrumentedtesting

import android.view.KeyEvent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.doubleClick
import androidx.test.espresso.action.ViewActions.longClick
import androidx.test.espresso.action.ViewActions.pressKey
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.startsWith
import org.hamcrest.Matchers.equalToIgnoringCase
import org.hamcrest.Matchers.equalToIgnoringWhiteSpace
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class LoginActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLogin_fillUserData_check() {
        onView(withId(R.id.btnLogin))
            .check(matches(withText("Login")))

        onView(withId(R.id.editEmail))
            .check(matches(withHint("E-mail")))

        onView(withId(R.id.editPassword)).check(matches(isDisplayed()))
        //onView(withId(R.id.editPassword)).check(matches(not(isDisplayed())))
    }

    @Test
    fun checkLogin_fillUserData() {

        val email = "marcos@gmail.com"
        val password = "123456"

        //->Login Activity
        //Typing email
        onView(withId(R.id.editEmail)).perform(
            typeText(email)
        )
        //Typing password
        onView(withId(R.id.editPassword)).perform(
            typeText(password)
        )
        //Click button
        onView(withId(R.id.btnLogin)).perform(
            click()
        )

        //->Main Activity
        //Check email
        onView(withId(R.id.emailText))
            .check(
                matches(withText(email))
            )

        //Click button
        onView(withId(R.id.btnBack)).perform(
            click()
        )

        //->Login Activity
        //Clear email
        onView(withId(R.id.editEmail)).perform(
            clearText()
        )
        //Clear password
        onView(withId(R.id.editPassword)).perform(
            clearText()
        )
    }
    @Test
    fun checkLogin_locateButtonByText_click() {

        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.btnLogin)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.btnLogin)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.btnLogin)).check(matches(isEnabled()))
        onView(withId(R.id.btnLogin)).check(matches(isClickable()))
        onView(withId(R.id.checkBox)).check(matches(isChecked()))
        onView(withText("Login")).perform(click())

    }

    @Test
    fun checkLogin_hamcrestExamples(){
        //ViewMatchers
        /*
        onView(withId(R.id.btnLogin))
            .check(matches(isDisplayed()))
        onView(withText(startsWith("Login")))
            .check(matches(isDisplayed()))

             onView(withText(equalTo("Login")))
            .check(matches(isDisplayed()))
         */


        onView(withText(equalToIgnoringCase("login")))
            .check(matches(isDisplayed()))

        onView(withHint(equalToIgnoringWhiteSpace("e-mail")))
            .check(matches(isDisplayed()))
        //ViewAssertions
        //onView(withId(R.id.btnLogin)).check(matches(not(isDisplayed())))

    }

    @Test
    fun checkLogin_viewActions(){


        onView(withId(R.id.editEmail))
            .perform(
                //pressKey(KeyEvent.KEYCODE_PASTE)
            )
        onView(withId(R.id.editPassword))
            .perform(
                //click()
                //doubleClick()
                //longClick()
                //pressKey(KeyEvent.KEYCODE_PASTE)
                //clearText()
                //typeText("Ola")
                replaceText("Hi")
            )

    }
    @Test
    fun checkLogin_viewAssertions(){
        onView(withId(R.id.btnLogin))
            .check(matches(withText("Login")))
            .perform(click())
    }
}



