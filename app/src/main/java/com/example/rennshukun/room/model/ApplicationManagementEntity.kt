package com.example.rennshukun.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "application_management")
data class ApplicationManagementEntity(
    @PrimaryKey val uuid: String
)
