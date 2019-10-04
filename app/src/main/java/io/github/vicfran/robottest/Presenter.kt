package io.github.vicfran.robottest

class Presenter(private val view: MainView) {

    fun onCreateClicked(price: Float?, size: Float?) {
        price?.let { price ->
            size?.let { size ->
                if (AdModel(price, size).isOk()) view.showCreateAdOk()
                else view.showCreateAdError()
            } ?: view.showCreateAdError()
        } ?: view.showCreateAdError()
    }

}