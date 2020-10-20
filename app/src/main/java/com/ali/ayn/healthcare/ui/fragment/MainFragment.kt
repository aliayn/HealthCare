package com.ali.ayn.healthcare.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.helper.MainActivityDelegate
import com.ali.ayn.healthcare.helper.initToolbar
import com.ali.ayn.healthcare.helper.navigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.sdk27.coroutines.onClick

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    private var delegate: MainActivityDelegate? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            delegate = context as MainActivityDelegate
        } catch (e: ClassCastException) {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar(toolbar, resources.getString(R.string.app_name), false)
        delegate?.setupNavDrawer(toolbar)

        relative_main_height.onClick { navigate(R.id.action_mainFragment_to_heightCalculatorFragment) }
        relative_main_bmi.onClick { navigate(R.id.action_mainFragment_to_BMICalculatorFragment) }
    }
}