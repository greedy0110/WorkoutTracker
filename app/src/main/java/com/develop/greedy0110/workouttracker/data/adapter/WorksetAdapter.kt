package com.develop.greedy0110.workouttracker.data.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.develop.greedy0110.workouttracker.BR
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.data.WorkSet
import com.develop.greedy0110.workouttracker.databinding.WorksetDataUiBinding
import com.develop.greedy0110.workouttracker.viewModel.BaseViewModel
import com.develop.greedy0110.workouttracker.viewModel.WorkSetViewModel

//class WorksetAdapter(private val data: MutableList<WorkSet>):
//        RecyclerView.Adapter<WorksetAdapter.ViewHolder>() {
//    private val default_restTime = 60
//
//    // 각 데이터마다 보여줄 view 를 제공하는 클래스
//    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.workset_data_ui, parent, false) as View
//
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount() = data.size
//
//    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
//        val weight = holder.view.findViewById<EditText>(R.id.workset_weight)
//        val rep = holder.view.findViewById<EditText>(R.id.workset_rep)
//        val rt = holder.view.findViewById<EditText>(R.id.workset_resttime)
//        val delete = holder.view.findViewById<Button>(R.id.workset_delete)
//
//        rt.setText(default_restTime.toString())
//        if (pos == 0) { // it has at last 1 set
//            delete.isEnabled = false
//        }
//        delete.setOnClickListener { removeAt(pos) }
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
//
//    }
//
//    private fun removeAt(pos: Int) {
//        data.removeAt(pos)
//        notifyItemRemoved(pos)
//        notifyItemRangeChanged(pos, data.size)
//    }
//}

class WorksetAdapter()
    :BaseAdapter<WorksetDataUiBinding, MutableList<WorkSet>>() {
    override fun getItemCount(): Int = data.size

    override fun getObjForPosition(pos: Int): Any {
        return data[pos]
    }

    override var data: MutableList<WorkSet> = mutableListOf()
        set(value) {
            field =value
            notifyDataSetChanged()
        }

    override fun getLayoutId(): Int {
        return R.layout.workset_data_ui
    }

    override fun getViewModelId(): Int {
        return BR.worksetViewModel
    }

    override fun getBindingViewModel(): BaseViewModel {
        return WorkSetViewModel() // TODO ViewModel 팩토리를 이용해 만드는 거로 변경해야함..
    }
}