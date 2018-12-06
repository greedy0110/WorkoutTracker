package com.develop.greedy0110.workouttracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Log
import com.develop.greedy0110.workouttracker.model.workout.TypeOfExercise
import com.develop.greedy0110.workouttracker.model.workout.WorkSet
import com.develop.greedy0110.workouttracker.model.workout.Workout
import com.develop.greedy0110.workouttracker.model.workout.WorkoutRepository
import com.develop.greedy0110.workouttracker.utils.SingleLiveEvent
import com.develop.greedy0110.workouttracker.utils.addAndSync
import io.reactivex.subjects.PublishSubject

class WorkoutViewModel(private val repository: WorkoutRepository): BaseViewModel() {
    private val _name = MutableLiveData<String>()
    private val _target = MutableLiveData<String>()
    private val _memo = MutableLiveData<String>()
    private val _clickAddWorkout = SingleLiveEvent<String>()
    private val _clickAddSet = SingleLiveEvent<String>()

    // mutableLiveData 를 immutable 하게 노출
    val name: LiveData<String> get() = _name
    val target: LiveData<String> get() = _target
    val memo: LiveData<String> get() = _memo
    val clickAddWorkout: LiveData<String> get() = _clickAddWorkout
    val clickAddSet: LiveData<String> get() = _clickAddSet
    val worksetDataAdapter = WorkSetDataAdapter()

    fun clickAddWorkout() {
        _clickAddWorkout.call()
        repository.addWorkout(makeWorkout()).subscribe {
            Log.d("ViewModel", "add workout")
        }.apply { addDisposable(this) }
    }

    fun clickAddSet() {
        _clickAddSet.call()
        worksetDataAdapter.add()
    }

    fun parseName(s: String) {
        _name.value = s
    }

    fun parseTarget(s: String) {
        _target.value = s
    }

    fun parseMemo(s: String) {
        _memo.value = s
    }

    private fun makeWorkout() = Workout(
        TypeOfExercise(_name.value?:"none", _target.value?:"none"),
        worksetDataAdapter.get().toList(),
        _memo.value?:""
    )

    init {
        repository.getWorkouts().subscribe {
            it -> Log.d("ViewModel Workouts", "$it")
        }.apply { addDisposable(this) }
    }
}