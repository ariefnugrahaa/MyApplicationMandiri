package com.example.myapplication.module

import com.example.myapplication.data.ServiceMandiri
import com.example.myapplication.data.remote.TransactionRemoteDataSource
import com.example.myapplication.data.remote.TransactionRemoteDataSourceImpl
import com.example.myapplication.data.repository.TransactionRepository
import com.example.myapplication.data.repository.TransactionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MessageModule {

    @Provides
    @Singleton
    fun provideTransactionRemoteDataSource(service: ServiceMandiri): TransactionRemoteDataSource =
        TransactionRemoteDataSourceImpl(service)

    @Provides
    @Singleton
    fun providesTransactionRepository(remoteDataSource: TransactionRemoteDataSource): TransactionRepository =
        TransactionRepositoryImpl(remoteDataSource)
}