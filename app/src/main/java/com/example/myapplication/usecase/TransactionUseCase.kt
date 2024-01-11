package com.example.myapplication.usecase

import com.example.myapplication.data.model.TransactionResponse
import com.example.myapplication.data.repository.TransactionRepository
import retrofit2.Response
import javax.inject.Inject

class TransactionUseCase @Inject constructor(
    private val repository: TransactionRepository
) {

    suspend fun getTransaction() : Response<List<TransactionResponse>> {
        return repository.getTransaction()
    }
}