package com.develop.greedy0110.workouttracker.data

data class WorkSet (
    val weight: Int,
    val rep: Int,
    val restTime: Int = DEFAULT_RESTTIME
) {
    companion object {
        const val DEFAULT_RESTTIME = 60
    }
}