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

    inline fun calculateBMI(height: Int, weight: Int, callback: (Double) -> Unit) {
        val bmi = weight / ((height / 100.0) * (height / 100.0))
        callback.invoke(bmi)
    }

    fun save(bmi: Long, time: Long, isMale: Boolean) {
        insert(BMI(time = Date().time, bmi = bmi, isMale = isMale))
    }

    private fun insert(bmi: BMI) = viewModelScope.launch(IO) {
        bmiRepository.insertOrUpdate(bmi)
    }

    fun getXAxisValues(context: Context) = xAxisList(context)

    fun getDataSet(dataList: List<BMI>, context: Context) = converter(dataList, context)
}