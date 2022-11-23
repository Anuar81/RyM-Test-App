package com.anuar81.ryckandmortytestapp.core.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    abstract val binding: VB

    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(arguments)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addViewModelObservables()
    }

    protected open fun setUp(arguments: Bundle?) = Unit

    protected open fun addViewModelObservables() = Unit

}
