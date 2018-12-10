package com.develop.greedy0110.workouttracker.room.workout

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM workoutentity")
    fun getAll(): Flowable<List<WorkoutEntity>>

    @Insert
    fun insertAll(vararg workouts: WorkoutEntity)

    @Delete
    fun delete(workout: WorkoutEntity)

}