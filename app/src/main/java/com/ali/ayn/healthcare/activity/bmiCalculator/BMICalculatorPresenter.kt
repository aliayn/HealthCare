package com.ali.ayn.healthcare.activity.bmiCalculator

import android.content.Context
import android.widget.TextView
import com.ali.ayn.healthcare.base.BasePresenter

class BMICalculatorPresenter constructor(model: BMICalculatorModel?) :
    BasePresenter<BMICalculatorView, BMICalculatorModel>(model) {

    override fun start() {
        view.calculate(this)
        view.initView(this)
        view.finish(this)
    }

    override fun resume() {

    }

    fun setWeight(txtWeight: TextView, weight: Int, context: Context) {
        model.setWeight(txtWeight, weight, context)
    }

    fun setAge(txtAge: TextView, age: Int, context: Context) {
        model.setAge(txtAge, age, context)
    }

    fun setHeight(textView: TextView, height: Int, context: Context) {
        model.setHeight(textView, height, context)
    }

    fun calculateBMI(isFemale: Boolean, height: Int, weight: Int, context: Context) {
        model.cal(isFemale, height, weight, context)
    }

    fun finish() {
        model.finish()
    }
}