package com.abdelrahman.myskeletonapp.features

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abdelrahman.myskeletonapp.R
import com.abdelrahman.myskeletonapp.logger.Logger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
