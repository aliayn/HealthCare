package com.ali.ayn.healthcare.activity.main

import android.app.Activity
import android.content.Context
import com.ali.ayn.healthcare.base.BaseActivity
import com.ali.ayn.healthcare.custom.App.Companion.component

class MainActivity : BaseActivity<MainView, MainPresenter>() {

    override val view: MainView
        get() = MainView(this)

    override fun setPresenter() {
        component.inject(this)
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
