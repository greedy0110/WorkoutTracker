package com.develop.greedy0110.workouttracker.data.adapter

import androidx.lifecycle.MutableLiveData
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import com.develop.greedy0110.workouttracker.data.WorkSet

@BindingAdapter("data")
fun setRecyclerViewProperties(recyclerView: androidx.recyclerview.widget.RecyclerView, data: MutableLiveData<MutableList<WorkSet>>) {
    if (recyclerView.adapter is WorksetAdapter) {
        (recyclerView.adapter as WorksetAdapter).data = data
    }
}