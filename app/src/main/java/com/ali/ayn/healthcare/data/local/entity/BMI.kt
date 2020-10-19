package com.ali.ayn.healthcare.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "bmi_records", indices = [(Index(value = ["id"], unique = true))])
data class BMI(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "time") val time: Long? = 0,
    @ColumnInfo(name = "bmi") val bmi: Long = 0,
    @ColumnInfo(name = "isMale") val isMale: Boolean = false
)