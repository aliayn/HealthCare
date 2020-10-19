package com.ali.ayn.healthcare.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Singleton

class HeightViewModel @ViewModelInject constructor() : ViewModel() {

    inline fun setHeight(isBoy: Boolean, fatherHeight: Int, motherHeight: Int, callback : (Map<Long, Boolean>) -> Unit) {
        var height = ((fatherHeight + motherHeight) / 2).toDouble()
        if (isBoy)
            height += 6.5
        else
            height -= 6.5
        callback.invoke(mapOf(height.toLong() to isBoy))
    }
}