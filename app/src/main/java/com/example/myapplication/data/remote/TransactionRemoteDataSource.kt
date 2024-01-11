package com.example.myapplication.data.remote

import com.example.myapplication.data.model.TransactionResponse
import retrofit2.Response

interface TransactionRemoteDataSource {

    suspend fun getTransaction() : Response<List<TransactionResponse>>
}