package com.develop.greedy0110.workouttracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Log
import com.develop.greedy0110.workouttracker.model.workout.TypeOfExercise
import com.develop.greedy0110.workouttracker.model.workout.WorkSet
import com.develop.greedy0110.workouttracker.model.workout.Workout
import com.develop.greedy0110.workouttracker.model.workout.WorkoutRepository
import com.develop.greedy0110.workouttracker.utils.SingleLiveEvent

class WorkoutViewModel(private val repository: WorkoutRepository): BaseViewModel() {
    private val _name = MutableLiveData<String>()
    private val _target = MutableLiveData<String>()
    // sets 들은 어떤식으로??
    private val _memo = MutableLiveData<String>()
    private val _clickAddWorkout = SingleLiveEvent<String>()
    private val _clickAddSet = SingleLiveEvent<String>()

    // mutableLiveData 를 immutable 하게 노출
    val name: LiveData<String> get() = _name
    val target: LiveData<String> get() = _target
    val memo: LiveData<String> get() = _memo
    val clickAddWorkout: LiveData<String> get() = _clickAddWorkout
    val clickAddSet: LiveData<String> get() = _clickAddSet

    fun clickAddWorkout() {
        _clickAddWorkout.call()
        addDisposable(repository.getWorkouts()
            .subscribe { ws ->
                for (i in 0..ws.size-1) {
                    Log.d("Workout ", "$i : ${ws[i]}")
                }
            })
    }

    fun clickAddSet() {
        _clickAddSet.call()
    }
}