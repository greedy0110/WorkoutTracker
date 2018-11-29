package com.develop.greedy0110.workouttracker.data.adapter

import android.arch.lifecycle.MutableLiveData
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.develop.greedy0110.workouttracker.data.WorkSet

@BindingAdapter("data")
fun setRecyclerViewProperties(recyclerView: RecyclerView, data: MutableLiveData<MutableList<WorkSet>>) {
    if (recyclerView.adapter is WorksetAdapter) {
        (recyclerView.adapter as WorksetAdapter).data = data
    }
}