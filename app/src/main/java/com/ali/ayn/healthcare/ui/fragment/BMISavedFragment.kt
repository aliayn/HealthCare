package com.ali.ayn.healthcare.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseFragment
import com.ali.ayn.healthcare.data.local.entity.BMI
import com.ali.ayn.healthcare.helper.BMI_CLASS
import com.ali.ayn.healthcare.helper.IS_SAVED
import com.ali.ayn.healthcare.helper.navigate
import com.ali.ayn.healthcare.ui.adapter.BmiSavedAdapter
import com.ali.ayn.healthcare.viewmodel.BMIViewModel
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.bmi_saved_fragment.*
import java.util.*

@AndroidEntryPoint
class BMISavedFragment : BaseFragment(R.layout.bmi_saved_fragment) {

    private val viewModel: BMIViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = context ?: return

        val bmiSavedAdapter = BmiSavedAdapter {
            val bundle = bundleOf(BMI_CLASS to it, IS_SAVED to true)
            navigate(R.id.action_BMISavedFragment_to_BMIResultFragment, bundle)
        }
        recycler_bmi_saved.apply {
            adapter = bmiSavedAdapter
            (layoutManager as LinearLayoutManager).isSmoothScrollbarEnabled = true
        }

        viewModel.allBMIRecords.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()) clearData() else setData(bmiSavedAdapter, it, context)
        })
    }

    private fun initBarChart(barDataSets: ArrayList<IBarDataSet>, xAxis: ArrayList<String>) {
        val data = BarData(xAxis, barDataSets)
        chart.invalidate()
        chart.data = data
        chart.animateXY(2000, 2000)
        chart.setDescription("")
        chart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry, dataSetIndex: Int, h: Highlight) {
                (recycler_bmi_saved.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(
                    dataSetIndex,
                    20
                )
            }

            override fun onNothingSelected() {

            }
        })
        scrollView.fullScroll(View.FOCUS_UP)
    }

    private fun setData(adapter: BmiSavedAdapter, data: List<BMI>, context: Context) {
        chart.visibility = VISIBLE
        line_record_list.visibility = VISIBLE
        txt_bmi_saved.visibility = GONE
        adapter.submitList(data)
        initBarChart(viewModel.getDataSet(data, context), viewModel.getXAxisValues(context))
    }

    private fun clearData() {
        chart.visibility = GONE
        line_record_list.visibility = GONE
        recycler_bmi_saved.visibility = GONE
        txt_bmi_saved.visibility = VISIBLE
    }
}