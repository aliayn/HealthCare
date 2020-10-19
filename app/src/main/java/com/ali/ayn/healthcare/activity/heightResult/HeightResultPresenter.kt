package com.ali.ayn.healthcare.activity.heightResult

import android.content.Context
import android.content.Intent
import android.widget.ImageButton
import android.widget.TextView
import com.ali.ayn.healthcare.base.BasePresenter
import com.facebook.drawee.view.SimpleDraweeView
import javax.inject.Inject

class HeightResultPresenter @Inject constructor(model: HeightResultModel) :
    BasePresenter<HeightResultView, HeightResultModel>(model) {

    fun setIntent(intent: Intent) {
        model.setIntent(intent)
    }

    override fun start() {
        view.initView(this)
        view.finish(this)
    }

    override fun resume() {

    }

    fun initView(
        image_height_result: SimpleDraweeView,
        txt_height_result: TextView,
        context: Context,
        btn_share_result: ImageButton
    ) {
        model.initView(image_height_result, txt_height_result, context, btn_share_result)
    }

    fun finish(){
        model.finish()
    }

}