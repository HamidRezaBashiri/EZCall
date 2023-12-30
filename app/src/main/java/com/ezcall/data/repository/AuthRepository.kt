package com.ezcall.data.repository

import com.ezcall.data.dataSource.remote.ApiResponse
import com.ezcall.data.dataSource.remote.entities.AuthLogin
import com.ezcall.data.dataSource.remote.entities.AuthSignUp
import com.ezcall.data.dataSource.remote.entities.LoginResponse
import com.ezcall.data.dataSource.remote.entities.SignUpResponse
import com.ezcall.data.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface AuthRepository {
    suspend fun login(authLogin: AuthLogin): Flow<ApiResponse<LoginResponse>>

    suspend fun signUp(authSignUp: AuthSignUp): Flow<ApiResponse<SignUpResponse>>

}