/**
 * File Name: NotificationsFragment.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/05/13
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description: This file implements...
 */
package com.example.rennshukun.view.main.notification.fragment

import androidx.lifecycle.LifecycleOwner
import com.example.rennshukun.R
import com.example.rennshukun.base.BaseFragment
import com.example.rennshukun.databinding.FragmentNotificationsBinding
import com.example.rennshukun.view.main.notification.viewModel.NotificationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * NotificationFragment
 *
 * 通知画面を表示するフラグメント。このクラスは通知に関するデータを表示し、ViewModel を使用してデータの変更を監視します。
 */
class NotificationFragment : BaseFragment<FragmentNotificationsBinding, NotificationViewModel>() {
    override val viewModel: NotificationViewModel by viewModel()
    override fun getLayout() = R.layout.fragment_notifications
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
                binding.textNotifications.text = it
            }
        }
    }
}
