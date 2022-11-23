package com.anuar81.ryckandmortytestapp.core.base

import android.app.ActionBar
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.anuar81.ryckandmortytestapp.R
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception


abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    abstract val binding: VB

    abstract val viewModel: VM

    protected var toolbar : Toolbar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(arguments)
        setupToolbar()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addViewModelObservables()
    }

    protected open fun setUp(arguments: Bundle?) = Unit

    protected open fun addViewModelObservables() = Unit

    protected fun showToast(msg: String) {
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT)
            .show()
    }

    protected fun setTitle(title: String?) {
        toolbar?.let {
            it.title = title
        }
    }

    private fun setupToolbar() {
        try {
            toolbar = requireActivity().findViewById(R.id.toolbar)
        }catch (e: Exception) {}
        toolbar?.let {
            it.setNavigationOnClickListener { requireActivity().onBackPressed() }
        }
        setTitle(getString(R.string.app_name))

    }

}
