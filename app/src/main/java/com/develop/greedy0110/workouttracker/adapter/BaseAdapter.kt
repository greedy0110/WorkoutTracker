package com.develop.greedy0110.workouttracker.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.subjects.PublishSubject

abstract class BaseAdapter<Data: BaseDataAdapter<*>, View: BaseViewAdapter<H>, H: RecyclerView.ViewHolder>
    : RecyclerView.Adapter<H>()
{
    abstract val data: Data
    abstract val view: View
}

interface BaseDataAdapter<T> {
    val items: PublishSubject<MutableList<T>>
    fun getItemCount(): Int
    fun getItemViewType(position: Int): Int
}

interface BaseViewAdapter<H> {
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): H
    fun onBindViewHolder(holder: H, pos: Int)
}