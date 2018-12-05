package com.develop.greedy0110.workouttracker.room.workout

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM workoutentity")
    fun getAll(): Single<List<WorkoutEntity>>

    @Insert
    fun insertAll(vararg workouts: WorkoutEntity)
}