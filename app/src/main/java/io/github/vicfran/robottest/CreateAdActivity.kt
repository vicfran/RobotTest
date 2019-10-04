package io.github.vicfran.robottest

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.*
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class CreateAdActivity : AppCompatActivity(), CreateAdView {

    private lateinit var createAdPresenter: CreateAdPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createAdPresenter = CreateAdPresenter(this)
        initViews()
    }

    override fun showCreateAdOk() {
        successTextView.show()
    }

    override fun hideCreateAdOk() {
        successTextView.hide()
    }

    override fun showCreateAdError() {
        errorTextView.show()
    }

    override fun hideCreateAdError() {
        errorTextView.hide()
    }

    private fun initViews() {
        priceEditText.addTextChangedListener(editTextWatcher)
        sizeEditText.addTextChangedListener(editTextWatcher)
        createButton.setOnClickListener {
            hideKeyboard()
            createAdPresenter.onCreateClicked(price(), size())
        }
    }

    private val editTextWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {}

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            successTextView.hide()
            errorTextView.hide()
        }
    }

    private fun price() = priceEditText.text?.toString()?.toFloatOrNull()
    private fun size() = sizeEditText.text?.toString()?.toFloatOrNull()

}

fun View.show() { visibility = VISIBLE }
fun View.hide() { visibility = INVISIBLE }
fun Activity.hideKeyboard() {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus
        if (view == null) {
            view = View(this)
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)
}
