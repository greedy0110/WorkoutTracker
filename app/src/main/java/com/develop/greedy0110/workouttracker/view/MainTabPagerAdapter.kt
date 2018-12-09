package com.develop.greedy0110.workouttracker.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.develop.greedy0110.workouttracker.view.chart.ChartFragment
import com.develop.greedy0110.workouttracker.view.workout.WorkoutFragment

class MainTabPagerAdapter(
    fm: FragmentManager
): FragmentStatePagerAdapter(fm) {
    private val TAB_COUNT = 2

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> WorkoutFragment()
            1 -> ChartFragment()
            else -> ChartFragment()
        }
    }

    override fun getCount() = TAB_COUNT
}