package com.develop.greedy0110.workouttracker.adapter.workout

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.develop.greedy0110.workouttracker.adapter.BaseAdapter
import com.develop.greedy0110.workouttracker.databinding.WorksetDataUiBinding
import com.develop.greedy0110.workouttracker.view.workout.WorkSetViewAdapter
import com.develop.greedy0110.workouttracker.viewModel.workout.WorkSetDataAdapter

class WorkSetAdapter(
    override val data: WorkSetDataAdapter,
    override val view: WorkSetViewAdapter
): BaseAdapter<WorkSetDataAdapter, WorkSetViewAdapter, WorkSetAdapter.ViewHolder>() {
    class ViewHolder(val binding: WorksetDataUiBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = view.onCreateViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = view.onBindViewHolder(holder, position)
    override fun getItemCount() = data.getItemCount()

    init {
        data.items.subscribe {
            notifyDataSetChanged() // for redraw recyclerview
        }
    }
}