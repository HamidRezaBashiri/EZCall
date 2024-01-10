package com.ezcall.presentation.screen.signup


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ezcall.data.dataSource.remote.ApiResponse
import com.ezcall.data.dataSource.remote.entities.AuthSignUp
import com.ezcall.data.dataSource.remote.entities.SignUpResponse
import com.ezcall.data.repository.AuthRepository
import com.ezcall.presentation.BaseViewModel
import com.ezcall.presentation.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val authRepository: AuthRepository) :
    BaseViewModel() {

    private val _signUpResponse = MutableLiveData<ApiResponse<SignUpResponse>>()
    val signUpResponse: LiveData<ApiResponse<SignUpResponse>> = _signUpResponse


    var phoneNumber by mutableStateOf("")
        private set

    fun onPhoneNumberChanged(newString: String) {
        phoneNumber = newString
    }

    var email by mutableStateOf("")
        private set

    fun onEmailChanged(newEmail: String) {
        email = newEmail
    }

    var password by mutableStateOf("")
        private set

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    fun onSignUpClicked(coroutinesErrorHandler: CoroutinesErrorHandler) {
        if (phoneNumber.isNotEmpty() && password.isNotEmpty()) {
            val signUpResponse = baseRequest(_signUpResponse, coroutinesErrorHandler) {
                authRepository.signUp(
                    AuthSignUp(
                        phoneNumber = phoneNumber,
                        password = password,
                        confirmPassword = password,
                        email = email
                    )
                )
            }

        }
    }


}