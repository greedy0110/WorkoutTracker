package com.develop.greedy0110.workouttracker.translator.workout

import com.develop.greedy0110.workouttracker.model.workout.TypeOfExercise
import com.develop.greedy0110.workouttracker.model.workout.WorkSet
import com.develop.greedy0110.workouttracker.model.workout.Workout
import com.develop.greedy0110.workouttracker.room.workout.WorkoutEntity
import com.develop.greedy0110.workouttracker.translator.BaseTranslator
import com.google.gson.Gson

class WorkoutTranslator: BaseTranslator<Workout, WorkoutEntity> {
    override fun from(data: WorkoutEntity) =  Workout(
            TypeOfExercise(data.name, data.target),
            fromString(data.sets),
            data.memo
        )

    override fun to(data: Workout) = WorkoutEntity(
        0, data.type.name, data.type.target,
        toString(data.sets),
        data.memo
    )

    private fun toString(w: List<WorkSet>): String {
        return Gson().toJson(w)
    }

    private fun fromString(s: String): List<WorkSet> {
        val obj = Gson().fromJson<Array<WorkSet>>(s, Array<WorkSet>::class.java)
        return obj.toList()
    }
}