package com.develop.greedy0110.workouttracker.viewModel.workout

import com.develop.greedy0110.workouttracker.adapter.BaseDataAdapter
import com.develop.greedy0110.workouttracker.model.workout.WorkSet
import io.reactivex.subjects.PublishSubject

class WorkSetDataAdapter: BaseDataAdapter<WorkSet>() {
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
}