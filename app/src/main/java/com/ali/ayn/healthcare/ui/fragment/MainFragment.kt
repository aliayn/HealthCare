package com.ali.ayn.healthcare.ui.fragment

import android.os.Bundle
import android.view.View
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseFragment
import com.ali.ayn.healthcare.helper.initToolbar
import com.ali.ayn.healthcare.helper.navigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.sdk27.coroutines.onClick

@AndroidEntryPoint
class MainFragment : BaseFragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enableNavDrawer(true)
        relative_main_height.onClick { navigate(R.id.action_mainFragment_to_heightCalculatorFragment) }
        relative_main_bmi.onClick { navigate(R.id.action_mainFragment_to_BMICalculatorFragment) }
    }
}