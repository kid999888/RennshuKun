/**
 * File Name: MainFragmentPagerAdapter.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/06/15
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description:
 */

package com.example.rennshukun.view.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rennshukun.view.main.dashboard.DashboardFragment
import com.example.rennshukun.view.main.home.HomeFragment
import com.example.rennshukun.view.main.notifications.NotificationsFragment

class MainFragmentPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> DashboardFragment()
            2 -> NotificationsFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}