package com.develop.greedy0110.workouttracker

import android.app.Application
import org.koin.android.ext.android.startKoin

class TrackerApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, appModules)
    }
}