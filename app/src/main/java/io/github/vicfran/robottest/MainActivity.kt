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

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = Presenter(this)
        initViews()
    }

    override fun showCreateAdOk() {
        with (createResultTextView) {
            show()
            text = "Ad model is OK"
        }
    }

    override fun showCreateAdError() {
        with (createResultTextView) {
            show()
            text = "Ad model is not OK"
        }
    }

    private fun initViews() {
        priceEditText.addTextChangedListener(editTextWatcher)
        sizeEditText.addTextChangedListener(editTextWatcher)
        createButton.setOnClickListener {
            hideKeyboard()
            presenter.onCreateClicked(price(), size())
        }
    }

    private val editTextWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {}

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            createResultTextView.hide()
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
