package com.ali.ayn.healthcare.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.helper.initToolbar
import com.ali.ayn.healthcare.viewmodel.HeightViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.height_calculator_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.sdk27.coroutines.onClick

@AndroidEntryPoint
class HeightCalculatorFragment : Fragment(R.layout.height_calculator_fragment) {

    private val viewModel: HeightViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar(toolbar, resources.getString(R.string.txt_main_height_cal), true)

        btn_height_result.onClick {
            viewModel.setHeight(!toggle_gender.isChecked,
                seekbar_height_father.progress,
                seekbar_height_mother.progress)
        }
    }
}