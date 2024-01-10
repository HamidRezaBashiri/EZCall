package com.ezcall.presentation.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ezcall.data.dataSource.remote.ApiResponse
import com.ezcall.data.dataSource.remote.entities.AuthLogin
import com.ezcall.data.dataSource.remote.entities.LoginResponse
import com.ezcall.data.dataSource.remote.entities.TokenVerify
import com.ezcall.data.repository.AuthRepository
import com.ezcall.presentation.BaseViewModel
import com.ezcall.presentation.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository) :
    BaseViewModel() {

    private val _loginResponse = MutableLiveData<ApiResponse<LoginResponse>>()
    val loginResponse: LiveData<ApiResponse<LoginResponse>> = _loginResponse

    private val _verifyResponse = MutableLiveData<ApiResponse<LoginResponse>>()
    val verifyResponse: LiveData<ApiResponse<LoginResponse>> = _verifyResponse


    var username by mutableStateOf("")
        private set

    fun onUsernameChanged(newUsername: String) {
        username = newUsername
    }

    var password by mutableStateOf("")
        private set

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    fun onLoginClicked(coroutinesErrorHandler: CoroutinesErrorHandler) {
        if (username.isNotEmpty() && password.isNotEmpty()) {
              baseRequest(_loginResponse, coroutinesErrorHandler) {
                authRepository.login(AuthLogin(username, password))
            }

        }
    }

    fun verifyToken(token:String,coroutinesErrorHandler: CoroutinesErrorHandler){
        baseRequest(_verifyResponse,coroutinesErrorHandler){
            authRepository.verify(TokenVerify(token))
        }
    }

}