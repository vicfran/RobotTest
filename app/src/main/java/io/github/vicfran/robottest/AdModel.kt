package io.github.vicfran.robottest

data class AdModel(val price: Float, val size: Float)

fun AdModel.isOk() = price > 0 && size > 0