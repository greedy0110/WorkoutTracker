package com.develop.greedy0110.workouttracker.viewModel

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import io.reactivex.disposables.CompositeDisposable

interface Input
interface Output

abstract class BaseViewModel: ViewModel()