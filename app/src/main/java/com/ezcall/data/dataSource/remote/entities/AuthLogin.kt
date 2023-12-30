package com.ezcall.data.dataSource.remote.entities

import com.google.gson.annotations.SerializedName

data class AuthLogin(@SerializedName("phone_number") val phoneNumber: String, val password: String)
