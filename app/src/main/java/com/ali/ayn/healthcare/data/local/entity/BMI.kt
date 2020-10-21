package com.ali.ayn.healthcare.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "bmi_records", indices = [(Index(value = ["id"], unique = true))])
data class BMI(
    @PrimaryKey(autoGenerate = true) val id: Int? = 0,
    @ColumnInfo(name = "time") val time: Long? = 0L,
    @ColumnInfo(name = "bmi") val bmi: Long = 0,
    @ColumnInfo(name = "isMale") val isMale: Boolean = false
) : Parcelable