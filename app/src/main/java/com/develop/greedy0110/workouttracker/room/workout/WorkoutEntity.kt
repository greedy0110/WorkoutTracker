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
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "target") var target: String,
    @ColumnInfo(name = "sets") var sets: String, // using WorkSetsConverter
    @ColumnInfo(name = "memo") var memo: String?
)

object WorkSetsConverter {
    @TypeConverter
    fun toString(w: List<WorkSet>): String {
        return Gson().toJson(w)
    }

    @TypeConverter
    fun fromString(s: String): List<WorkSet> {
        val obj = Gson().fromJson<Array<WorkSet>>(s, Array<WorkSet>::class.java)
        return obj.toList()
    }
}