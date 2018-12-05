package com.develop.greedy0110.workouttracker.translater

interface BaseTranslater<T,R> {
    fun from(data: R): T
    fun to(data: T): R
}