package com.example.mvvm_baseproject.ui.splash

import android.os.Handler
import android.os.Looper
import com.example.mvvm_baseproject.data.sharedPrefs.RxPreferences
import com.example.mvvm_baseproject.domain.network.api.ApiService
import com.example.mvvm_baseproject.domain.network.api.ApiServiceNoAuth
import com.example.mvvm_baseproject.rx.AppRxSchedulers
import com.example.mvvm_baseproject.rx.RxSchedulers
import com.example.mvvm_baseproject.ui.base.BaseViewModel
import com.example.mvvm_baseproject.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val apiServiceNoAuth: ApiServiceNoAuth,
    private val rxPreferences: RxPreferences,
    private val rxSchedulers: RxSchedulers
) : BaseViewModel() {

    val actionSPlash = SingleLiveEvent<SplashActionState>()

    private val handler = Handler(Looper.getMainLooper())

    override fun onCleared() {
        handler.removeCallbacksAndMessages(null)
        super.onCleared()
    }
}

sealed class SplashActionState {
    object Finish : SplashActionState()
}