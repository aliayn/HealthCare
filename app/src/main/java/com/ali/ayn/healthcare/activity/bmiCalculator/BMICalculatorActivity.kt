package com.ali.ayn.healthcare.activity.bmiCalculator

import android.app.Activity
import android.content.Context
import com.ali.ayn.healthcare.base.BaseActivity
import com.ali.ayn.healthcare.custom.App.Companion.component

class BMICalculatorActivity : BaseActivity<BMICalculatorView, BMICalculatorPresenter>() {

    override val view: BMICalculatorView
        get() = BMICalculatorView(this)

    override fun setPresenter() {
        component.inject(this)
    }

    override val activity: Activity
        get() = this

    companion object {
        fun start(context: Context) {
            start(context, BMICalculatorActivity::class.java)
        }
        fun fa(): Activity? {
            return getFa()
        }
    }


}