package com.ali.ayn.healthcare.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.helper.initToolbar
import kotlinx.android.synthetic.main.toolbar.*

class HeightCalculatorFragment : Fragment(R.layout.height_calculator_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar(toolbar,resources.getString(R.string.txt_main_height_cal),true)
    }
}