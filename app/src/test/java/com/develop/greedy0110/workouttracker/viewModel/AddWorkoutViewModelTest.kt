package com.develop.greedy0110.workouttracker.viewModel

import com.develop.greedy0110.workouttracker.Logger
import com.develop.greedy0110.workouttracker.data.TypeOfExercise
import com.develop.greedy0110.workouttracker.data.WorkSet
import com.develop.greedy0110.workouttracker.data.Workout
import com.develop.greedy0110.workouttracker.data.repository.WorkoutRepository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AddWorkoutViewModelTest {
    class test1DataSource: WorkoutRepository {
        val wos = mutableListOf<Workout>()

        override fun getWorkouts(): List<Workout> = wos

        override fun addWorkout(workout: Workout) { wos.add(workout)}
    }

    lateinit var vm: AddWorkoutViewModel
    lateinit var input: AddWorkoutViewModelInput
    lateinit var output: AddWorkoutViewModelOutput
    lateinit var repository: WorkoutRepository

    @Before
    fun initWorkouts() {
        repository = test1DataSource()
        vm = AddWorkoutViewModel(Logger(), repository)
        input = vm.input
        output = vm.output
    }

    @Test
    fun addWorkout1(){
        val wos = mutableListOf(Workout(
            TypeOfExercise("row", "back"),
            listOf(WorkSet(50,12,60)),
            "i can do it"
        ))

        input.name("row")
        input.target ("back")
        input.weight(50)
        input.rep(12)
        input.restTime(60)
        input.memo("i can do it")

        output.clickAddButton()

        assertEquals(wos[0], repository.getWorkouts()[0])
    }
}