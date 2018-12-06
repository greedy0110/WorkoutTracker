package com.develop.greedy0110.workouttracker.viewModel

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { WorkoutViewModel(get(parameters = {it})) }
}