package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor() : ViewModel() {

    private val _notificationData = MutableLiveData<List<NotificationModel>>()
    val notificationData: LiveData<List<NotificationModel>>
        get() = _notificationData


    fun setNotificationData() = viewModelScope.launch(Dispatchers.IO) {
        _notificationData.postValue(populateDataNotification())
    }

    private fun populateDataNotification(): List<NotificationModel> {
        return listOf(
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
        )
    }

    fun updateCustomData() {
        var notificationData = _notificationData.value
        notificationData?.forEach { it.date = "test" }

        _notificationData.postValue(notificationData ?: listOf())
    }
}