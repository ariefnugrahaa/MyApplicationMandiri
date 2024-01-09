package com.example.myapplication.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class EwalletModel(
    val name: String,
    @DrawableRes
    val image: Int,
    val balance: Double,
    var isConnected: Boolean
) : Parcelable


data class Film(
    val name: String,
    val rating: Int
)