package com.ezcall.data.dataSource.remote.entities

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("access")
    val accessToken: String,
    @SerializedName("refresh")
    val refreshToken: String,
)
