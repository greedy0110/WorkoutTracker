package com.develop.greedy0110.workouttracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.databinding.Bindable
import android.icu.util.Output
import android.util.Log
import com.develop.greedy0110.workouttracker.Logger
import com.develop.greedy0110.workouttracker.data.TypeOfExercise
import com.develop.greedy0110.workouttracker.data.WorkSet
import com.develop.greedy0110.workouttracker.data.Workout
import com.develop.greedy0110.workouttracker.data.adapter.WorksetAdapter
import com.develop.greedy0110.workouttracker.data.repository.WorkoutRepository

class AddWorkoutViewModel(
    val logger: Logger,
    val repository: WorkoutRepository
): BaseViewModel() {
    private var name = ""
    private var target = ""
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

        override fun memo(s: String) {
            memo = s
        }
    }

    private val addButtonState: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val worksets: MutableLiveData<MutableList<WorkSet>> by lazy { MutableLiveData<MutableList<WorkSet>>() }
    val adapter: WorksetAdapter by lazy { WorksetAdapter() }

    val output = object : AddWorkoutViewModelOutput {
        override fun addButtonState() = addButtonState
        override fun clickAddButton() {
            worksets.value?.let {
                val wo = Workout(
                    TypeOfExercise(name, target),
                    it,
                    memo
                )
                repository.addWorkout(wo)
            }
        }

        override fun clickAddSetButton() {
            worksets.value?.add(WorkSet(0,0,60))
            worksets.value = worksets.value // for react ui
            adapter.notifyDataSetChanged()
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
        addButtonState.value = enable
    }

    init {
        worksets.value = mutableListOf(WorkSet(0,0,60))

        addDisposable(repository.getWorkouts()
            .doOnError { t -> Log.e("viewModel : ", "$t") }
            .subscribe {
                Log.d("viewModel : ", "done")
                for (i in 0 until it.size-1)
                    Log.d("$i 운동 : ", "${it[i]}")
            })
    }
}

interface AddWorkoutViewModelInput {
    fun name(s: String)
    fun target(s: String)
    fun memo(s: String)
}

interface AddWorkoutViewModelOutput {
    fun addButtonState(): LiveData<Boolean>
    fun clickAddButton()
    fun clickAddSetButton()
}