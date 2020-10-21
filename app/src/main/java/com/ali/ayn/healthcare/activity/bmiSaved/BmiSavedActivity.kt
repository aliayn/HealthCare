package com.ali.ayn.healthcare.activity.bmiSaved

import android.app.Activity
import android.content.Context
import com.ali.ayn.healthcare.base.BaseActivity

class BmiSavedActivity : BaseActivity<BmiSavedView, BmiSavedPresenter>() {

    override val view: BmiSavedView
        get() = BmiSavedView(this)

    override fun setPresenter() {

    }

    override val activity: Activity
        get() = this

    companion object {
        fun start(context: Context) {
            start(context, BmiSavedActivity::class.java)
        }

        fun fa(): Activity? {
            return getFa()
        }
    }
}