package com.ali.ayn.healthcare.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ali.ayn.healthcare.data.local.entity.BMI

@Dao
interface BMIDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(bmi: BMI)

    @Query("DELETE FROM bmi_records WHERE time = :time")
    suspend fun deleteByTime(time: Long)

    @Query("SELECT * FROM bmi_records")
    suspend fun getAllBMIs(): LiveData<List<BMI>>
}