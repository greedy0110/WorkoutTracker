package com.develop.greedy0110.workouttracker.room.workout

import androidx.room.Database
import androidx.room.RoomDatabase
import com.develop.greedy0110.workouttracker.translator.workout.WorkoutTranslator

@Database(entities = [WorkoutEntity::class], version = 1)
abstract class WorkoutDatabase : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
    val translater = WorkoutTranslator()
}