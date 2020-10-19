package com.ali.ayn.healthcare.activity.heightResult

import android.content.Context
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseView
import kotlinx.android.synthetic.main.activity_height_result.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class HeightResultView(context: Context) : BaseView(context, R.layout.activity_height_result) {

    fun initView(presenter: HeightResultPresenter) {
        presenter.initView(image_height_result, txt_height_result, context, btn_share_result)
    }

    fun finish(presenter: HeightResultPresenter) {
        btn_back_height_result.onClick { presenter.finish() }
    }

}