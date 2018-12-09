package com.develop.greedy0110.workouttracker.viewModel.chart

import com.develop.greedy0110.workouttracker.model.workout.WorkoutRepository
import com.develop.greedy0110.workouttracker.viewModel.BaseViewModel

class ChartViewModel(private val repository: WorkoutRepository): BaseViewModel() {
    val chartDataAdapter = ChartDataAdapter()

    init {
        // workout 이 갱신될 때 마다 ui 에 그림을 그려줘야함.
        repository.getWorkouts().subscribe() {
            chartDataAdapter.items.onNext(it.toMutableList())
        }.apply { addDisposable(this) }
    }
}