package com.develop.greedy0110.workouttracker.data.repository

import com.develop.greedy0110.workouttracker.data.Workout
import io.reactivex.Single

interface WorkoutRepository {
    fun getWorkouts(): List<Workout>
    fun addWorkout(workout: Workout)
}