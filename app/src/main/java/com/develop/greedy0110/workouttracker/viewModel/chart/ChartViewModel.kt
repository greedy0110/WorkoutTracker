package com.develop.greedy0110.workouttracker.viewModel.chart

import androidx.lifecycle.LiveData
import com.develop.greedy0110.workouttracker.model.workout.Workout
import com.develop.greedy0110.workouttracker.model.workout.WorkoutRepository
import com.develop.greedy0110.workouttracker.utils.SingleLiveEvent
import com.develop.greedy0110.workouttracker.viewModel.BaseViewModel

class ChartViewModel(private val repository: WorkoutRepository): BaseViewModel() {
    private val _clickDelete = SingleLiveEvent<String>()

    val chartDataAdapter = ChartDataAdapter()
    val clickDelete :LiveData<String> = _clickDelete


    fun clickDelete() {
        _clickDelete.call()
    }

    fun deleteWorkout(workout: Workout) {
        repository.deleteWorkout(workout).subscribe {
            // 알아서 getWorkouts 가 갱신될것이다.
        }.apply { addDisposable(this) }
    }

    init {
        // workout 이 갱신될 때 마다 ui 에 그림을 그려줘야함.
        repository.getWorkouts()
            .subscribe() {
            chartDataAdapter.items.onNext(it.toMutableList())
        }.apply { addDisposable(this) }
    }
}