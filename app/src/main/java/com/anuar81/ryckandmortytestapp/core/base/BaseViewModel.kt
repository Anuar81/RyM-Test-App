package com.anuar81.ryckandmortytestapp.core.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel() : ViewModel() {
    protected val _showError = MutableLiveData<Unit>()
    val showError : LiveData<Unit> get() = _showError

    @CallSuper
    open fun setUp(bundle: Bundle?) {
    }

    @CallSuper
    open fun setUp() {
    }
}
