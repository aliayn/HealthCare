package com.ali.ayn.healthcare.data.local.entity

data class BMI(
    val id: Int?,
    var time: Long? = 0,
    var bmi: Long = 0,
    var isMale: Boolean = false
)