package com.develop.greedy0110.workouttracker.model

import com.develop.greedy0110.workouttracker.model.workout.RoomWorkoutRepositoryImpl
import com.develop.greedy0110.workouttracker.model.workout.WorkoutRepository
import org.koin.dsl.module.module

val modelModule = module {
    factory { RoomWorkoutRepositoryImpl(get(parameters = {it})) as WorkoutRepository }
}