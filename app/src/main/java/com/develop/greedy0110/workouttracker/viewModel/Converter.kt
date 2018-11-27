package com.develop.greedy0110.workouttracker.viewModel

import android.databinding.InverseMethod
import java.lang.NumberFormatException

class Converter {
    @InverseMethod("intToString")
    fun stringToInt(value: String): Int {
        try {
            return Integer.parseInt(value)
        }
        catch (e: NumberFormatException) {
            return 0
        }
    }

    fun intToString(value: Int): String {
        return ""+value
    }

}