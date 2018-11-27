package com.develop.greedy0110.workouttracker.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.Bindable
import android.util.Log
import com.develop.greedy0110.workouttracker.Logger
import com.develop.greedy0110.workouttracker.data.TypeOfExercise
import com.develop.greedy0110.workouttracker.data.WorkSet
import com.develop.greedy0110.workouttracker.data.Workout
import com.develop.greedy0110.workouttracker.data.repository.WorkoutRepository

class AddWorkoutViewModel(
    val logger: Logger,
    val repository: WorkoutRepository
): BaseViewModel() {
    private var name = ""
    private var target = ""
    private var weight = 0
    private var rep = 0
    private var restTime = 0
    private var memo = ""
    val input = object: AddWorkoutViewModelInput {
        override fun name(s: String) {
            name = s
            enableAddButton()
        }

        override fun target(s: String) {
            target = s
            enableAddButton()
        }

        override fun weight(s: Int) {
            weight = s
            enableAddButton()
        }

        override fun rep(s: Int) {
            rep = s
            enableAddButton()
        }

        override fun restTime(s: Int) {
            restTime = s
        }

        override fun memo(s: String) {
            memo = s
        }
    }

    private val addButtonState: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val output = object : AddWorkoutViewModelOutput {
        override fun addButtonState() = addButtonState
        override fun clickAddButton() {
            val wo = Workout(
                TypeOfExercise(name, target),
                listOf(WorkSet(weight, rep, restTime)),
                memo
            )
            repository.addWorkout(wo)

        }
    }

    fun enableAddButton() {
        var enable = true
        if (name.isNullOrEmpty()) {
            enable= false
        }
        if (target.isNullOrEmpty()) {
            enable= false
        }
        if (weight <= 0) {
            enable= false
        }
        if (rep <= 0) {
            enable= false
        }
        addButtonState.value = enable
    }

    init {
        addDisposable(repository.getWorkouts()
            .doOnError { t -> Log.e("viewModel : ", "$t") }
            .subscribe {
                Log.d("viewModel : ", "done")
                for (i in 0 until it.size-1)
                    Log.d("$i 운동 : ", "${it[i]}")
            })
    }
}

interface AddWorkoutViewModelInput: Input {
    fun name(s: String)
    fun target(s: String)
    fun weight(s: Int)
    fun rep(s: Int)
    fun restTime(s: Int)
    fun memo(s: String)
}

interface AddWorkoutViewModelOutput: Output {
    fun addButtonState(): LiveData<Boolean>
    fun clickAddButton()
}