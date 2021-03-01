package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R
import java.io.Serializable

data class Dog(
    val name: String,
    val age: String,
    val variety: String,
    val location: String,
    val introduction: String,
    val gender: String,
    @DrawableRes val picture: Int,
) : Serializable
