package com.develop.greedy0110.workouttracker.view.workout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.adapter.BaseViewAdapter
import com.develop.greedy0110.workouttracker.adapter.workout.WorkSetAdapter
import com.develop.greedy0110.workouttracker.databinding.WorksetDataUiBinding
import com.develop.greedy0110.workouttracker.viewModel.workout.WorkSetDataAdapter
import com.develop.greedy0110.workouttracker.viewModel.workout.WorkSetViewModel

class WorkSetViewAdapter(
    val dataAdapter: WorkSetDataAdapter
): BaseViewAdapter<WorkSetAdapter.ViewHolder> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkSetAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<WorksetDataUiBinding>(
            LayoutInflater.from(parent.context)
            , R.layout.workset_data_ui, parent, false
        )
        return WorkSetAdapter.ViewHolder(binding)
    }

    // view 에서 그려주다가 notifyDataChanged 와 같은 다시 그려주는 method 호출은 금지되어 있다.
    override fun onBindViewHolder(holder: WorkSetAdapter.ViewHolder, pos: Int) {
        // binding 에 연결할 viewModel 을 지정 / 마치 activity 의 onCreate 같은 느낌으로 진행
        val viewModel = WorkSetViewModel(dataAdapter.at(pos))
        holder.binding.viewModel = viewModel

        viewModel.clickDelete.observeForever {
            dataAdapter.removeAt(pos)
        }

        viewModel.weight.observeForever {
            dataAdapter.changeAt(pos, viewModel.toWorkSet())
        }

        viewModel.rep.observeForever {
            dataAdapter.changeAt(pos, viewModel.toWorkSet())
        }

        viewModel.restTime.observeForever {
            dataAdapter.changeAt(pos, viewModel.toWorkSet())
        }
    }
}