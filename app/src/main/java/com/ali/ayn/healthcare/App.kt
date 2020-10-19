package com.ali.ayn.healthcare

import com.facebook.drawee.backends.pipeline.Fresco
import com.orm.SugarApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : SugarApp() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

}