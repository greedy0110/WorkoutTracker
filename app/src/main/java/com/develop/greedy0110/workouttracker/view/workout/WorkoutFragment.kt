package com.develop.greedy0110.workouttracker.view.workout


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.adapter.workout.WorkSetAdapter
import com.develop.greedy0110.workouttracker.databinding.FragmentWorkoutBinding
import com.develop.greedy0110.workouttracker.utils.SingleLiveEvent
import com.develop.greedy0110.workouttracker.utils.finish
import com.develop.greedy0110.workouttracker.view.BaseFragment
import com.develop.greedy0110.workouttracker.viewModel.workout.WorkoutViewModel
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.itemSelections
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_workout.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class WorkoutFragment : BaseFragment<FragmentWorkoutBinding>() {
    private val TAG = "WorkoutFragment"

    override val layoutResourceId = R.layout.fragment_workout

    private val viewModel by viewModel<WorkoutViewModel> { parametersOf(this.context)}

    private val adapter: WorkSetAdapter by lazy {
        WorkSetAdapter(
            viewModel.worksetDataAdapter,
            WorkSetViewAdapter(viewModel.worksetDataAdapter)
        )
    }

    private val _finished = SingleLiveEvent<String>()
    val finished: LiveData<String> = _finished

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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
                activity,
                {v,y,m,d -> viewModel.setDate(y, m, d)},
                cur[0],cur[1],cur[2]
            ).show()
        }.apply { addDisposable(this) }

        viewModel.clickAddWorkout.observe(this, Observer {
            Snackbar.make(viewDataBinding.root, "운동 추가 완료!", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show()
            _finished.call()
            finish()
        })

        viewModel.clickBack.observe(this, Observer {
            _finished.call()
            finish()
        })
    }
}
