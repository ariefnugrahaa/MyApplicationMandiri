package com.example.myapplication.data.remote

import com.example.myapplication.data.ServiceMandiri
import com.example.myapplication.data.model.TransactionResponse
import retrofit2.Response
import javax.inject.Inject

class TransactionRemoteDataSourceImpl @Inject constructor(
    private val service: ServiceMandiri
) : TransactionRemoteDataSource {

    override suspend fun getTransaction(): Response<List<TransactionResponse>> {
        return service.getTransaction()
    }
}