package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class NotificationViewModel : ViewModel() {

    private val _notificationData = MutableLiveData<List<NotificationModel>>()
    val notificationData: LiveData<List<NotificationModel>>
        get() = _notificationData


    fun setNotificationData(data: List<NotificationModel>) = viewModelScope.launch {
        _notificationData.postValue(data)
    }

    fun updateCustomData() {
        var notificationData = _notificationData.value
        notificationData?.forEach { it.date = "test" }

        _notificationData.postValue(notificationData ?: listOf())
    }
}