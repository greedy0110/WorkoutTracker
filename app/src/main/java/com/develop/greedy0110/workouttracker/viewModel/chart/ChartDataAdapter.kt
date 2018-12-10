package com.develop.greedy0110.workouttracker.viewModel.chart

import com.develop.greedy0110.workouttracker.adapter.BaseDataAdapter
import com.develop.greedy0110.workouttracker.model.workout.Workout
import io.reactivex.subjects.PublishSubject

class ChartDataAdapter : BaseDataAdapter<Workout>() {
    val removeWorkout: PublishSubject<Workout> = PublishSubject.create()

    fun removeAt(pos: Int) {
        // db 에서도 제거해야한다. -> room dao 가 바뀌어야한다.
        removeWorkout.onNext(_items[pos])
    }
}