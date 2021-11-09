package com.example.mvvm_baseproject.ui.login

import android.os.Bundle
import com.example.mvvm_baseproject.R
import com.example.mvvm_baseproject.databinding.FragmentLoginBinding
import com.example.mvvm_baseproject.navigationComponent.AppNavigation
import com.example.mvvm_baseproject.ui.base.BaseFragment
import com.example.mvvm_baseproject.utils.setTextCompute
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    @Inject
    lateinit var appNavigation: AppNavigation

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        binding.btnToHome.setOnClickListener {
            appNavigation.openLoginToHomeScreen()
        }
    }
}