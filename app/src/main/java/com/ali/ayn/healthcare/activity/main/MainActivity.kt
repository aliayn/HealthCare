package com.ali.ayn.healthcare.activity.main

import android.app.Activity
import android.content.Context
import com.ali.ayn.healthcare.base.BaseActivity

class MainActivity : BaseActivity<MainView, MainPresenter>() {

    override val view: MainView
        get() = MainView(this)

    override fun setPresenter() {

    }

    override val activity: Activity
        get() = this

    override fun onBackPressed() {
        presenter.backPressed(this)
    }

    companion object {
        fun start(context: Context) {
            start(context, MainActivity::class.java)
        }

        fun fa(): Activity? {
            return getFa()
        }
    }

}
