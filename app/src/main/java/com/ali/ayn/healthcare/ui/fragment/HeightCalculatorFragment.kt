package com.ali.ayn.healthcare.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseFragment
import com.ali.ayn.healthcare.helper.HEIGHT
import com.ali.ayn.healthcare.helper.IS_BOY
import com.ali.ayn.healthcare.helper.navigate
import com.ali.ayn.healthcare.viewmodel.HeightViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.height_calculator_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick

@AndroidEntryPoint
class HeightCalculatorFragment : BaseFragment(R.layout.height_calculator_fragment) {

    private val viewModel: HeightViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_height_result.onClick { calculateHeight() }
    }

    private fun calculateHeight() {
        viewModel.setHeight(
            !toggle_gender.isChecked,
            seekbar_height_father.progress,
            seekbar_height_mother.progress
        ) {
            it.forEach { entry ->
                val height = entry.key
                val isBoy = entry.value
                val bundle = bundleOf(HEIGHT to height, IS_BOY to isBoy)
                navigate(R.id.action_heightCalculatorFragment_to_heightResultFragment, bundle)
            }

        }
    }
}