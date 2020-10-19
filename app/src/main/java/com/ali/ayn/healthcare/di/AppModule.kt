package com.ali.ayn.healthcare.di

import android.content.Context
import com.ali.ayn.healthcare.data.local.dao.BMIDao
import com.ali.ayn.healthcare.data.local.db.BMIDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): BMIDataBase =
        BMIDataBase.getInstance(appContext)

    @Singleton
    @Provides
    fun provideNoteDao(db: BMIDataBase): BMIDao = db.bmiDao()
}