package com.ali.ayn.healthcare.activity.heightResult

import android.content.Context
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseView

class HeightResultView(context: Context) : BaseView(context, R.layout.height_result_fragment) {

    fun initView(presenter: HeightResultPresenter) {
        // presenter.initView(image_height_result, txt_height_result, context, btn_share_result)
    }

    fun finish(presenter: HeightResultPresenter) {
        //  btn_back_height_result.onClick { presenter.finish() }
    }

}