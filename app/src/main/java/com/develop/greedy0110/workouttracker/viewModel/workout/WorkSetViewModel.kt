package com.develop.greedy0110.workouttracker.viewModel.workout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.develop.greedy0110.workouttracker.model.workout.WorkSet
import com.develop.greedy0110.workouttracker.utils.SingleLiveEvent
import com.develop.greedy0110.workouttracker.utils.default
import com.develop.greedy0110.workouttracker.utils.stringToInt
import com.develop.greedy0110.workouttracker.viewModel.BaseViewModel

class WorkSetViewModel(val workSet: WorkSet = WorkSet(0,0,0)): BaseViewModel() {
//    var weight = 0
//    var rep = 0
//    var restTime = 0
//
//    init {
//        val workset = worksets.value!![pos]
//        weight = workset.weight
//        rep = workset.rep
//        restTime = workset.restTime
//        modifyWorkSet()
//    }
//
//    val input = object : WorkSetViewModelInput {
//        override fun weight(s: Int) {
//            weight = s
//            Log.d("WorksetviewModel : ", "$pos : ${getWorkSet()}")
//            modifyWorkSet()
//        }
//
//        override fun rep(s: Int) {
//            rep = s
//            modifyWorkSet()
//        }
//
//        override fun restTime(s: Int) {
//            restTime = s
//            modifyWorkSet()
//        }
//    }
//
//    fun getWorkSet(): WorkSet {
//        return WorkSet(weight, rep, restTime)
//    }
//
//    fun modifyWorkSet() {
//        worksets.value?.let {
//            if (it[pos] != getWorkSet()) { // prohibit infine loopping
//                it[pos] = getWorkSet()
//                worksets.value = it
//            }
//        }
//    }

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