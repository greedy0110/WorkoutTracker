package com.develop.greedy0110.workouttracker.viewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log.d
import com.develop.greedy0110.workouttracker.Logger
import com.develop.greedy0110.workouttracker.data.TypeOfExercise
import com.develop.greedy0110.workouttracker.data.WorkSet
import com.develop.greedy0110.workouttracker.data.Workout
import com.develop.greedy0110.workouttracker.data.repository.WorkoutRepository
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.*

class AddWorkoutViewModel(
    logger: Logger,
    repository: WorkoutRepository
): BaseViewModel() {


    private var name: String = ""
    private var target: String = ""
    private var weight: Int = 0
    private var rep: Int = 0
    private var restTime: Int = 0
    private var memo: String = ""
    val input = object : AddWorkoutViewModelInput {
        override fun name(p: String) {name = p}
        override fun target(p: String) {target = p}
        override fun weight(p: String) {weight = p.toInt()}
        override fun rep(p: String) {rep = p.toInt()}
        override fun restTime(p: String) {restTime = p.toInt()}
        override fun memo(p: String) {memo = p}
        override fun clickAddButton() {
            val workout = Workout(
                TypeOfExercise(name, target),
                listOf(WorkSet(weight, rep, restTime)),
                memo
            )
            repository.addWorkout(workout)
            goWorkoutListActivity.value = true
        }
    }

    private val state = MutableLiveData<AddButtonState>()
    private val goWorkoutListActivity = MutableLiveData<Boolean>()
    val output = object : AddWorkoutViewModelOutput {
        override fun state() = state
        override fun goWoroutListActivity() = goWorkoutListActivity
    }
}

interface AddWorkoutViewModelInput: Input {
    fun name(p: String)
    fun target(p: String)
    fun weight(p: String)
    fun rep(p: String)
    fun restTime(p: String)
    fun memo(p: String)
    fun clickAddButton()
}

interface AddWorkoutViewModelOutput: Output {
    fun state(): LiveData<AddButtonState>
    fun goWoroutListActivity(): LiveData<Boolean>
}

data class AddButtonState (
    val enableAddButton: Boolean
)