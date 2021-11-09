package com.example.mvvm_baseproject.navigationComponent

import android.os.Bundle

interface AppNavigation : BaseNavigator {
    fun openSplashToLoginScreen(bundle: Bundle? = null)

    fun openLoginToHomeScreen(bundle: Bundle? = null)
}