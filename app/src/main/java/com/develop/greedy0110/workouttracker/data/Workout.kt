package com.develop.greedy0110.workouttracker.data

import java.util.Date

data class Workout(
    val type: TypeOfExercise,
    val sets: List<WorkSet>,
    val memo: String? = ""
)