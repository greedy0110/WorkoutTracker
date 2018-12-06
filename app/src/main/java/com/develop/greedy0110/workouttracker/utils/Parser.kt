package com.develop.greedy0110.workouttracker.utils

fun stringToInt(s: String, defaultValue: Int = 0) = s.toIntOrNull()?:defaultValue

fun intToString(i: Int) = i.toString()