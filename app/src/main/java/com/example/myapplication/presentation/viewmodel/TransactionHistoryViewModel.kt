package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.TransactionResponse
import com.example.myapplication.model.NotificationModel
import com.example.myapplication.usecase.TransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionHistoryViewModel @Inject constructor(
    private val transactionUseCase: TransactionUseCase
): ViewModel() {

    private val _transactionHistory = MutableLiveData<List<TransactionResponse>>()

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    fun getTransaction() = viewModelScope.launch {
        _loading.postValue(true)
        transactionUseCase.getTransaction().let {
            if (it.isSuccessful) {

            } else {

            }
            _loading.postValue(false)
        }
    }
}