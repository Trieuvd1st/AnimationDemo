package com.example.mvvm_baseproject.navigationComponent

import android.os.Bundle
import com.example.mvvm_baseproject.R
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor() : BaseNavigatorImpl(), AppNavigation {

    override fun openSplashToLoginScreen(bundle: Bundle?) {
        openScreen(R.id.action_splashFragment_to_loginFragment)
    }

    override fun openLoginToHomeScreen(bundle: Bundle?) {
        openScreen(R.id.action_loginFragment_to_homeFragment)
    }

}