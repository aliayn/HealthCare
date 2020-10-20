package com.ali.ayn.healthcare.helper

import android.content.Context
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.data.local.entity.BMI
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import java.util.*

fun converter(dataList: List<BMI>, context: Context): ArrayList<IBarDataSet> {
    val dataSets = arrayListOf<IBarDataSet>()
    val valueSet1: MutableList<BarEntry> = arrayListOf()
    val colors: MutableList<Int> = arrayListOf()
    for (i in dataList.indices) {
        val bmiData = dataList[i]
        colors.add(getColor(bmiData.bmi.toInt(), context))
        valueSet1.add(BarEntry(bmiData.bmi.toFloat(), getMonth(bmiData.time)))
        val barDataSet1 = BarDataSet(valueSet1, "" + (i + 1))
        barDataSet1.colors = colors
        dataSets.add(barDataSet1)
        valueSet1.clear()
        colors.clear()
    }
    return dataSets
}

private fun getMonth(date: Long?): Int {
    return date?.let {
        Date(it).month
    } ?: run {
        Date().month
    }
}

private fun getColor(bmi: Int, context: Context): Int {
    return when {
        bmi < 20 -> context.resources.getColor(R.color.blue)
        bmi < 25 -> context.resources.getColor(R.color.green)
        bmi < 30 -> context.resources.getColor(R.color.yellow)
        else -> context.resources.getColor(R.color.red)
    }
}