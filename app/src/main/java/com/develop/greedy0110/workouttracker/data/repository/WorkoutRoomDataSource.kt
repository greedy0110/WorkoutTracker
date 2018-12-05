package com.develop.greedy0110.workouttracker.data.repository

import androidx.room.*
import android.content.Context
import com.develop.greedy0110.workouttracker.R.id.all
import com.develop.greedy0110.workouttracker.data.TypeOfExercise
import com.develop.greedy0110.workouttracker.data.WorkSet
import com.develop.greedy0110.workouttracker.data.Workout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.*
import io.reactivex.rxkotlin.flatMapIterable
import io.reactivex.schedulers.Schedulers

class WorkoutRoomDataSource(val context: Context): WorkoutRepository {
    companion object {
        private val dbName = "workout_db"
    }

    private val db: WorkoutDB by lazy { Room.databaseBuilder(context, WorkoutDB::class.java, dbName).build() }

    override fun getWorkouts(): Flowable<List<Workout>> {
        return db.workoutDao().getAll()
            .flatMap { list ->
                Flowable.fromIterable(list)
                    .map { item -> entityToWorkout(item) }
                    .toList()
                    .toFlowable()
            }
    }

    override fun addWorkout(workout: Workout){
        // mainThread 에서 query 를 실행하면 ui thread를 블락하므로 에러가 뜬다.
        // rxjava 를 사용해서 별도의 쓰레드에서 db query 진행해준다.
        Observable.just(db)
            .subscribeOn(Schedulers.io())
            .subscribe {it.workoutDao().insertAll(workoutToEntity(workout))}
    }

    private fun entityToWorkout(e: WorkoutEntity): Workout {
        return Workout(
            TypeOfExercise(e.name, e.target),
            WorkSetsConverter.fromString(e.sets),
            e.memo
            )
    }

    private fun workoutToEntity(w: Workout): WorkoutEntity {
        return WorkoutEntity(
            0, w.type.name, w.type.target,
                WorkSetsConverter.toString(w.sets),
                w.memo
            )
    }
}

@Entity
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "target") var target: String,
    @ColumnInfo(name = "sets") var sets: String, // using WorkSetsConverter
    @ColumnInfo(name = "memo") var memo: String?

)

object WorkSetsConverter {
    @TypeConverter
    fun toString(w: List<WorkSet>): String {
        return Gson().toJson(w)
    }

    @TypeConverter
    fun fromString(s: String): List<WorkSet> {
        val obj = Gson().fromJson<Array<WorkSet>>(s, Array<WorkSet>::class.java)
        return obj.toList()
    }
}

@Dao
interface WorkoutDao {
    @Query ("SELECT * FROM workoutentity")
    fun getAll(): Flowable<List<WorkoutEntity>>

    @Query("SELECT * FROM workoutentity WHERE name LIKE :n")
    fun findByName(n: String): Flowable<List<WorkoutEntity>>

    @Query("SELECT * FROM workoutentity WHERE target LIKE :t")
    fun findByTarget(t: String): Flowable<List<WorkoutEntity>>

    @Insert
    fun insertAll(vararg workouts: WorkoutEntity)

    @Delete
    fun delete(workout: WorkoutEntity)
}

@Database(entities = [(WorkoutEntity::class)], version = 1)
abstract class WorkoutDB : RoomDatabase() {
    abstract fun workoutDao(): WorkoutDao
}