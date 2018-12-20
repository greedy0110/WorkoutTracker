package com.develop.greedy0110.workouttracker.room.work_type

import androidx.room.*
import com.develop.greedy0110.workouttracker.translator.work_type.WorkTypeTranslator
import io.reactivex.Flowable

@Entity
data class WorkTypeEntity(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "target") var target: String
)

@Dao
interface WorkTypeDao {
    @Query("SELECT * FROM worktypeentity")
    fun getAll(): Flowable<List<WorkTypeEntity>>

    @Insert
    fun insertAll(vararg types: WorkTypeEntity)

    @Delete
    fun delete(type: WorkTypeEntity)
}

@Database(entities = [WorkTypeEntity::class], version = 1)
abstract class WorkTypeDatabase: RoomDatabase() {
    abstract fun workTypeDao(): WorkTypeDao
    val translator = WorkTypeTranslator()
}