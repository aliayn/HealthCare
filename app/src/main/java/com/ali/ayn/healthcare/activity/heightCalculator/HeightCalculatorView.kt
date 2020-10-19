package com.ali.ayn.healthcare.activity.heightCalculator

import android.content.Context
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseView

class HeightCalculatorView(context: Context) :
    BaseView(context, R.layout.height_calculator_fragment) {

    fun calHeight(presenter: HeightCalculatorPresenter) {
        /* btn_height_result.onClick {
             presenter.calHeight(
                 !toggle_gender.isChecked,
                 seekbar_height_father.progress,
                 seekbar_height_mother.progress,
                 context
             )
         }*/
    }

    fun finish(presenter: HeightCalculatorPresenter) {
        //btn_back_height_cal.onClick { presenter.finish() }
    }
}