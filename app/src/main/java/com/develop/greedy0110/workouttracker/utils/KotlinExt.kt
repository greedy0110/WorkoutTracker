package com.develop.greedy0110.workouttracker.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar

fun <R,T: MutableList<R>> MutableLiveData<T>.addAndSync(item: R) {
    this.value?.add(item)
    this.value = this.value
}

fun <R,T: MutableList<R>> MutableLiveData<T>.changeAndSync(pos: Int, item: R) {
    this.value?.set(pos, item)
    this.value = this.value
}

fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }

fun Fragment.finish() {
    val fm = this.activity?.supportFragmentManager
    fm?.beginTransaction()?.remove(this)?.commit()
    fm?.popBackStack()
}