package com.develop.greedy0110.workouttracker.translator.work_type

import com.develop.greedy0110.workouttracker.model.work_type.WorkType
import com.develop.greedy0110.workouttracker.room.work_type.WorkTypeEntity
import com.develop.greedy0110.workouttracker.translator.BaseTranslator

class WorkTypeTranslator: BaseTranslator<WorkType, WorkTypeEntity> {
    override fun from(data: WorkTypeEntity) = WorkType(data.uid, data.name, data.target)
    override fun to(data: WorkType) = WorkTypeEntity(data.id, data.name, data.target)
}