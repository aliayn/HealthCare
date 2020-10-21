package com.ali.ayn.healthcare.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseFragment
import com.ali.ayn.healthcare.helper.BMI
import com.ali.ayn.healthcare.helper.IS_MALE
import com.ali.ayn.healthcare.helper.IS_SAVED
import com.ali.ayn.healthcare.helper.navigate
import com.ali.ayn.healthcare.viewmodel.BMIViewModel
import com.xw.repo.BubbleSeekBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.bmi_calculator_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import kotlin.math.roundToInt

@AndroidEntryPoint
class BMICalculatorFragment : BaseFragment(R.layout.bmi_calculator_fragment) {

    private val viewModel: BMIViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        calculateBMI()
    }

    private fun calculateBMI() {
        btn_bmi_cal.onClick {
            viewModel.calculateBMI(
                seekbar_height.progress,
                seekbar_weight.progress
            ) {
                val bundle =
                    bundleOf(BMI to it, IS_MALE to toggle_gender.isChecked, IS_SAVED to false)
                navigate(R.id.action_BMICalculatorFragment_to_BMIResultFragment, bundle)
            }
        }
    }

    private fun initViews() {
        seekbar_age.onProgressChangedListener = object : BubbleSeekBar.OnProgressChangedListener {
            override fun onProgressChanged(
                bubbleSeekBar: BubbleSeekBar?,
                progress: Int,
                progressFloat: Float,
                fromUser: Boolean
            ) {
                txt_bmi_age.text = String.format(
                    "%s %d %s", resources.getString(R.string.age),
                    progress.toFloat().roundToInt(), resources.getString(R.string.year)
                )
            }

            override fun getProgressOnActionUp(
                bubbleSeekBar: BubbleSeekBar?,
                progress: Int,
                progressFloat: Float
            ) {

            }

            override fun getProgressOnFinally(
                bubbleSeekBar: BubbleSeekBar?,
                progress: Int,
                progressFloat: Float,
                fromUser: Boolean
            ) {

            }

        }
        seekbar_height.onProgressChangedListener =
            object : BubbleSeekBar.OnProgressChangedListener {
                override fun onProgressChanged(
                    bubbleSeekBar: BubbleSeekBar?,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {
                    txt_bmi_height.text = String.format(
                        "%s %d %s", resources.getString(R.string.height),
                        progress.toFloat().roundToInt(), resources.getString(R.string.cm)
                    )
                }

                override fun getProgressOnActionUp(
                    bubbleSeekBar: BubbleSeekBar?,
                    progress: Int,
                    progressFloat: Float
                ) {

                }

                override fun getProgressOnFinally(
                    bubbleSeekBar: BubbleSeekBar?,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {

                }

            }
        seekbar_weight.onProgressChangedListener =
            object : BubbleSeekBar.OnProgressChangedListener {
                override fun onProgressChanged(
                    bubbleSeekBar: BubbleSeekBar?,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {
                    txt_bmi_weight.text = String.format(
                        "%s %d %s", resources.getString(R.string.weight),
                        progress.toFloat().roundToInt(), resources.getString(R.string.kg)
                    )
                }

                override fun getProgressOnActionUp(
                    bubbleSeekBar: BubbleSeekBar?,
                    progress: Int,
                    progressFloat: Float
                ) {

                }

                override fun getProgressOnFinally(
                    bubbleSeekBar: BubbleSeekBar?,
                    progress: Int,
                    progressFloat: Float,
                    fromUser: Boolean
                ) {

                }

            }
    }
}