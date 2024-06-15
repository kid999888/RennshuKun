package com.example.rennshukun.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.rennshukun.base.BaseDao
import com.example.rennshukun.room.model.ApplicationManagementEntity

@Dao
interface ApplicationManagementDao : BaseDao<ApplicationManagementEntity> {
    @Query("SELECT * FROM application_management LIMIT 1")
    suspend fun getFirstApplicationManagement(): ApplicationManagementEntity?

    @Query("SELECT uuid FROM application_management LIMIT 1")
    suspend fun getUuid(): String?
}