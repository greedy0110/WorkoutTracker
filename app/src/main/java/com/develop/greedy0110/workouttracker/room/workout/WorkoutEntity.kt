package com.develop.greedy0110.workouttracker.room.workout

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.develop.greedy0110.workouttracker.model.workout.WorkSet
import com.google.gson.Gson

@Entity
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "target") var target: String,
    @ColumnInfo(name = "sets") var sets: String, // using WorkSetsConverter
    @ColumnInfo(name = "memo") var memo: String?
)