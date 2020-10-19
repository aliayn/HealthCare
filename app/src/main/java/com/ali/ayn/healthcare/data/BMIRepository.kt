package com.ali.ayn.healthcare.data

import androidx.lifecycle.LiveData
import com.ali.ayn.healthcare.data.local.dao.BMIDao
import com.ali.ayn.healthcare.data.local.entity.BMI

class BMIRepository constructor(private val bmiDao: BMIDao) {

    suspend fun insertOrUpdate(bmi: BMI) = bmiDao.insertOrUpdate(bmi)

    suspend fun deleteByTime(time: Long) = bmiDao.deleteByTime(time)

    suspend fun getAllBMIs(): LiveData<List<BMI>> = bmiDao.getAllBMIs()
}