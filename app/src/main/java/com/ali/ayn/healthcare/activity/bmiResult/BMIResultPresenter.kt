package com.ali.ayn.healthcare.activity.bmiResult

import android.content.Context
import android.content.Intent
import android.widget.ImageButton
import com.ali.ayn.healthcare.base.BasePresenter
import javax.inject.Inject

class BMIResultPresenter @Inject constructor(model: BMIResultModel?) : BasePresenter<BMIResultView, BMIResultModel>(model) {

    fun setData(intent: Intent) {
        model.setData(intent)
    }

    override fun start() {
        view.isSaved(this)
        view.setBmi(model.getBmi(), model.getColor(view.context))
        view.setBmiDescription(model.setDescription(view.context), model.getColor(view.context))
        view.dataFunction(this)
        view.finish(this)
    }

    override fun resume() {

    }

    fun setSaveData(btnSave: ImageButton) {
        model.setSaveData(btnSave)
    }

    fun shareData(context: Context) {
        model.shareData(context)
    }

    fun isSaved():Boolean{
        return model.isSaved()
    }

    fun finish() {
        model.finish()
    }
}