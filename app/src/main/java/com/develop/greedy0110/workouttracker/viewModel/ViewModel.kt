package com.develop.greedy0110.workouttracker.viewModel

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface Input
interface Output

abstract class BaseViewModel: ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}