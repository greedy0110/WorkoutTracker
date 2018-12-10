package com.develop.greedy0110.workouttracker.view.chart


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.adapter.workout.ChartAdapter
import com.develop.greedy0110.workouttracker.databinding.FragmentChartBinding
import com.develop.greedy0110.workouttracker.view.BaseFragment
import com.develop.greedy0110.workouttracker.viewModel.chart.ChartViewModel
import kotlinx.android.synthetic.main.fragment_chart.*
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
class ChartFragment : BaseFragment<FragmentChartBinding>() {
    private val TAG = "ChartFragment"

    override val layoutResourceId = R.layout.fragment_chart

    private val viewModel by viewModel<ChartViewModel> { parametersOf(this.context) }

    private val adapter: ChartAdapter by lazy {
        ChartAdapter(
            viewModel.chartDataAdapter,
            ChartViewAdapter(viewModel.chartDataAdapter)
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.viewModel = viewModel
        chart_listview.adapter = adapter

        adapter.data.removeWorkout.subscribe {
            viewModel.deleteWorkout(it)
        }.apply { addDisposable(this) }
    }
}
