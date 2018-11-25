package com.develop.greedy0110.workouttracker

import android.util.Log

class Logger {
    fun d(t: Throwable) {
        t.printStackTrace()
        Log.e("e",t.toString())
    }
}