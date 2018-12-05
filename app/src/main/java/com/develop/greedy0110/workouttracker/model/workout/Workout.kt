package com.develop.greedy0110.workouttracker.model.workout

data class Workout(
    val type: TypeOfExercise,
    val sets: List<WorkSet>,
    val memo: String? = ""
)

data class TypeOfExercise(
    val name: String,
    val target: String
)

data class WorkSet (
    val weight: Int,
    val rep: Int,
    val restTime: Int = DEFAULT_RESTTIME
) {
    companion object {
        const val DEFAULT_RESTTIME = 60
    }
}

