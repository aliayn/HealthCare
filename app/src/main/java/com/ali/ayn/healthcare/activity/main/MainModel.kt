package com.ali.ayn.healthcare.activity.main

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.activity.bmiCalculator.BMICalculatorActivity
import com.ali.ayn.healthcare.activity.bmiSaved.BmiSavedActivity
import com.ali.ayn.healthcare.activity.heightCalculator.HeightCalculatorActivity
import com.ali.ayn.healthcare.data.SharePrefManager
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt

class MainModel constructor(private val sharePrefManager: SharePrefManager) {

    private var isBackPressed: Boolean = false

    fun checkFirstLogin(height: View, bmi: View, menu: View, context1: Context) {
        if (!sharePrefManager.isLogin()) {
            height.isEnabled = false
            bmi.isEnabled = false
            menu.isEnabled = false
            MaterialTapTargetPrompt.Builder(context1 as Activity)
                .setTarget(R.id.relative_main_height)
                .setPrimaryText(context1.getResources().getString(R.string.txt_main_height_cal))
                .setSecondaryText(
                    context1.getResources().getString(R.string.txt_main_height_cal_detail)
                )
                .setIconDrawable(context1.getResources().getDrawable(R.drawable.ic_height))
                .setPromptStateChangeListener { _, state ->
                    if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED || state == MaterialTapTargetPrompt.STATE_DISMISSING) {
                        showViewBMI(height, bmi, menu, context1)
                    }
                }.show()
        }
    }

    private fun showViewBMI(height: View, bmi: View, menu: View, context1: Context) {
        MaterialTapTargetPrompt.Builder(context1 as Activity)
            .setTarget(R.id.relative_main_bmi)
            .setPrimaryText(context1.getResources().getString(R.string.txt_main_bmi_cal))
            .setSecondaryText(context1.getResources().getString(R.string.txt_main_bmi_cal_detail))
            .setIconDrawable(context1.getResources().getDrawable(R.drawable.ic_weight))
            .setPromptStateChangeListener { _, state ->
                if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED || state == MaterialTapTargetPrompt.STATE_DISMISSING) {
                    showViewMenu(height, bmi, menu, context1)
                }
            }.show()

    }

    private fun showViewMenu(height: View, bmi: View, menu: View, context1: Context) {
        menu.isEnabled = false
        MaterialTapTargetPrompt.Builder(context1 as Activity)
            .setTarget(R.id.btn_navigation)
            .setPrimaryText(context1.getResources().getString(R.string.menu))
            .setSecondaryText(context1.getResources().getString(R.string.menu_detail))
            .setIconDrawable(context1.getResources().getDrawable(R.drawable.ic_dehaze_black_24dp))
            .setPromptStateChangeListener { _, state ->
                if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED || state == MaterialTapTargetPrompt.STATE_DISMISSING) {
                    height.isEnabled = true
                    bmi.isEnabled = true
                    menu.isEnabled = true
                    sharePrefManager.setLogin(true)
                }
            }.show()
    }

    fun backPressed(context: Context) {
        if (isBackPressed) {
            MainActivity.fa()?.finish()
            isBackPressed = false
        } else {
            isBackPressed = true
            Handler().postDelayed({ isBackPressed = false }, 1000)
            Toast.makeText(context, context.resources.getString(R.string.exit), Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun heightActivity(context: Context) {
        HeightCalculatorActivity.start(context)
    }

    fun bmiActivity(context: Context) {
        BMICalculatorActivity.start(context)
    }

    fun bmiSavedActivity(context: Context) {
        BmiSavedActivity.start(context)
    }
}