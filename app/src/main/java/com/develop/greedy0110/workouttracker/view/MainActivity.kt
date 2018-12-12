package com.develop.greedy0110.workouttracker.view

import android.os.Bundle
import androidx.lifecycle.Observer
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.databinding.ActivityMainBinding
import com.develop.greedy0110.workouttracker.view.BaseActivity
import com.develop.greedy0110.workouttracker.view.MainTabPagerAdapter
import com.develop.greedy0110.workouttracker.view.workout.WorkoutFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val TAG = "MainActivity"

    override val layoutResourceId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        add_workout_button.setOnClickListener {
            val wof = WorkoutFragment()
            supportFragmentManager.beginTransaction().add(R.id.main_activty, wof).commit()
            add_workout_button.hide()
            wof.finished.observe(this, Observer {
                add_workout_button.show()
            })
        }
    }
}