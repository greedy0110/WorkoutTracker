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


    lateinit var vm: AddWorkoutViewModel
    lateinit var input: AddWorkoutViewModelInput
    lateinit var output: AddWorkoutViewModelOutput
    lateinit var repository: WorkoutRepository

    @Before
    fun initWorkouts() {
        vm = AddWorkoutViewModel(Logger(), repository)
        input = vm.input
        output = vm.output
    }

    @Test
    fun addWorkout1(){
    }
}