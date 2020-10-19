package com.ali.ayn.healthcare.activity.main

import android.content.Context
import android.widget.ImageButton
import android.widget.RelativeLayout
import com.ali.ayn.healthcare.base.BasePresenter

class MainPresenter constructor(model: MainModel?) :
    BasePresenter<MainView, MainModel>(model) {

    override fun start() {
        view.initViews(this)
        view.checkTapTarget(this)
    }

    override fun resume() {

    }

    fun checkFirstLogin(
        height: RelativeLayout,
        bmi: RelativeLayout,
        menu: ImageButton,
        activity: Context
    ) {
        model.checkFirstLogin(height, bmi, menu, activity)
    }

    fun heightActivity(context: Context) {
        model.heightActivity(context)
    }

    fun bmiActivity(context: Context) {
        model.bmiActivity(context)
    }

    fun bmiSavedActivity(context: Context) {
        model.bmiSavedActivity(context)
    }

    fun backPressed(context: Context) {
        model.backPressed(context)
    }
}