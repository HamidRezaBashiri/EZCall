package com.ezcall.data.dataSource.remote

import com.ezcall.data.AuthApiService
import com.ezcall.data.dataSource.remote.entities.AuthLogin
import com.ezcall.data.dataSource.remote.entities.AuthSignUp
import com.ezcall.data.dataSource.remote.entities.LoginResponse
import com.ezcall.data.dataSource.remote.entities.SignUpResponse
import com.ezcall.data.dataSource.remote.entities.TokenVerify
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiService: AuthApiService) :
    RemoteDataSource {
    override suspend fun login(authLogin: AuthLogin): Flow<ApiResponse<LoginResponse>> {
        return apiRequestFlow { apiService.loginUser(authLogin) }
    }

    override suspend fun signUp(authSignUp: AuthSignUp): Flow<ApiResponse<SignUpResponse>> {
        return apiRequestFlow { apiService.signUpUser(authSignUp) }
    }

    override suspend fun verify(token: TokenVerify): Flow<ApiResponse<LoginResponse>> {
        return apiRequestFlow { apiService.verifyToken(token) }
    }

}