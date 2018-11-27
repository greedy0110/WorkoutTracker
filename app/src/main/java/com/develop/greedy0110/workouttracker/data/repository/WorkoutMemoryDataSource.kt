package com.develop.greedy0110.workouttracker.data.repository

import com.develop.greedy0110.workouttracker.data.Workout
import io.reactivex.Observable
import io.reactivex.Single

class WorkoutMemoryDataSource: WorkoutRepository {
    private val workouts = mutableListOf<Workout>()
    override fun getWorkouts(): List<Workout> = workouts
    override fun addWorkout(workout: Workout) { workouts.add(workout) }
}