package com.ezcall.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * BaseViewModel provides common functionality for ViewModel classes.
 *
 */
@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {

//Create a static job to share across all subclasses
//    companion object {
//        private val sharedJob = SupervisorJob()
//    }

    private var mJob: Job? = null

    protected fun <T> baseRequest(
        liveData: MutableLiveData<T>,
        errorHandler: CoroutinesErrorHandler,
        request: suspend () -> Flow<T>,
    ) {
        mJob = viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler { _, error ->
            viewModelScope.launch(Dispatchers.Main) {
                errorHandler.onError(error.localizedMessage ?: "Error occurred! Pleas try again.")
            }
        }) {
            request().collect {
                withContext(Dispatchers.Main) {
                    liveData.value = it
                }
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        mJob?.let {
            if (it.isActive) {
                it.cancel()
            }
        }
    }
}


interface CoroutinesErrorHandler {
    fun onError(message: String)
}