package com.develop.greedy0110.workouttracker.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.develop.greedy0110.workouttracker.data.WorkSet

class WorkSetViewModel(val pos: Int, val worksets: MutableLiveData<MutableList<WorkSet>>): BaseViewModel() {
    private var weight = 0
    private var rep = 0
    private var restTime = 0

    init {
        val workset = worksets.value!![pos]
        weight = workset.weight
        rep = workset.rep
        restTime = workset.restTime
        modifyWorkSet()
    }

    val input = object : WorkSetViewModelInput {
        override fun weight(s: Int) {
            weight = s
            Log.d("WorksetviewModel : ", "$pos : ${getWorkSet()}")
            modifyWorkSet()
        }

        override fun rep(s: Int) {
            rep = s
            modifyWorkSet()
        }

        override fun restTime(s: Int) {
            restTime = s
            modifyWorkSet()
        }
    }

    fun getWorkSet(): WorkSet {
        return WorkSet(weight, rep, restTime)
    }

    fun modifyWorkSet() {
        worksets.value?.let {
            if (it[pos] != getWorkSet()) { // prohibit infine loopping
                it[pos] = getWorkSet()
                worksets.value = it
            }
        }
    }
}

interface WorkSetViewModelInput: Input {
    fun weight(s: Int)
    fun rep(s: Int)
    fun restTime(s: Int)
}