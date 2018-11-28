package com.develop.greedy0110.workouttracker.viewModel

import android.util.Log

class WorkSetViewModel: BaseViewModel() {
    private var weight = 0
    private var rep = 0
    private var restTime = 0
    val input = object : WorkSetViewModelInput {
        override fun weight(s: Int) {
            Log.d("WorksetViewModel :", "$s")
            weight = s
        }

        override fun rep(s: Int) {
            rep = s
        }

        override fun restTime(s: Int) {
            restTime = s
        }
    }
}

interface WorkSetViewModelInput: Input {
    fun weight(s: Int)
    fun rep(s: Int)
    fun restTime(s: Int)
}