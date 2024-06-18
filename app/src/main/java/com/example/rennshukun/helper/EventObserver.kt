/**
 * File Name: EventObserver.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/06/16
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description:
 */

package com.example.rennshukun.helper

import androidx.lifecycle.Observer

/**
 * イベントオブザーバー
 *
 * @param T T
 * @property onEventUnhandledContent [Event]のコンテンツが処理されていない場合にのみ呼び出される
 * @constructor 空のイベントオブザーバーを作成する
 */
class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(it: Event<T>) {
        // イベントの内容が未処理の場合のみ処理する
        it.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}