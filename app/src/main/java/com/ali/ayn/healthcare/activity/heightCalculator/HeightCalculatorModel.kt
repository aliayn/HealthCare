package com.ali.ayn.healthcare.activity.heightCalculator

import android.content.Context
import com.ali.ayn.healthcare.activity.heightResult.HeightResultActivity
import javax.inject.Inject

class HeightCalculatorModel @Inject constructor() {

    fun calHeight(isBoy: Boolean, fatherHeight: Int, motherHeight: Int, context: Context) {
        var height = ((fatherHeight + motherHeight) / 2).toDouble()
        if (isBoy)
            height += 6.5
        else
            height -= 6.5
        HeightResultActivity.start(context, height, isBoy)
    }

    fun finish() {
        HeightCalculatorActivity.fa()?.finish()
    }
}