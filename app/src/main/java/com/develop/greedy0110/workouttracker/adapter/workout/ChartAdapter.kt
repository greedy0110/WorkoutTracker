package com.develop.greedy0110.workouttracker.adapter.workout

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.develop.greedy0110.workouttracker.adapter.BaseAdapter
import com.develop.greedy0110.workouttracker.databinding.ChartUiBinding
import com.develop.greedy0110.workouttracker.view.chart.ChartViewAdapter
import com.develop.greedy0110.workouttracker.viewModel.chart.ChartDataAdapter
import io.reactivex.android.schedulers.AndroidSchedulers

class ChartAdapter(
    override val data: ChartDataAdapter,
    override val view: ChartViewAdapter
): BaseAdapter<ChartDataAdapter, ChartViewAdapter, ChartAdapter.ViewHolder>() {
    class ViewHolder(val binding: ChartUiBinding): RecyclerView.ViewHolder(binding.root)

    init {
        data.items
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
            notifyDataSetChanged()
        }
    }
}