/**
 * File Name: HomeFragment.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/05/13
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description: This file implements...
 */
package com.example.rennshukun.view.main.home.fragment

import androidx.lifecycle.LifecycleOwner
import com.example.rennshukun.R
import com.example.rennshukun.base.BaseFragment
import com.example.rennshukun.databinding.FragmentHomeBinding
import com.example.rennshukun.view.main.home.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * HomeFragment
 *
 * ホーム画面を表示するフラグメント。このクラスは通知に関するデータを表示し、ViewModel を使用してデータの変更を監視します。
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModel()
    override fun getLayout() = R.layout.fragment_home
    override val createNewViewWhenBack: Boolean
        get() = false

    /**
     * ViewModel の LiveData を監視するためのメソッド。
     *
     * @param viewLifecycleOwner ライフサイクルオーナー
     */
    override fun setViewModelObserve(viewLifecycleOwner: LifecycleOwner) {
        super.setViewModelObserve(viewLifecycleOwner)

        viewModel.text.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.textHome.text = it
            }
        }
    }
}