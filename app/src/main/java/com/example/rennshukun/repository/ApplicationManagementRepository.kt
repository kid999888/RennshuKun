/**
 * File Name: ApplicationManagementRepository.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/06/15
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description:
 */

package com.example.rennshukun.repository

import com.example.rennshukun.room.dao.ApplicationManagementDao
import com.example.rennshukun.room.model.ApplicationManagementEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApplicationManagementRepository(
    private val applicationManagementDao: ApplicationManagementDao,
) {
    suspend fun getUuid(): String? {
        return withContext(Dispatchers.IO) {
            applicationManagementDao.getUuid()
        }
    }

    suspend fun insertNewUuid(uuid: String) {
        withContext(Dispatchers.IO) {
            val newEntity = ApplicationManagementEntity(uuid = uuid)
            applicationManagementDao.insert(newEntity)
        }
    }
}