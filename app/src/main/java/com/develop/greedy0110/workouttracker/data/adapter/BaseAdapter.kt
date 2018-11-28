package com.develop.greedy0110.workouttracker.data.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.develop.greedy0110.workouttracker.viewModel.BaseViewModel

abstract class BaseAdapter<T: ViewDataBinding, R>: RecyclerView.Adapter<BaseViewHolder>(), BindableAdapter<R> {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val binding = DataBindingUtil.inflate<T>(inflater, getLayoutId(), p0, false)
        binding.setVariable(getViewModelId(), getBindingViewModel())
        return BaseViewHolder(binding)
    }

    abstract override fun getItemCount(): Int

    override fun onBindViewHolder(p0: BaseViewHolder, p1: Int) {
        val obj = getObjForPosition(p1)
        p0.bind(obj)
    }

    protected abstract fun getObjForPosition(pos: Int): Any

    protected abstract fun getLayoutId(): Int

    protected abstract fun getViewModelId(): Int
    protected abstract fun getBindingViewModel(): BaseViewModel
}

class BaseViewHolder(val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(obj: Any) {
        binding.executePendingBindings()
    }
}

interface BindableAdapter<T> {
    var data: T
}