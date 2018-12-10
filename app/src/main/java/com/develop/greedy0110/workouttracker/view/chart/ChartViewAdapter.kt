package com.develop.greedy0110.workouttracker.view.chart

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.adapter.BaseViewAdapter
import com.develop.greedy0110.workouttracker.adapter.workout.ChartAdapter
import com.develop.greedy0110.workouttracker.databinding.ChartUiBinding
import com.develop.greedy0110.workouttracker.viewModel.chart.ChartDataAdapter
import com.develop.greedy0110.workouttracker.viewModel.workout.WorkoutViewModel
import com.jakewharton.rxbinding3.view.clicks

class ChartViewAdapter(
    val dataAdapter: ChartDataAdapter
): BaseViewAdapter<ChartAdapter.ViewHolder> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<ChartUiBinding>(
            LayoutInflater.from(parent.context),
            R.layout.chart_ui, parent, false
        )
        return ChartAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChartAdapter.ViewHolder, pos: Int) {
        val workout = dataAdapter.get()[pos]
        holder.binding.workout = workout

        holder.binding.deleteButton.setOnClickListener {
            Log.d("뭐야", "눌리긴해?")
            dataAdapter.removeAt(pos) // TODO MVVM 관점에서 틀렸는거 같은데...
        }
    }
}