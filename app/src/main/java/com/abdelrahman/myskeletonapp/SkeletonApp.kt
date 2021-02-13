package com.abdelrahman.myskeletonapp

import android.app.Application
import com.abdelrahman.myskeletonapp.logger.Logger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class SkeletonApp : Application() {

    @Inject
    lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()
        logger.configure()
    }
}