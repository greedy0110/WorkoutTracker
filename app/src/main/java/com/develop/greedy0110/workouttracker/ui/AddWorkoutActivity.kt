package com.develop.greedy0110.workouttracker.ui

import android.app.Activity
import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import com.develop.greedy0110.workouttracker.Logger
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.data.repository.WorkoutMemoryDataSource
import com.develop.greedy0110.workouttracker.databinding.ActivityAddWorkoutBinding
import com.develop.greedy0110.workouttracker.viewModel.AddWorkoutViewModel

class AddWorkoutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityAddWorkoutBinding>(this, R.layout.activity_add_workout)
        binding.setLifecycleOwner(this)

        val dataSource = WorkoutMemoryDataSource()
        val viewModel = AddWorkoutViewModel(Logger(), dataSource)
        binding.viewModel = viewModel

        viewModel.output.goWoroutListActivity()
            .observe(this, Observer {
                if (it == null) return@Observer
                dataSource.getWorkouts().subscribe{
                    wo ->
                    Log.d("workout", wo.toString())
                }
            })
    }
}
