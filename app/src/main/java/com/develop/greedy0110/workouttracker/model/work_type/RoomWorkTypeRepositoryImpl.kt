package com.develop.greedy0110.workouttracker.model.work_type

import com.develop.greedy0110.workouttracker.room.work_type.WorkTypeDatabase
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

class RoomWorkTypeRepositoryImpl(private val database: WorkTypeDatabase):
    WorkTypeRepository {
    override fun getWorkTypes(): Flowable<List<WorkType>> =
        database.workTypeDao().getAll().subscribeOn(Schedulers.io()).flatMap {
            Flowable.just(it.map { e -> database.translator.from(e) })
        }


    override fun addWorkType(worktype: WorkType) =
        Completable.fromAction {
            database.workTypeDao().insertAll(database.translator.to(worktype))
        }.subscribeOn(Schedulers.io())

    override fun deleteWorkType(worktype: WorkType) =
        Completable.fromAction{
            database.workTypeDao().delete(database.translator.to(worktype))
        }.subscribeOn(Schedulers.io())
}