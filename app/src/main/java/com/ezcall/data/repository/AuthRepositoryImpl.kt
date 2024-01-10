package com.ezcall.data.repository

import com.ezcall.data.dataSource.remote.ApiResponse
import com.ezcall.data.dataSource.remote.RemoteDataSource
import com.ezcall.data.dataSource.remote.entities.AuthLogin
import com.ezcall.data.dataSource.remote.entities.AuthSignUp
import com.ezcall.data.dataSource.remote.entities.LoginResponse
import com.ezcall.data.dataSource.remote.entities.SignUpResponse
import com.ezcall.data.dataSource.remote.entities.TokenVerify
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    AuthRepository {
    override suspend fun login(authLogin: AuthLogin): Flow<ApiResponse<LoginResponse>> {
        return remoteDataSource.login(authLogin)
    }

    override suspend fun signUp(authSignUp: AuthSignUp): Flow<ApiResponse<SignUpResponse>> {
        return remoteDataSource.signUp(authSignUp)
    }

    override suspend fun verify(token: TokenVerify): Flow<ApiResponse<LoginResponse>> {
        return  remoteDataSource.verify(token)
    }

}