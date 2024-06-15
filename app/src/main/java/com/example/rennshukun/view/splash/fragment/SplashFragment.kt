/**
 * File Name: SplashFragment.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/06/15
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description:
 */
package com.example.rennshukun.view.splash.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.rennshukun.R
import com.example.rennshukun.base.BaseFragment
import com.example.rennshukun.databinding.FragmentSplashBinding
import com.example.rennshukun.view.splash.viewModel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {

    override val viewModel: SplashViewModel by viewModel()
    override fun getLayout() = R.layout.fragment_splash
    override val createNewViewWhenBack: Boolean
        get() = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            val navController = findNavController()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.splash_fragment, true) // 清除返回栈中的 SplashFragment
                .build()
            navController.navigate(R.id.action_splash_to_main_fragment, null, navOptions)
        }, 2000)
    }
}