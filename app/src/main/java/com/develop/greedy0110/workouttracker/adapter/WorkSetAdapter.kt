package com.develop.greedy0110.workouttracker.adapter

import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.develop.greedy0110.workouttracker.databinding.WorksetDataUiBinding
import com.develop.greedy0110.workouttracker.model.workout.WorkSet
import com.develop.greedy0110.workouttracker.view.WorkSetViewAdapter
import com.develop.greedy0110.workouttracker.viewModel.WorkSetDataAdapter
import io.reactivex.subjects.PublishSubject

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