package com.develop.greedy0110.workouttracker.viewModel.workout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.develop.greedy0110.workouttracker.model.workout.WorkSet
import com.develop.greedy0110.workouttracker.utils.SingleLiveEvent
import com.develop.greedy0110.workouttracker.utils.default
import com.develop.greedy0110.workouttracker.utils.stringToInt
import com.develop.greedy0110.workouttracker.viewModel.BaseViewModel

class WorkSetViewModel(val workSet: WorkSet = WorkSet(0,0,0)): BaseViewModel() {
    private val _weight = MutableLiveData<Int>().default(workSet.weight)
    private val _rep = MutableLiveData<Int>().default(workSet.rep)
    private val _restTime = MutableLiveData<Int>().default(workSet.restTime)
    private val _clickDelete = SingleLiveEvent<String>()

    val weight: LiveData<Int> get() = _weight
    val rep: LiveData<Int> get() = _rep
    val restTime: LiveData<Int> get() = _restTime
    val clickDelete: LiveData<String> get() = _clickDelete

    fun clickDelete() {
        _clickDelete.call()
    }

    fun parseWeight(data: String) {
        _weight.value = stringToInt(data)
    }

    fun parseRep(data: String) {
        _rep.value = stringToInt(data)
    }

    fun parseRestTime(data: String) {
        _restTime.value = stringToInt(data)
    }

    fun toWorkSet() = WorkSet(_weight.value?:0, _rep.value?:0, _restTime.value?:0)
}