package com.develop.greedy0110.workouttracker.view.workout

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.lifecycle.Observer
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.adapter.workout.WorkSetAdapter
import com.develop.greedy0110.workouttracker.databinding.ActivityAddWorkoutBinding
import com.develop.greedy0110.workouttracker.view.BaseActivity
import com.develop.greedy0110.workouttracker.viewModel.workout.WorkoutViewModel
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.itemSelections
import com.jakewharton.rxbinding3.widget.selectionEvents
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

        workoutName.itemSelections().subscribe {
            viewModel.parseName(workoutName.selectedItem.toString())
        }.apply { addDisposable(this) }

        targetName.itemSelections().subscribe {
            viewModel.parseTarget(targetName.selectedItem.toString())
        }.apply { addDisposable(this) }

        viewModel.date.observe(this, Observer {
            val cur = viewModel.date.value!!
            val d = "${cur[0]}/${cur[1] + 1}/${cur[2]}"
            date.text = d
        })

        date.clicks().subscribe {
            val cur = viewModel.date.value!!
            val dialog = DatePickerDialog(
                this,
                {v,y,m,d -> viewModel.setDate(y, m, d)},
                cur[0],cur[1],cur[2]
            ).show()
        }.apply { addDisposable(this) }
    }
}