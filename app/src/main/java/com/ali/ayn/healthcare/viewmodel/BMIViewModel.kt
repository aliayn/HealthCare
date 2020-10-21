package com.ali.ayn.healthcare.viewmodel

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ali.ayn.healthcare.data.BMIRepository
import com.ali.ayn.healthcare.data.local.entity.BMI
import com.ali.ayn.healthcare.helper.converter
import com.ali.ayn.healthcare.helper.xAxisList
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.*

class BMIViewModel @ViewModelInject constructor(
    private val bmiRepository: BMIRepository
) : ViewModel() {

    val allBMIRecords = bmiRepository.getAllBMIs()

    fun calculateBMI(height: Int, weight: Int, isMale: Boolean, callback: (BMI) -> Unit) {
        val bmi = weight / ((height / 100.0) * (height / 100.0))
        generateBMI(bmi.toLong(), isMale, callback)
    }

    private inline fun generateBMI(bmi: Long, isMale: Boolean, callback: (BMI) -> Unit) {
        callback.invoke(BMI(bmi = bmi, isMale = isMale))
    }

    fun save(bmi: BMI) {
        if (bmi.time == 0L)
            insert(BMI(time = Date().time, bmi = bmi.bmi, isMale = bmi.isMale))
        else
            insert(BMI(time = bmi.time, bmi = bmi.bmi, isMale = bmi.isMale))
    }

    private fun insert(bmi: BMI) = viewModelScope.launch(IO) {
        bmiRepository.insertOrUpdate(bmi)
    }

    fun delete(bmi: BMI) = viewModelScope.launch(IO) {
        bmiRepository.delete(bmi)
    }

    fun getXAxisValues(context: Context) = xAxisList(context)

    fun getDataSet(dataList: List<BMI>, context: Context) = converter(dataList, context)
}