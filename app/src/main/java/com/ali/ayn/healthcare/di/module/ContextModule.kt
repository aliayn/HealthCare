package com.ali.ayn.healthcare.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
open class ContextModule constructor(private val context: Context) {

    @Provides
    fun context() : Context{
        return context
    }
}