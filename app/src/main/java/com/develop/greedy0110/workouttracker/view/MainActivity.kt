package com.develop.greedy0110.workouttracker.view

import android.os.Bundle
import com.develop.greedy0110.workouttracker.R
import com.develop.greedy0110.workouttracker.databinding.ActivityMainBinding
import com.develop.greedy0110.workouttracker.view.BaseActivity
import com.develop.greedy0110.workouttracker.view.MainTabPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val TAG = "MainActivity"

    override val layoutResourceId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view_pager.adapter = MainTabPagerAdapter(supportFragmentManager)

        tabs.setupWithViewPager(view_pager)
    }
}