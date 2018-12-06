package com.develop.greedy0110.workouttracker.viewModel

import com.develop.greedy0110.workouttracker.adapter.BaseDataAdapter
import com.develop.greedy0110.workouttracker.model.workout.WorkSet
import io.reactivex.subjects.PublishSubject

class WorkSetDataAdapter: BaseDataAdapter<WorkSet> {
    private var _items = mutableListOf<WorkSet>()

    override val items: PublishSubject<MutableList<WorkSet>> = PublishSubject.create()
    override fun getItemCount() = _items.size
    override fun getItemViewType(position: Int): Int = position

    fun removeAt(pos: Int) {
        _items.removeAt(pos)
        items.onNext(_items)
    }

    fun changeAt(pos: Int, set: WorkSet) {
        _items[pos] = set
    }

    fun add() {
        val set = if (_items.size >= 1) _items[_items.size-1] else WorkSet(0,0,0)
        _items.add(set)
        items.onNext(_items)
    }

    fun at(pos: Int): WorkSet = _items[pos]

    fun get() = _items

    init {
        items.subscribe {
            _items = it
        }
    }


}