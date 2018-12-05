package com.develop.greedy0110.workouttracker.data.adapter

import androidx.lifecycle.MutableLiveData
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.data.WorkSet
import com.develop.greedy0110.workouttracker.databinding.WorksetDataUiBinding
import com.develop.greedy0110.workouttracker.viewModel.Converter
import com.develop.greedy0110.workouttracker.viewModel.WorkSetViewModel

class WorksetAdapter:
        androidx.recyclerview.widget.RecyclerView.Adapter<WorksetAdapter.ViewHolder>() {
    var data: MutableLiveData<MutableList<WorkSet>> = MutableLiveData()

    private var inflater: LayoutInflater? = null

    // 각 데이터마다 보여줄 view 를 제공하는 클래스
    class ViewHolder(val binding: WorksetDataUiBinding): androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)

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
        Log.d("Remove At ", "$pos : ${data.value!![pos]}")
        data.value!!.removeAt(pos)
        notifyDataSetChanged()
    }
}