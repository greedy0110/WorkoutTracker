package com.develop.greedy0110.workouttracker.translator.workout

import com.develop.greedy0110.workouttracker.model.workout.TypeOfExercise
import com.develop.greedy0110.workouttracker.model.workout.WorkDate
import com.develop.greedy0110.workouttracker.model.workout.WorkSet
import com.develop.greedy0110.workouttracker.model.workout.Workout
import com.develop.greedy0110.workouttracker.room.workout.WorkoutEntity
import com.develop.greedy0110.workouttracker.translator.BaseTranslator
import com.google.gson.Gson

class WorkoutTranslator: BaseTranslator<Workout, WorkoutEntity> {
    override fun from(data: WorkoutEntity) =  Workout(
            data.uid,
            workDatefromString(data.date),
            TypeOfExercise(data.name, data.target),
            workSetsfromString(data.sets),
            data.memo
        )

    override fun to(data: Workout) = WorkoutEntity(
        data.id, workDatetoString(data.date), data.type.name, data.type.target,
        workSetstoString(data.sets),
        data.memo
    )

    private fun workSetstoString(w: List<WorkSet>): String {
        return Gson().toJson(w)
    }

    private fun workSetsfromString(s: String): List<WorkSet> {
        val obj = Gson().fromJson<Array<WorkSet>>(s, Array<WorkSet>::class.java)
        return obj.toList()
    }

    private fun workDatetoString(w: WorkDate): String {
        return Gson().toJson(w)
    }

    private fun workDatefromString(s: String): WorkDate {
        val obj = Gson().fromJson<WorkDate>(s, WorkDate::class.java)
        return obj
    }
}