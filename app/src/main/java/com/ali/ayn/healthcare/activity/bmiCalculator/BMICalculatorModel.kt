package com.ali.ayn.healthcare.activity.bmiCalculator

import android.content.Context
import android.widget.TextView
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.activity.bmiResult.BMIResultActivity
import javax.inject.Inject

class BMICalculatorModel @Inject constructor() {

    fun cal(isFemale: Boolean, height: Int, weight: Int, context: Context) {
        val bmi = weight / ((height / 100.0) * (height / 100.0))
        bmiResult(bmi.toInt(), !isFemale, context)
    }

    private fun bmiResult(bmi: Int, isMale: Boolean, context: Context) {
        BMIResultActivity.start(context, bmi, false, isMale)
    }

    fun setHeight(textView: TextView, height: Int, context: Context) {
        textView.text = String.format(
            "%s %d %s", context.resources.getString(R.string.height),
            Math.round(height.toFloat()), context.resources.getString(R.string.cm)
        )
    }

    fun setAge(textView: TextView, age: Int, context: Context) {
        textView.text = String.format(
            "%s %d %s", context.resources.getString(R.string.age),
            Math.round(age.toFloat()), context.resources.getString(R.string.year)
        )
    }

    fun setWeight(textView: TextView, weight: Int, context: Context) {
        textView.text = String.format(
            "%s %d %s", context.resources.getString(R.string.weight),
            Math.round(weight.toFloat()), context.resources.getString(R.string.kg)
        )
    }

    fun finish() {
        BMICalculatorActivity.fa()?.finish()
    }

}