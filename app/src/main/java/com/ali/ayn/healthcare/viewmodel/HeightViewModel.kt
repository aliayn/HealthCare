package com.ali.ayn.healthcare.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HeightViewModel : ViewModel() {

    val specifications = MutableLiveData<Map<Long, Boolean>>()

    fun setHeight(isBoy: Boolean, fatherHeight: Int, motherHeight: Int) {
        var height = ((fatherHeight + motherHeight) / 2).toDouble()
        if (isBoy)
            height += 6.5
        else
            height -= 6.5
        specifications.postValue(mapOf(height.toLong() to isBoy))
    }
}