package com.anuar81.ryckandmortytestapp.core.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anuar81.ryckandmortytestapp.domain.core.nav.NavModel

abstract class BaseViewModel() : ViewModel() {
    protected val _showError = MutableLiveData<Unit>()
    val showError : LiveData<Unit> get() = _showError
    protected val _navigateTo = MutableLiveData<NavModel>()
    val navigateTo : LiveData<NavModel> get() = _navigateTo

    @CallSuper
    open fun setUp(bundle: Bundle?) {
    }

    @CallSuper
    open fun setUp() {
    }
}
