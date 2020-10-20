package com.ali.ayn.healthcare.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class BMIViewModel @ViewModelInject constructor() : ViewModel() {

    inline fun calculateBMI(height: Int, weight: Int, callback: (Double) -> Unit) {
        val bmi = weight / ((height / 100.0) * (height / 100.0))
        callback.invoke(bmi)
    }
}