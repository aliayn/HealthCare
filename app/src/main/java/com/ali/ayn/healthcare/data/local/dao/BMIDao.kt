package com.ali.ayn.healthcare.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ali.ayn.healthcare.data.local.entity.BMI

@Dao
interface BMIDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(bmi: BMI)

    @Delete
    suspend fun delete(bmi: BMI)

    @Query("SELECT * FROM bmi_records")
    fun getAllBMIs(): LiveData<List<BMI>>
}