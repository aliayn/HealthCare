package com.ali.ayn.healthcare.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ali.ayn.healthcare.data.local.dao.BMIDao
import com.ali.ayn.healthcare.data.local.entity.BMI
import com.ali.ayn.healthcare.helper.SingletonHolder

@Database(entities = [BMI::class], version = 1, exportSchema = false)
abstract class BMIDataBase : RoomDatabase() {

    abstract fun bmiDao(): BMIDao

    companion object : SingletonHolder<Context, BMIDataBase>({
        Room.databaseBuilder(it.applicationContext, BMIDataBase::class.java, "bmi.db")
            .fallbackToDestructiveMigration()
            .build()
    })
}