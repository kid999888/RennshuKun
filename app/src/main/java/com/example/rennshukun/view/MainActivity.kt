/**
 * File Name: MainActivity.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/05/13
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description: アプリのMainActivity
 */
package com.example.rennshukun.view

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.rennshukun.R
import com.example.rennshukun.base.BaseActivity
import com.example.rennshukun.databinding.ActivityMainBinding

/**
 * MainActivity
 *
 * アプリケーションのメインアクティビティクラス。このクラスはアプリの主要なエントリーポイントとして機能し、
 * ナビゲーションの設定を行います。
 */
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    /**
     * アクティビティが作成されたときに呼び出される。レイアウトのインフレートとナビゲーションの設定を行う。
     *
     * @param savedInstanceState 前のインスタンス状態を含むバンドル。アクティビティが新しく作成された場合はnull。
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ナビゲーション情報設定
        setUpNavgate()
    }

    /**
     * ナビゲーションを設定するためのメソッド。NavHostFragmentとNavControllerを使用して
     * ナビゲーショングラフを設定する。
     */
    private fun setUpNavgate() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navInflater = navController.navInflater
        val navGraph = navInflater.inflate(R.navigation.nav_graph)
        navController.graph = navGraph
    }
}
