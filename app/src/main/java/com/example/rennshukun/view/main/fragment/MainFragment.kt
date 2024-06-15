/**
 * File Name: MainFragment.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/06/15
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description:
 */

package com.example.rennshukun.view.main.fragment

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.rennshukun.R
import com.example.rennshukun.base.BaseFragment
import com.example.rennshukun.databinding.FragmentMainBinding
import com.example.rennshukun.view.main.adapter.MainFragmentPagerAdapter
import com.example.rennshukun.view.main.viewModel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModel()
    override fun getLayout() = R.layout.fragment_main
    override val createNewViewWhenBack: Boolean
        get() = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPage()
    }

    private fun setViewPage() {
        val viewPager: ViewPager2 = binding.viewPager
        val navView: BottomNavigationView = binding.navView

        val pagerAdapter = MainFragmentPagerAdapter(this)
        viewPager.adapter = pagerAdapter
        
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    viewPager.currentItem = 0
                    true
                };
                R.id.navigation_dashboard -> {
                    viewPager.currentItem = 1
                    true
                };
                R.id.navigation_notifications -> {
                    viewPager.currentItem = 2
                    true
                };
                else -> false;
            }
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> navView.selectedItemId = R.id.navigation_home
                    1 -> navView.selectedItemId = R.id.navigation_dashboard
                    2 -> navView.selectedItemId = R.id.navigation_notifications
                }
            }
        })
    }

}