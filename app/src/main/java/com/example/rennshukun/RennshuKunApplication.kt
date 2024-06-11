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
import android.util.Log
import com.example.rennshukun.room.RennshuKunDatabase
import com.example.rennshukun.room.model.ApplicationManagementEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.UUID

/**
 * RennshuKunApplication
 *
 */
class RennshuKunApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val db = RennshuKunDatabase.getDatabase(this)
        val dao = db.applicationManagementDao()

        GlobalScope.launch {
            val applicationManagementEntity = dao.getApplicationManagement("app_management_uuid")
            if (applicationManagementEntity == null) {
                val newUUID = UUID.randomUUID().toString()
                dao.insert(ApplicationManagementEntity(uuid = newUUID))
                Log.d("UUID", "Generated new UUID: $newUUID")
            } else {
                Log.d("UUID", "Existing UUID: ${applicationManagementEntity.uuid}")
            }
        }
    }
}
