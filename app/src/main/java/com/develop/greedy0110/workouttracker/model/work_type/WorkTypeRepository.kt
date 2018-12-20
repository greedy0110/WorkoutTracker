package com.develop.greedy0110.workouttracker.model.work_type

import io.reactivex.Completable
import io.reactivex.Flowable

interface WorkTypeRepository {
    fun getWorkTypes(): Flowable<List<WorkType>>
    fun addWorkType(worktype: WorkType): Completable
    fun deleteWorkType(worktype: WorkType): Completable
}