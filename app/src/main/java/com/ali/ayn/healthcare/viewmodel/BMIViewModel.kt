package com.ali.ayn.healthcare.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ali.ayn.healthcare.data.BMIRepository
import com.ali.ayn.healthcare.data.local.entity.BMI
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.*

class BMIViewModel @ViewModelInject constructor(
    private val bmiRepository: BMIRepository
) : ViewModel() {

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
}