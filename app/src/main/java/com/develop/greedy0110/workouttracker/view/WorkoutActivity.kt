package com.develop.greedy0110.workouttracker.view

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.databinding.ActivityAddWorkoutBinding
import com.develop.greedy0110.workouttracker.viewModel.WorkoutViewModel
import com.jakewharton.rxbinding3.widget.textChanges
import kotlinx.android.synthetic.main.activity_add_workout.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WorkoutActivity : BaseActivity<ActivityAddWorkoutBinding>() {
    override val layoutResourceId: Int = R.layout.activity_add_workout
    private val viewModel by viewModel<WorkoutViewModel> { parametersOf(this.applicationContext)}
    private val TAG = "WorkoutActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.viewModel = viewModel

        workoutName.textChanges().subscribe {
            Log.d(TAG, "${workoutName.text}")
        }.apply { addDisposable(this) }

        targetName.textChanges().subscribe {
            Log.d(TAG, "${targetName.text}")
        }.apply { addDisposable(this) }

        memoText.textChanges().subscribe {
            Log.d(TAG, "${memoText.text}")
        }.apply { addDisposable(this) }

        viewModel.clickAddWorkout.observe(this, Observer {
            Log.d(TAG, "click Add Workout")
        })

        viewModel.clickAddSet.observe(this, Observer {
            Log.d(TAG, "click Add Set")
        })
    }
}