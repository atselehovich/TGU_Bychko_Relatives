package com.kotlinstudy.bychkoanna.util


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlinstudy.bychkoanna.MyApplication


inline fun <reified VM: ViewModel> Fragment.viewModelProviderWithSavedState(
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE) = lazy(mode) {
    val app = MyApplication.instance
    val saveStateFactory = SavedStateViewModelFactory(app, this)
    val provider = ViewModelProvider(this, saveStateFactory)
    provider.get(VM::class.java)
}

inline fun <reified VM: ViewModel> FragmentActivity.viewModelProviderWithSavedState(
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE) = lazy(mode) {
    val app = MyApplication.instance
    val saveStateFactory = SavedStateViewModelFactory(app, this)
    val provider = ViewModelProvider(this, saveStateFactory)
    provider.get(VM::class.java)
}

inline fun <reified VM: ViewModel> Fragment.activityViewModelProviderWithSavedState(
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE) = lazy(mode) {
    val owner = this.context as FragmentActivity
    val app = MyApplication.instance
    val saveStateFactory = SavedStateViewModelFactory(app, this)
    val provider = ViewModelProvider(owner, saveStateFactory)
    provider.get(VM::class.java)
}

inline fun <reified VM: ViewModel> Fragment.viewModelProvider(
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE,
    factory: ViewModelProvider.Factory? = null) = lazy(mode) {
    val provider = if (factory == null) ViewModelProvider(this) else ViewModelProvider(this, factory)
    provider.get(VM::class.java)
}

inline fun <reified VM: ViewModel> FragmentActivity.viewModelProvider(
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE,
    factory: ViewModelProvider.Factory? = null) = lazy(mode) {
    val provider = if (factory == null) ViewModelProvider(this) else ViewModelProvider(this, factory)
    provider.get(VM::class.java)
}

inline fun <reified VM: ViewModel> Fragment.activityViewModelProvider(
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.NONE,
    factory: ViewModelProvider.Factory? = null) = lazy(mode) {
    val owner = this.context as FragmentActivity
    val provider = if (factory == null) ViewModelProvider(owner) else ViewModelProvider(owner, factory)
    provider.get(VM::class.java)
}