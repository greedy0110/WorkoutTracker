package com.develop.greedy0110.workouttracker.model.workout

import com.develop.greedy0110.workouttracker.room.workout.WorkoutDatabase
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

class RoomWorkoutRepositoryImpl(private val database: WorkoutDatabase):
    WorkoutRepository {
    override fun getWorkouts(): Flowable<List<Workout>> =
        database.workoutDao().getAll().subscribeOn(Schedulers.io()).flatMap {
            Flowable.just(it.map { e -> database.translater.from(e) })
        }


    override fun addWorkout(workout: Workout) =
        Completable.fromAction {
            database.workoutDao().insertAll(database.translater.to(workout))
        }.subscribeOn(Schedulers.io())

}