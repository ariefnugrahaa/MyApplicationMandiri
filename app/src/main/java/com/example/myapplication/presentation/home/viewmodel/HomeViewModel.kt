package com.example.myapplication.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.model.MenuModel
import com.example.myapplication.model.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _homeMenu = MutableLiveData<List<MenuModel>>()
    val homeMenu: LiveData<List<MenuModel>>
        get() = _homeMenu


    fun getMenuHome() = viewModelScope.launch(Dispatchers.IO) {
        _homeMenu.postValue(populateDataMenuHome())
    }

    private fun populateDataMenuHome() : List<MenuModel> {
        return listOf(
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Transfer"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Cek Saldo"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "E-Wallet"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Donasi"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Zakat"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Cashless"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Tabungan Deposito"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Setting"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Zakat"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Cashless"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Tabungan Deposito"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Setting"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Zakat"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Cashless"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Tabungan Deposito"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Setting"
            ),
        )
    }

}