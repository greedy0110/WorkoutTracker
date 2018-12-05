package com.develop.greedy0110.workouttracker.model.workout

import io.reactivex.Single

interface WorkoutRepository {
    fun getWorkouts(): Single<List<Workout>>
    fun addWorkout(workout: Workout)
}