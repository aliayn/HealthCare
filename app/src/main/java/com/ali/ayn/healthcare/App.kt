package com.ali.ayn.healthcare

import com.ali.ayn.healthcare.di.component.DaggerMainComponent
import com.ali.ayn.healthcare.di.component.MainComponent
import com.ali.ayn.healthcare.di.module.ContextModule
import com.facebook.drawee.backends.pipeline.Fresco
import com.orm.SugarApp

class App : SugarApp() {

    companion object {
        lateinit var component: MainComponent
    }

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)

        component = DaggerMainComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }

}