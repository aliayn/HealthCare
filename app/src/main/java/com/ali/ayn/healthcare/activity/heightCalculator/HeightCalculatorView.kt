package com.ali.ayn.healthcare.activity.heightCalculator

import android.content.Context
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseView
import kotlinx.android.synthetic.main.activity_height_calculator.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class HeightCalculatorView(context: Context) : BaseView(context, R.layout.activity_height_calculator) {

    fun calHeight(presenter: HeightCalculatorPresenter) {
        btn_height_result.onClick {
            presenter.calHeight(
                !toggle_gender.isChecked,
                seekbar_height_father.progress,
                seekbar_height_mother.progress,
                context
            )
        }
    }

    fun finish(presenter: HeightCalculatorPresenter) {
        btn_back_height_cal.onClick { presenter.finish() }
    }
}