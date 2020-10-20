package com.ali.ayn.healthcare.activity.bmiCalculator

import android.content.Context
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseView
import com.xw.repo.BubbleSeekBar
import kotlinx.android.synthetic.main.bmi_calculator_fragment.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class BMICalculatorView(context: Context) : BaseView(context, R.layout.bmi_calculator_fragment) {

    fun calculate(presenter: BMICalculatorPresenter) {
        btn_bmi_cal.onClick {
            presenter.calculateBMI(
                toggle_gender.isChecked,
                seekbar_height.progress,
                seekbar_weight.progress,
                context
            )
        }
    }

    fun initView(presenter: BMICalculatorPresenter) {
        seekbar_height.onProgressChangedListener =
            object : BubbleSeekBar.OnProgressChangedListener {
                override fun onProgressChanged(
                    bubbleSeekBar: BubbleSeekBar,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {
                    presenter.setHeight(txt_bmi_height, progress, context)
                }

                override fun getProgressOnActionUp(
                    bubbleSeekBar: BubbleSeekBar,
                    progress: Int,
                    progressFloat: Float
                ) {

                }

                override fun getProgressOnFinally(
                    bubbleSeekBar: BubbleSeekBar,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {

                }
            }
        seekbar_age.onProgressChangedListener = object : BubbleSeekBar.OnProgressChangedListener {
            override fun onProgressChanged(
                bubbleSeekBar: BubbleSeekBar,
                progress: Int,
                progressFloat: Float,
                fromUser: Boolean
            ) {
                presenter.setAge(txt_bmi_age, progress, context)
            }

            override fun getProgressOnActionUp(
                bubbleSeekBar: BubbleSeekBar,
                progress: Int,
                progressFloat: Float
            ) {

            }

            override fun getProgressOnFinally(
                bubbleSeekBar: BubbleSeekBar,
                progress: Int,
                progressFloat: Float,
                fromUser: Boolean
            ) {

            }
        }
        seekbar_weight.onProgressChangedListener =
            object : BubbleSeekBar.OnProgressChangedListener {
                override fun onProgressChanged(
                    bubbleSeekBar: BubbleSeekBar,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {
                    presenter.setWeight(txt_bmi_weight, progress, context)
                }

                override fun getProgressOnActionUp(
                    bubbleSeekBar: BubbleSeekBar,
                    progress: Int,
                    progressFloat: Float
                ) {

                }

                override fun getProgressOnFinally(
                    bubbleSeekBar: BubbleSeekBar,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {

                }
            }
    }

    fun finish(presenter: BMICalculatorPresenter) {
        //btn_back_bmi_cal.onClick { presenter.finish() }
    }

}