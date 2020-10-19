package com.ali.ayn.healthcare.activity.bmiSaved

import android.content.Context
import com.ali.ayn.healthcare.activity.bmiSaved.adapter.BmiSavedAdapter
import com.ali.ayn.healthcare.base.BasePresenter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import java.util.ArrayList
import javax.inject.Inject

class BmiSavedPresenter @Inject constructor(model: BmiSavedModel?) : BasePresenter<BmiSavedView, BmiSavedModel>(model) {

    override fun start() {
        view.finish(this)
    }

    override fun resume() {
        view.initAdapter(this)
    }

    fun setLineChartData(barDataSets: ArrayList<IBarDataSet>, xAxis: ArrayList<String>) {
        view.initBarChart(barDataSets, xAxis)
    }


    fun getAdapter(context: Context) {
        model.getAdapter(context, this)
    }

    fun updateAdapter(adapter: BmiSavedAdapter, context: Context) {
        model.updateAdapter(adapter, context, this)
    }

    fun clearChart() {
        view.clearData()
    }

    fun finish() {
        model.finish()
    }

    fun setAdapter(adapter: BmiSavedAdapter) {
        view.initRV()
        view.setAdapter(adapter)
    }
}