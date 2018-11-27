package com.develop.greedy0110.workouttracker.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.develop.greedy0110.workouttracker.Logger
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.data.repository.*
import com.develop.greedy0110.workouttracker.databinding.ActivityAddWorkoutBinding
import com.develop.greedy0110.workouttracker.viewModel.AddWorkoutViewModel
import com.develop.greedy0110.workouttracker.viewModel.Converter

class AddWorkoutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityAddWorkoutBinding>(this, R.layout.activity_add_workout)
        binding.setLifecycleOwner(this)

        val dataSource = WorkoutRoomDataSource(applicationContext)
        val viewModel = ViewModelProviders.of(
            this, AddWorkoutViewModelFactory(Logger(), dataSource)
        ).get(AddWorkoutViewModel::class.java)

        binding.viewModel = viewModel
        binding.converter = Converter()
    }
}

class AddWorkoutViewModelFactory(private val logger: Logger, private val repo: WorkoutRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddWorkoutViewModel(logger, repo) as T
    }
}