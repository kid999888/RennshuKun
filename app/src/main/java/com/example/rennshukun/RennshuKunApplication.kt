/**
 * File Name: RennshuKunApplication.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/05/13
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description: This file implements...
 */
package com.example.rennshukun

import android.app.Application
import com.example.rennshukun.room.RennshuKunDatabase
import com.example.rennshukun.view.main.viewModel.MainViewModel
import com.example.rennshukun.view.splash.viewModel.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

/**
 * RennshuKunApplication
 *
 */
class RennshuKunApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@RennshuKunApplication)
            modules(rennshuKunAppModule)
        }
    }

    private val rennshuKunAppModule = module {
        // RennshuKunDatabase
        single { RennshuKunDatabase.getDatabase(androidContext()) }

        // DB
        single { get<RennshuKunDatabase>().applicationManagementDao() }

        // ViewModel
        viewModel { SplashViewModel() }
        viewModel { MainViewModel() }
    }
}
