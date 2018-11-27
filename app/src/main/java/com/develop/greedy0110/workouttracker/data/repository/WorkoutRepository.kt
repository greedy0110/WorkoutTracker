package com.develop.greedy0110.workouttracker.data.repository

import com.develop.greedy0110.workouttracker.data.Workout
import io.reactivex.Flowable

interface WorkoutRepository {
    fun getWorkouts(): Flowable<List<Workout>>
    fun addWorkout(workout: Workout)
}