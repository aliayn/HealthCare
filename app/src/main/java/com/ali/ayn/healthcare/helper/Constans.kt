package com.ali.ayn.healthcare.helper

import android.content.Context
import com.ali.ayn.healthcare.R

const val HEIGHT = "height"
const val IS_BOY = "is_boy"
const val IS_MALE = "is_male"
const val IS_SAVED = "is_saved"
const val BMI = "bmi"
const val TIME = "time"

fun xAxisList(context: Context) = arrayListOf(
    context.resources.getString(R.string.month1),
    context.resources.getString(R.string.month2),
    context.resources.getString(R.string.month3),
    context.resources.getString(R.string.month4),
    context.resources.getString(R.string.month5),
    context.resources.getString(R.string.month6),
    context.resources.getString(R.string.month7),
    context.resources.getString(R.string.month8),
    context.resources.getString(R.string.month9),
    context.resources.getString(R.string.month10),
    context.resources.getString(R.string.month11),
    context.resources.getString(R.string.month12)
)