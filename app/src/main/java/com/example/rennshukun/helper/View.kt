/**
 * File Name: View.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/06/16
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description:
 */

package com.example.rennshukun.helper

import android.os.SystemClock
import android.view.View

/**
 * View に対して、連続クリックを防止するためのクリックリスナーを設定します。
 * 短時間に複数回クリックした場合、最初のクリックのみが処理され、
 * 設定された時間間隔が経過するまで後続のクリックは無視されます。
 *
 * @param listener クリックイベントが発生したときに呼び出される関数。
 */
fun View.setOnClickDebounce(listener: () -> Unit) {
    debounceClick { listener.invoke() }
}

/**
 * View に対して、連続クリックを防止するためのクリックリスナーを設定し、
 * カスタムの時間間隔を指定できます。
 * 短時間に複数回クリックした場合、最初のクリックのみが処理され、
 * 設定された時間間隔が経過するまで後続のクリックは無視されます。
 *
 * @param block 連続クリックを防止するための時間間隔（ミリ秒単位）。デフォルトは900ミリ秒。
 * @param listener クリックイベントが発生したときに呼び出される関数。
 */
fun View?.debounceClick(block: Long = 300, listener: () -> Unit) {
    this?.run {
        var lastClickTime: Long = 0
        setOnClickListener {
            val realTime = SystemClock.elapsedRealtime()
            if (realTime - lastClickTime > block) {
                lastClickTime = realTime
                listener()
            } else return@setOnClickListener
        }
    }
}