package com.ali.ayn.healthcare.activity.heightCalculator

import android.app.Activity
import android.content.Context
import com.ali.ayn.healthcare.base.BaseActivity

class HeightCalculatorActivity : BaseActivity<HeightCalculatorView, HeightCalculatorPresenter>() {


    override val view: HeightCalculatorView
        get() = HeightCalculatorView(this)

    override fun setPresenter() {

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