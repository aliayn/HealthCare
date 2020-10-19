package com.ali.ayn.healthcare.activity.bmiSaved.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.activity.bmiSaved.adapter.mvp.BmiSavedAdapterModel
import com.ali.ayn.healthcare.activity.bmiSaved.adapter.mvp.BmiSavedAdapterPresenter
import com.ali.ayn.healthcare.activity.bmiSaved.adapter.mvp.BmiSavedViewHolder
import javax.inject.Inject

class BmiSavedAdapter @Inject constructor(private val mainAdapterPresenter: BmiSavedAdapterPresenter) :
    RecyclerViewList<BmiSavedAdapterModel, BmiSavedAdapterPresenter, BmiSavedViewHolder>() {

    override fun getModelId(model: BmiSavedAdapterModel): Any {
        return model.time
    }

    override fun createPresenter(model: BmiSavedAdapterModel): BmiSavedAdapterPresenter {
        return mainAdapterPresenter
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): BmiSavedViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.bmi_saved_recycler_layout, viewGroup, false)
        return BmiSavedViewHolder(view)
    }

}