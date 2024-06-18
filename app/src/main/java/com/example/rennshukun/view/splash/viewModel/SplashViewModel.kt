/**
 * File Name: SplashViewModel.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/06/15
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description:
 */
package com.example.rennshukun.view.splash.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rennshukun.base.BaseViewModel
import com.example.rennshukun.helper.Event
import com.example.rennshukun.repository.ApplicationManagementRepository
import kotlinx.coroutines.launch
import java.util.UUID

/**
 * SplashViewModel
 *
 * スプラッシュ画面で使用されるViewModel。このクラスはUUIDのチェックおよび生成を行い、
 * ToastメッセージやナビゲーションのLiveDataを管理します。
 *
 * @param repository アプリケーション管理リポジトリ
 */
class SplashViewModel(
    private val repository: ApplicationManagementRepository,
) : BaseViewModel() {

    // Toastメッセージを保持するLiveData
    private val _toastMessage = MutableLiveData<Event<String>>()
    val toastMessage: LiveData<Event<String>> get() = _toastMessage

    // メイン画面へのナビゲーションを管理するLiveData
    private val _navigateToMain = MutableLiveData<Event<Boolean>>()
    val navigateToMain: LiveData<Event<Boolean>> get() = _navigateToMain

    /**
     * UUIDのチェックおよび生成を行う関数。
     * データベースにUUIDが存在しない場合、新しいUUIDを生成して保存し、存在する場合は既存のUUIDを使用します。
     */
    fun checkAndGenerateUuid() {
        viewModelScope.launch {
            val dbUuid = repository.getUuid()
            if (dbUuid == null) {
                // 新しいUUIDを生成して保存
                val newUuid = UUID.randomUUID().toString()
                repository.insertNewUuid(newUuid)
                _toastMessage.postValue(Event("New UUID saved: $newUuid"))
            } else {
                // 既存のUUIDを使用
                _toastMessage.postValue(Event("UUID exists: $dbUuid"))
            }
            // メイン画面へのナビゲーションを指示
            _navigateToMain.postValue(Event(true))
        }
    }

}