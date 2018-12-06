package com.develop.greedy0110.workouttracker.translator

interface BaseTranslator<T,R> {
    fun from(data: R): T
    fun to(data: T): R
}