package com.develop.greedy0110.workouttracker.view.chart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.adapter.BaseViewAdapter
import com.develop.greedy0110.workouttracker.adapter.workout.WorkSetShowAdapter
import com.develop.greedy0110.workouttracker.databinding.ChartUiBinding
import com.develop.greedy0110.workouttracker.databinding.WorksetShowUiBinding
import com.develop.greedy0110.workouttracker.viewModel.chart.WorkSetShowDataAdapter

class WorkSetShowViewAdapter(
    val dataAdapter: WorkSetShowDataAdapter
): BaseViewAdapter<WorkSetShowAdapter.ViewHolder> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkSetShowAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<WorksetShowUiBinding>(
            LayoutInflater.from(parent.context),
            R.layout.workset_show_ui, parent, false
        )
        return WorkSetShowAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkSetShowAdapter.ViewHolder, pos: Int) {
        val workset = dataAdapter.get()[pos]
        holder.binding.worksetText.setText(workset.toString())
    }
}