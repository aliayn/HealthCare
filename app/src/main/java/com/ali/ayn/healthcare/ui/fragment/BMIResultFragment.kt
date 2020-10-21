package com.ali.ayn.healthcare.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseFragment
import com.ali.ayn.healthcare.helper.BMI
import com.ali.ayn.healthcare.helper.IS_MALE
import com.ali.ayn.healthcare.helper.IS_SAVED
import com.ali.ayn.healthcare.helper.TIME
import com.ali.ayn.healthcare.viewmodel.BMIViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.bmi_result_fragment.*
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.textColor

@AndroidEntryPoint
class BMIResultFragment : BaseFragment(R.layout.bmi_result_fragment) {

    private val viewModel: BMIViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = context ?: return

        val bmi = arguments?.getDouble(BMI) ?: return
        val isSaved = arguments?.getBoolean(IS_SAVED) ?: return
        val time = arguments?.getLong(TIME)
        val isMale = arguments?.getBoolean(IS_MALE) ?: return

        initView(bmi.toInt(), isMale, isSaved, context)
    }

    private fun initView(bmi: Int, isMale: Boolean, isSaved: Boolean, context: Context) {
        setBmiDescription(bmi, isMale, context)
        setBmi(bmi, context)
        setSaveImage(isSaved)
    }

    private fun setBmiDescription(bmi: Int, isMale: Boolean, context: Context) {
        val description = getDescription(bmi, isMale)
        val color = getColor(bmi, context)
        txt_result_description.visibility = FrameLayout.VISIBLE
        txt_result_description.textColor = color
        txt_result_description.text = description
    }

    private fun setBmi(bmi: Int, context: Context) {
        val color = getColor(bmi, context)
        progress_circular.progressValue = bmi * 2
        progress_circular.waveColor = color
        progress_circular.centerTitle = "BMI : $bmi"
    }

    private fun getDescription(mBmi: Int, isMale: Boolean): String {
        val i: Int = if (!isMale)
            mBmi + 1
        else
            mBmi
        return if (i < 15)
            resources.getString(R.string.Very_Severely_Underweight)
        else if (i < 15.9)
            resources.getString(R.string.Severely_Underweight)
        else if (i >= 16 && i < 18.4)
            resources.getString(R.string.Underweight)
        else if (i >= 18.5 && i < 24.9)
            resources.getString(R.string.Normal)
        else if (i >= 25 && i < 29.9)
            resources.getString(R.string.Overweight)
        else if (i >= 30 && i < 34.9)
            resources.getString(R.string.Obese_Class_1)
        else if (i >= 35 && i < 39.9)
            resources.getString(R.string.Obese_Class_2)
        else if (i >= 40)
            resources.getString(R.string.Obese_Class_3)
        else
            resources.getString(R.string.Normal)

    }

    private fun setSaveImage(isSaved: Boolean) {
        if (isSaved)
            btn_save_result.imageResource = R.drawable.ic_turned_in_48px

    }

    private fun getColor(bmi: Int, context: Context): Int {
        return when {
            bmi < 20 -> ContextCompat.getColor(context, R.color.blue)
            bmi < 25 -> ContextCompat.getColor(context, R.color.green)
            bmi < 30 -> ContextCompat.getColor(context, R.color.yellow)
            else -> ContextCompat.getColor(context, R.color.red)
        }
    }
}