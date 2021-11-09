package com.example.mvvm_baseproject.ui.home

import android.os.Bundle
import com.example.mvvm_baseproject.R
import com.example.mvvm_baseproject.databinding.FragmentHomeBinding
import com.example.mvvm_baseproject.databinding.FragmentSplashBinding
import com.example.mvvm_baseproject.ui.base.BaseFragment
import com.example.mvvm_baseproject.utils.setTextCompute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
    }
}