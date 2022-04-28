package com.fachrizalmrsln.newsplashscreenapi_android12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _splashReady = MutableLiveData(true)
    val splashReady: LiveData<Boolean>
        get() = _splashReady

    init {
        viewModelScope.launch {
            delay(3000)
            _splashReady.postValue(false)
        }
    }

}