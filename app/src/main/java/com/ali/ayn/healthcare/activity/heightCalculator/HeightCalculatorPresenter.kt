package com.ali.ayn.healthcare.activity.heightCalculator

import android.content.Context
import com.ali.ayn.healthcare.base.BasePresenter
import javax.inject.Inject

class HeightCalculatorPresenter @Inject constructor(model: HeightCalculatorModel?) :
    BasePresenter<HeightCalculatorView, HeightCalculatorModel>(model) {

    override fun start() {
        view.calHeight(this)
        view.finish(this)
    }

    override fun resume() {

    }

    fun calHeight(isBoy: Boolean, fatherHeight: Int, motherHeight: Int, context: Context) {
        model.calHeight(isBoy, fatherHeight, motherHeight, context)
    }

    fun finish() {
        model.finish()
    }
}