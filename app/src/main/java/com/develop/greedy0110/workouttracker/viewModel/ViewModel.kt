package com.develop.greedy0110.workouttracker.viewModel

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

interface Input
interface Output

abstract class BaseViewModel: ViewModel() {
    protected val compositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}