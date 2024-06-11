package com.example.rennshukun.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.rennshukun.base.BaseDao
import com.example.rennshukun.room.model.ApplicationManagementEntity

@Dao
interface ApplicationManagementDao : BaseDao<ApplicationManagementEntity> {
    @Query("SELECT * FROM application_management WHERE uuid = :uuid")
    suspend fun getApplicationManagement(uuid: String): ApplicationManagementEntity?
}