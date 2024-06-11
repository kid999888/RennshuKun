package com.example.rennshukun.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rennshukun.room.dao.ApplicationManagementDao
import com.example.rennshukun.room.model.ApplicationManagementEntity

@Database(entities = [ApplicationManagementEntity::class], version = 1, exportSchema = false)
abstract class RennshuKunDatabase : RoomDatabase() {
    abstract fun applicationManagementDao(): ApplicationManagementDao

    companion object {
        @Volatile
        private var INSTANCE: RennshuKunDatabase? = null

        fun getDatabase(context: Context): RennshuKunDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RennshuKunDatabase::class.java,
                    "rennshu_kun_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}