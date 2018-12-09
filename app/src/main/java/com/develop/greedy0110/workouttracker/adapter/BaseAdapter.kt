package com.develop.greedy0110.workouttracker.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.develop.greedy0110.workouttracker.adapter.workout.WorkSetAdapter
import io.reactivex.subjects.PublishSubject

abstract class BaseAdapter<Data: BaseDataAdapter<*>, View: BaseViewAdapter<H>, H: RecyclerView.ViewHolder>
    : RecyclerView.Adapter<H>()
{
    abstract val data: Data
    abstract val view: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = view.onCreateViewHolder(parent, viewType)
    override fun onBindViewHolder(holder: H, position: Int) = view.onBindViewHolder(holder, position)
    override fun getItemCount() = data.getItemCount()
}

abstract class BaseDataAdapter<T> {
    protected var _items = mutableListOf<T>()

    val items: PublishSubject<MutableList<T>> = PublishSubject.create()
    fun getItemCount() = _items.size
    fun getItemViewType(position: Int) = position
    fun get() = _items

    init {
        items.subscribe {
            _items = it
        }
    }
}

interface BaseViewAdapter<H> {
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): H
    fun onBindViewHolder(holder: H, pos: Int)
}