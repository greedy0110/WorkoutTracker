package com.develop.greedy0110.workouttracker.model.workout

import io.reactivex.Completable
import io.reactivex.Flowable

interface WorkoutRepository {
    fun getWorkouts(): Flowable<List<Workout>>
    fun addWorkout(workout: Workout): Completable
    fun deleteWorkout(workout: Workout): Completable
}