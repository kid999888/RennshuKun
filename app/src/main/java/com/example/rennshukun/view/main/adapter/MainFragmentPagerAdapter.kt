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

/**
 * MainFragmentPagerAdapter
 *
 * ViewPager2 で使用されるフラグメントのページアダプタークラス。このクラスは
 * 3つのフラグメント（HomeFragment、DashboardFragment、NotificationsFragment）を管理します。
 *
 * @param fragment 親フラグメント
 */
class MainFragmentPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    /**
     * アイテム数を返すメソッド。
     *
     * @return ページ数（3）
     */
    override fun getItemCount(): Int = 3

    /**
     * 指定された位置に対応するフラグメントを生成するメソッド。
     *
     * @param position フラグメントの位置
     * @return 生成されたフラグメント
     */
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment() // 位置0の場合、HomeFragmentを返す
            1 -> DashboardFragment() // 位置1の場合、DashboardFragmentを返す
            2 -> NotificationsFragment() // 位置2の場合、NotificationsFragmentを返す
            else -> throw IllegalStateException("Unexpected position $position")  // 想定外の位置の場合、例外を返す
        }
    }
}