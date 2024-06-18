package com.example.rennshukun.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rennshukun.room.dao.ApplicationManagementDao
import com.example.rennshukun.room.model.ApplicationManagementEntity

/**
 * RennshuKunDatabase
 *
 * アプリケーションのデータベースクラス。このクラスはRoomデータベースを定義し、
 * アプリケーション管理DAOへのアクセスを提供します。
 */
@Database(entities = [ApplicationManagementEntity::class], version = 1, exportSchema = false)
abstract class RennshuKunDatabase : RoomDatabase() {

    /**
     * アプリケーション管理DAOを取得する抽象メソッド。
     *
     * @return ApplicationManagementDao
     */
    abstract fun applicationManagementDao(): ApplicationManagementDao

    companion object {
        @Volatile
        private var INSTANCE: RennshuKunDatabase? = null

        /**
         * データベースのインスタンスを取得する。
         *
         * @param context コンテキスト
         * @return RennshuKunDatabaseのインスタンス
         */
        fun getDatabase(context: Context): RennshuKunDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RennshuKunDatabase::class.java,
                    "rennshu_kun_database"
                )
                    //.addMigrations(DemoDatabase.MIGRATION_1_to_2) // TODO: マイグレーションの時に追加必要
                    //.fallbackToDestructiveMigration() // TODO: マイグレーションの時に追加必要(旧データ保存必要ないの場合)
                    .build()
                INSTANCE = instance
                instance
            }

            // TODO : マイグレーションの時に追加必要
//        val MIGRATION_1_to_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                // マイグレーション処理
//            }
//        }
        }
    }
}
