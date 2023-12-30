package com.ezcall.di

import com.ezcall.data.AuthApiService
import com.ezcall.data.dataSource.remote.RemoteDataSource
import com.ezcall.data.dataSource.remote.RemoteDataSourceImpl
import com.ezcall.data.repository.AuthRepository
import com.ezcall.data.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideRemoteDataSource(apiService: AuthApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }

    @Provides
    fun provideAuthRepository(remoteDataSource: RemoteDataSource): AuthRepository {
        return AuthRepositoryImpl(remoteDataSource)
    }
}
