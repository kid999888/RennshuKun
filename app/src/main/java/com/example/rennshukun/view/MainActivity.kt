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
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rennshukun.R
import com.example.rennshukun.databinding.ActivityMainBinding
import com.example.rennshukun.room.RennshuKunDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * MainActivity
 *
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var database: RennshuKunDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RoomDB初期化
        database = RennshuKunDatabase.getDatabase(this)

        //
        GlobalScope.launch {
            val appManagementEntity =
                database.applicationManagementDao().getApplicationManagement("app_management_uuid")
            appManagementEntity?.let {
                runOnUiThread {
                    Toast.makeText(this@MainActivity, "UUID: ${it.uuid}", Toast.LENGTH_LONG).show()
                }
            }
        }

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}