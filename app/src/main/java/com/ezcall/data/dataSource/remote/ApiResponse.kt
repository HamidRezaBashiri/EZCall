package com.ezcall.data.dataSource.remote

sealed class ApiResponse<out T> {
    object Loading : ApiResponse<Nothing>()
    object Idle : ApiResponse<Nothing>()

    data class Success<out T>(val data: T) : ApiResponse<T>()

    data class Failure(val errorMessage: String, val errorCode: Int) : ApiResponse<Nothing>()
}