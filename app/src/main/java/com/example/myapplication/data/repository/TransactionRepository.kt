package com.example.myapplication.data.repository

import com.example.myapplication.data.model.TransactionResponse
import retrofit2.Response

interface TransactionRepository {

    suspend fun getTransaction() : Response<List<TransactionResponse>>
}