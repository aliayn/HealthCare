package com.ali.ayn.healthcare

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.orm.SugarApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

}