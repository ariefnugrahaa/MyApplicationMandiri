package com.example.myapplication.data.repository

import com.example.myapplication.data.model.TransactionResponse
import com.example.myapplication.data.remote.TransactionRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val remoteDataSource: TransactionRemoteDataSource
) : TransactionRepository {

    override suspend fun getTransaction(): Response<List<TransactionResponse>> {
        return remoteDataSource.getTransaction()
    }
}