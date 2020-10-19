package com.ali.ayn.healthcare.activity.bmiSaved

import android.content.Context
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.activity.bmiResult.BMIResultActivity
import com.ali.ayn.healthcare.activity.bmiSaved.adapter.BmiSavedAdapter
import com.ali.ayn.healthcare.activity.bmiSaved.adapter.ItemClickListener
import com.ali.ayn.healthcare.data.bmiResult.BmiDAO
import com.ali.ayn.healthcare.mapper.BmiDataMapper
import com.ali.ayn.healthcare.mapper.ChartDataMapper
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import java.util.*
import javax.inject.Inject

class BmiSavedModel @Inject constructor(
    private val bmiDAO: BmiDAO,
    private val adapter: BmiSavedAdapter,
    private val context: Context
) : ItemClickListener {

    fun getAdapter(context: Context, presenter: BmiSavedPresenter) {
        if (bmiDAO.findAll().isNotEmpty()) {
            adapter.itemClickListener = this
            adapter.addAll(BmiDataMapper.convert(bmiDAO.findAll()))
            presenter.setAdapter(adapter)
            initLineChart(presenter, context)
        }
    }

    fun updateAdapter(adapter: BmiSavedAdapter, context: Context, presenter: BmiSavedPresenter) {
        if (bmiDAO.findAll().isNotEmpty()) {
            if (adapter.itemCount != bmiDAO.findAll().size) {
                adapter.clear()
                adapter.addAll(BmiDataMapper.convert(bmiDAO.findAll()))
                initLineChart(presenter, context)
            }
        } else {
            presenter.clearChart()
        }

    }

    fun finish() {
        BmiSavedActivity.fa()?.finish()
    }

    override fun onItemClick(position: Int) {
        val bmiData = bmiDAO.findAll()[position]
        BMIResultActivity.start(
            context,
            bmiData.bmi,
            true,
            bmiData.time,
            bmiData.isMale
        )
    }

    private fun initLineChart(presenter: BmiSavedPresenter, context: Context) {
        presenter.setLineChartData(getDataSet(), getXAxisValues(context))
    }

    private fun getXAxisValues(context: Context): ArrayList<String> {
        val xVals = ArrayList<String>()
        xVals.add(context.resources.getString(R.string.month1))
        xVals.add(context.resources.getString(R.string.month2))
        xVals.add(context.resources.getString(R.string.month3))
        xVals.add(context.resources.getString(R.string.month4))
        xVals.add(context.resources.getString(R.string.month5))
        xVals.add(context.resources.getString(R.string.month6))
        xVals.add(context.resources.getString(R.string.month7))
        xVals.add(context.resources.getString(R.string.month8))
        xVals.add(context.resources.getString(R.string.month9))
        xVals.add(context.resources.getString(R.string.month10))
        xVals.add(context.resources.getString(R.string.month11))
        xVals.add(context.resources.getString(R.string.month12))
        return xVals
    }

    private fun getDataSet(): ArrayList<IBarDataSet> {
        return ChartDataMapper.creator(bmiDAO.findAll(),context)
    }

}