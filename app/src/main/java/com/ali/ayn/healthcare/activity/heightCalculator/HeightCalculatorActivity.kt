package com.ali.ayn.healthcare.activity.heightCalculator

import android.app.Activity
import android.content.Context
import com.ali.ayn.healthcare.base.BaseActivity
import com.ali.ayn.healthcare.custom.App.Companion.component

class HeightCalculatorActivity : BaseActivity<HeightCalculatorView, HeightCalculatorPresenter>() {


    override val view: HeightCalculatorView
        get() = HeightCalculatorView(this)

    override fun setPresenter() {
        component.inject(this)
    }

    override val activity: Activity
        get() = this

    companion object {
        fun start(context: Context) {
            start(context, HeightCalculatorActivity::class.java)
        }
        fun fa(): Activity? {
            return getFa()
        }
    }


}