package com.develop.greedy0110.workouttracker.model.workout

import com.develop.greedy0110.workouttracker.room.workout.WorkoutDatabase
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RoomWorkoutRepositoryImpl(private val database: WorkoutDatabase):
    WorkoutRepository {
    override fun getWorkouts(): Single<List<Workout>> {
        return database.workoutDao().getAll().subscribeOn(Schedulers.io()).flatMap {
            Single.just(it.map { e -> database.translater.from(e) })
        }
    }

    override fun addWorkout(workout: Workout) {
        database.workoutDao().insertAll(database.translater.to(workout))
    }
}