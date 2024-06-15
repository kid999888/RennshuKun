package com.example.rennshukun.room.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "application_management")
data class ApplicationManagementEntity(
    @PrimaryKey val uuid: String
) : Parcelable
