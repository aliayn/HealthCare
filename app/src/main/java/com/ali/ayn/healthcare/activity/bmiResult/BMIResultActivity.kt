package com.ali.ayn.healthcare.activity.bmiResult

import android.app.Activity
import android.content.Context
import com.ali.ayn.healthcare.App.Companion.component
import com.ali.ayn.healthcare.base.BaseActivity

class BMIResultActivity : BaseActivity<BMIResultView, BMIResultPresenter>() {

    override val view: BMIResultView
        get() = BMIResultView(this)

    override fun setPresenter() {
        component.inject(this)
        presenter.setData(intent)
    }

    override val activity: Activity
        get() = this

    override fun onBackPressed() {
        presenter.finish()
    }

    companion object {
        fun start(context: Context, bmi: Int, isSaved: Boolean, isMale: Boolean) {
            start(context, bmi, isSaved, isMale, BMIResultActivity::class.java)
        }

        fun start(context: Context, bmi: Int, isSaved: Boolean, time: Long, isMale: Boolean) {
            start(context, bmi, isSaved, time, isMale, BMIResultActivity::class.java)
        }

        fun fa(): Activity? {
            return getFa()
        }
    }

}