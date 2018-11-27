package com.develop.greedy0110.workouttracker.ui

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import com.develop.greedy0110.workouttracker.Logger
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.data.repository.WorkoutMemoryDataSource
import com.develop.greedy0110.workouttracker.databinding.ActivityAddWorkoutBinding
import com.develop.greedy0110.workouttracker.viewModel.AddWorkoutViewModel
import com.develop.greedy0110.workouttracker.viewModel.Converter

class AddWorkoutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityAddWorkoutBinding>(this, R.layout.activity_add_workout)
        binding.setLifecycleOwner(this)

        val dataSource = WorkoutMemoryDataSource()
        val viewModel = ViewModelProviders.of(this).get(AddWorkoutViewModel::class.java)

        binding.viewModel = viewModel
        binding.converter = Converter()
    }
}
