package com.ezcall.data.dataSource.remote

import com.ezcall.data.dataSource.remote.entities.AuthLogin
import com.ezcall.data.dataSource.remote.entities.AuthSignUp
import com.ezcall.data.dataSource.remote.entities.LoginResponse
import com.ezcall.data.dataSource.remote.entities.SignUpResponse
import com.ezcall.data.dataSource.remote.entities.TokenVerify
import com.ezcall.data.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


interface RemoteDataSource {
    suspend fun login(authLogin: AuthLogin): Flow<ApiResponse<LoginResponse>>

    suspend fun signUp(authSignUp: AuthSignUp): Flow<ApiResponse<SignUpResponse>>

    suspend fun verify(token:TokenVerify):Flow<ApiResponse<LoginResponse>>
}
