/**
 * File Name: BaseFragment.kt
 * Project Name: Rennshu Kun
 * Creator: Gyoushin Ou
 * Creation Date: 2024/05/13
 * Copyright: © 2024 Gyoushin Ou. All rights reserved.
 * Description: This file implements...
 */
package com.example.rennshukun.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

abstract class BaseFragment<TBinding : ViewDataBinding, TViewModel : BaseViewModel> : Fragment() {
    // 自身管理したbindingデータ
    lateinit var binding: TBinding

    // 自身管理したviewModelデータ
    protected abstract val viewModel: TViewModel

    // 子Fragmentから戻る時、Fragmentの再作成するか。
    protected open val createNewViewWhenBack: Boolean get() = true

    /**
     * レイアウトIDを取得する
     *
     * @return レイアウトID(Int)
     */
    abstract fun getLayout(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (createNewViewWhenBack || !::binding.isInitialized) {
            // 画面初期化処理
            setupBinding(inflater, container)
            afterBinding()
        }

        if (binding.lifecycleOwner != viewLifecycleOwner) {
            binding.lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        setViewClickListener()
        setViewModelObserve(viewLifecycleOwner)

    }

    /**
     * Bindingの初期化
     *
     * @param inflater レイアウトを膨張させるためのLayoutInflater
     * @param container 親ビューを保持するViewGroup（null可）
     *
     */
    private fun setupBinding(inflater: LayoutInflater, container: ViewGroup?) {
        val layout = getLayout()
        binding = DataBindingUtil.inflate(
            inflater,
            layout, container, false
        )
        binding.lifecycleOwner = viewLifecycleOwner
    }

    /**
     * Binding直後処理
     *
     */
    protected open fun afterBinding() {}

    /**
     * UI内容設定
     *
     */
    protected open fun setUpUI() {}

    /**
     * View内クリックリスナー
     *
     */
    protected open fun setViewClickListener() {}

    /**
     * ViewModel監視を設定する
     *
     */
    protected open fun setViewModelObserve(viewLifecycleOwner: LifecycleOwner) {}

    override fun onDestroyView() {
        super.onDestroyView()
        // binding取り消す
        binding.unbind()
    }
}