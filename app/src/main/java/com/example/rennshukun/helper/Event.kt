/**
 * File Name: Event.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/06/16
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description:
 */

package com.example.rennshukun.helper

/**
 * イベントを表すクラス。このクラスは一度だけ処理されるべきデータを保持します。
 *
 * @param T イベントの内容の型
 * @property content イベントの内容
 */
open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // 外部から読み取り可能ですが、書き込みは不可

    /**
     * 内容が未処理の場合にのみ内容を返し、処理済みとしてマークします。
     *
     * @return 内容、すでに処理されている場合はnull
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * 内容がすでに処理されていても、常に内容を返します。
     *
     * @return 内容
     */
    fun peekContent(): T = content
}
