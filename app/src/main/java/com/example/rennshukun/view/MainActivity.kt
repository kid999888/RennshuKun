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
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.rennshukun.R
import com.example.rennshukun.base.BaseActivity
import com.example.rennshukun.databinding.ActivityMainBinding
import com.example.rennshukun.room.dao.ApplicationManagementDao
import com.example.rennshukun.room.model.ApplicationManagementEntity
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.util.UUID

/**
 * MainActivity
 *
 */
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private val applicationManagementDao: ApplicationManagementDao by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // RoomDBアクセス
        lifecycleScope.launch {
            val uuid = applicationManagementDao.getFirstUuid()
            if (uuid == null) {
                val newUuid = UUID.randomUUID().toString()
                val newEntity = ApplicationManagementEntity(uuid = newUuid)
                applicationManagementDao.insert(newEntity)
                runOnUiThread {
                    Toast.makeText(this@MainActivity, "New UUID saved: $newUuid", Toast.LENGTH_LONG)
                        .show()
                }
            } else {
                Toast.makeText(this@MainActivity, "UUID exists: $uuid", Toast.LENGTH_LONG).show()
            }
        }

        // ナビゲーション情報設定
        setUpNavgate()
    }

    private fun setUpNavgate() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navInflater = navController.navInflater
        val navGraph = navInflater.inflate(R.navigation.nav_graph)
        navController.graph = navGraph
    }

}
