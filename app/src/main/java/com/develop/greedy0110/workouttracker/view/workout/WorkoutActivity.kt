package com.develop.greedy0110.workouttracker.view.workout

import android.os.Bundle
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.adapter.workout.WorkSetAdapter
import com.develop.greedy0110.workouttracker.databinding.ActivityAddWorkoutBinding
import com.develop.greedy0110.workouttracker.view.BaseActivity
import com.develop.greedy0110.workouttracker.viewModel.workout.WorkoutViewModel
import kotlinx.android.synthetic.main.activity_add_workout.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WorkoutActivity : BaseActivity<ActivityAddWorkoutBinding>() {
    private val TAG = "WorkoutActivity"

    override val layoutResourceId: Int = R.layout.activity_add_workout

    private val viewModel by viewModel<WorkoutViewModel> { parametersOf(this.applicationContext)}

    private val adapter: WorkSetAdapter by lazy {
        WorkSetAdapter(
            viewModel.worksetDataAdapter,
            WorkSetViewAdapter(viewModel.worksetDataAdapter)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding.viewModel = viewModel
        set_recyclerview.adapter = adapter
    }
}