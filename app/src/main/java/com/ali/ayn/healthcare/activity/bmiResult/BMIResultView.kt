package com.ali.ayn.healthcare.activity.bmiResult

import android.content.Context
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseView
import kotlinx.android.synthetic.main.activity_bmi_result.view.*
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.textColor

class BMIResultView(context: Context) : BaseView(context, R.layout.activity_bmi_result) {

    fun isSaved(presenter: BMIResultPresenter) {
        if (presenter.isSaved()) {
            btn_save_result.imageResource = R.drawable.ic_turned_in_48px
        }
    }

    fun setBmi(bmi: Int, color: Int) {
        progress_circular.progressValue = bmi * 2
        progress_circular.waveColor = color
        progress_circular.centerTitle = "BMI : $bmi"
    }

    fun setBmiDescription(description: String, color: Int) {
        txt_result_description.visibility = VISIBLE
        txt_result_description.textColor = color
        txt_result_description.text = description
    }

    fun dataFunction(presenter: BMIResultPresenter) {
        btn_save_result.onClick { presenter.setSaveData(btn_save_result) }
        btn_share_result.onClick { presenter.shareData(context) }
    }

    fun finish(presenter: BMIResultPresenter) {
        btn_back_bmi_result.onClick { presenter.finish() }
    }
}