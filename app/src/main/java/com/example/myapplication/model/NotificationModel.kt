package com.example.myapplication.model

import kotlinx.parcelize.IgnoredOnParcel

data class NotificationModel(
    var date: String,
    val title: String,
    val subtitle: String,
)