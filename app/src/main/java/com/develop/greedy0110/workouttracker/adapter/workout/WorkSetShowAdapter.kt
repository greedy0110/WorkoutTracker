package com.develop.greedy0110.workouttracker.adapter.workout

import androidx.recyclerview.widget.RecyclerView
import com.develop.greedy0110.workouttracker.adapter.BaseAdapter
import com.develop.greedy0110.workouttracker.databinding.WorksetShowUiBinding
import com.develop.greedy0110.workouttracker.view.chart.WorkSetShowViewAdapter
import com.develop.greedy0110.workouttracker.viewModel.chart.WorkSetShowDataAdapter

class WorkSetShowAdapter(
    override val data: WorkSetShowDataAdapter,
    override val view: WorkSetShowViewAdapter
): BaseAdapter<WorkSetShowDataAdapter, WorkSetShowViewAdapter, WorkSetShowAdapter.ViewHolder>() {
    class ViewHolder(val binding: WorksetShowUiBinding): RecyclerView.ViewHolder(binding.root)

    init {
        data.items.subscribe {
            notifyDataSetChanged() // for redraw recyclerview
        }
    }
}