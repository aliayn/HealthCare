package com.ali.ayn.healthcare.activity.bmiSaved

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.activity.bmiSaved.adapter.BmiSavedAdapter
import com.ali.ayn.healthcare.base.BaseView
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlinx.android.synthetic.main.activity_bmi_saved.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.util.*

class BmiSavedView(context: Context) : BaseView(context, R.layout.activity_bmi_saved) {

    private var layoutManager: LinearLayoutManager? = null

    fun initAdapter(presenter: BmiSavedPresenter) {
        if (recycler_bmi_saved.adapter == null) {
            presenter.getAdapter(context)
        } else
            presenter.updateAdapter(recycler_bmi_saved.adapter as BmiSavedAdapter, context)
    }

    fun initBarChart(barDataSets: ArrayList<IBarDataSet>, xAxis: ArrayList<String>) {
        val data = BarData(xAxis, barDataSets)
        chart.invalidate()
        chart.data = data
        chart.animateXY(2000, 2000)
        chart.setDescription("")
        chart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry, dataSetIndex: Int, h: Highlight) {
                layoutManager?.scrollToPositionWithOffset(dataSetIndex, 20)
            }

            override fun onNothingSelected() {

            }
        })
        scrollView.fullScroll(View.FOCUS_UP)
    }

    fun setAdapter(adapter: BmiSavedAdapter) {
        if (recycler_bmi_saved.adapter == null)
            recycler_bmi_saved.adapter = adapter
    }

    fun initRV() {
        if (layoutManager == null)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        layoutManager?.isSmoothScrollbarEnabled = true
        recycler_bmi_saved.setHasFixedSize(true)
        recycler_bmi_saved.layoutManager = layoutManager
        chart.visibility = VISIBLE
        line_record_list.visibility = VISIBLE
        txt_bmi_saved.visibility = GONE
    }

    fun finish(presenter: BmiSavedPresenter) {
        btn_back_bmi_save.onClick { presenter.finish() }
    }

    fun clearData() {
        chart.visibility = GONE
        line_record_list.visibility = GONE
        recycler_bmi_saved.visibility = GONE
        txt_bmi_saved.visibility = VISIBLE
    }
}