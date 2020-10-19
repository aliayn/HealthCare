package com.ali.ayn.healthcare.activity.heightResult

import android.app.Activity
import android.content.Context
import com.ali.ayn.healthcare.App.Companion.component
import com.ali.ayn.healthcare.base.BaseActivity

open class HeightResultActivity : BaseActivity<HeightResultView, HeightResultPresenter>() {

    override val view: HeightResultView
        get() = HeightResultView(this)

    override fun setPresenter() {
        component.inject(this)
        presenter.setIntent(intent)
    }

    override val activity: Activity
        get() = this

    companion object {
        fun fa(): Activity? {
            return getFa()
        }

        fun start(context: Context, height: Double, isBoy: Boolean) {
            start(context, height, isBoy, HeightResultActivity::class.java)
        }
    }
}