package com.develop.greedy0110.workouttracker.data.adapter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.develop.greedy0110.workouttracker.BR
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.data.WorkSet
import com.develop.greedy0110.workouttracker.databinding.WorksetDataUiBinding
import com.develop.greedy0110.workouttracker.viewModel.AddWorkoutViewModel
import com.develop.greedy0110.workouttracker.viewModel.BaseViewModel
import com.develop.greedy0110.workouttracker.viewModel.Converter
import com.develop.greedy0110.workouttracker.viewModel.WorkSetViewModel

class WorksetAdapter:
        RecyclerView.Adapter<WorksetAdapter.ViewHolder>() {
    var data: MutableLiveData<MutableList<WorkSet>> = MutableLiveData()
        set(value) {
            field = value
            notifyDataSetChanged() // TODO 이거 쓰면 스크롤이 제일 위로 올라가면서 사용자가 사용하기 매----우 불편함
        }

    private var inflater: LayoutInflater? = null

    // 각 데이터마다 보여줄 view 를 제공하는 클래스
    class ViewHolder(val binding: WorksetDataUiBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("onCreateViewHolder : ", "create")
        if (inflater == null)
            inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<WorksetDataUiBinding>(
            inflater!!, R.layout.workset_data_ui, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        Log.d("onBindViewHolder", "${data.value!!.size} : $pos")
        holder.binding.converter = Converter()
        val viewModel = WorkSetViewModel(pos, data)
        holder.binding.worksetViewModel = viewModel
        holder.binding.worksetDelete.setOnClickListener { removeAt(pos) }
    }

    override fun getItemCount() = data.value!!.size

    override fun getItemViewType(position: Int) = position

    private fun removeAt(pos: Int) {
        data.value!!.removeAt(pos)
        data.value = data.value
        notifyItemRemoved(pos)
        notifyItemRangeChanged(pos, itemCount)
    }
}