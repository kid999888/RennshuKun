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
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.rennshukun.R
import com.example.rennshukun.base.BaseFragment
import com.example.rennshukun.databinding.FragmentSplashBinding
import com.example.rennshukun.helper.EventObserver
import com.example.rennshukun.view.splash.viewModel.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * SplashFragment
 *
 * アプリの起動時に表示されるスプラッシュ画面のフラグメント。このフラグメントは
 * UUIDのチェックおよび生成を行い、メイン画面へ遷移します。
 */
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {

    override val viewModel: SplashViewModel by viewModel()
    override fun getLayout() = R.layout.fragment_splash
    override val createNewViewWhenBack: Boolean
        get() = false

    /**
     * フラグメントのビューが作成されたときに呼び出される。
     *
     * @param view フラグメントのビュー
     * @param savedInstanceState 保存されたインスタンス状態
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // UUID チェックおよび生成を開始
        viewModel.checkAndGenerateUuid()

        // Toast メッセージの監視
        viewModel.toastMessage.observe(viewLifecycleOwner, EventObserver { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        })

        // Navigation 監視
        viewModel.navigateToMain.observe(viewLifecycleOwner, EventObserver { event ->
            Handler(Looper.getMainLooper()).postDelayed({
                val navController = findNavController()
                val navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.splash_fragment, true)
                    .build()
                navController.navigate(R.id.action_splash_to_main_fragment, null, navOptions)
            }, 1000)
        })
    }
}