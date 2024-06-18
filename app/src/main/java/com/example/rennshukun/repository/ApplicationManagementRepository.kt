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

/**
 * ApplicationManagementRepository
 *
 * アプリケーション管理データのリポジトリ。このクラスはDAOを使用して
 * データベース操作を非同期に行います。
 *
 * @param applicationManagementDao アプリケーション管理DAO
 */
class ApplicationManagementRepository(
    private val applicationManagementDao: ApplicationManagementDao,
) {
    /**
     * データベースからUUIDを取得する
     *
     * @return UUID、存在しない場合はnull
     */
    suspend fun getUuid(): String? {
        return withContext(Dispatchers.IO) {
            applicationManagementDao.getUuid()
        }
    }

    /**
     * 新しいUUIDをデータベースに挿入する
     *
     * @param uuid 新しいUUID
     */
    suspend fun insertNewUuid(uuid: String) {
        withContext(Dispatchers.IO) {
            val newEntity = ApplicationManagementEntity(uuid = uuid)
            applicationManagementDao.insert(newEntity)
        }
    }
}
