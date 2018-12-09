package com.develop.greedy0110.workouttracker.room

import androidx.room.Room
import android.content.Context
import com.develop.greedy0110.workouttracker.room.workout.WorkoutDatabase
import org.koin.dsl.module.module

val roomModule = module {
    single { (context: Context) -> Room.databaseBuilder(context, WorkoutDatabase::class.java, "workout").fallbackToDestructiveMigration().build() }
}