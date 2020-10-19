package com.ali.ayn.healthcare.mapper

import com.ali.ayn.healthcare.activity.bmiSaved.adapter.mvp.BmiSavedAdapterModel
import com.ali.ayn.healthcare.db.bmiResult.BmiData

class BmiDataMapper {

    companion object {
        fun convert(bmiData: BmiData): BmiSavedAdapterModel {
            val model = BmiSavedAdapterModel()
            model.time = bmiData.time
            model.bmi = bmiData.bmi
            model.isMale = bmiData.isMale
            return model
        }

        fun convert(bmiData: List<BmiData>): List<BmiSavedAdapterModel> {
            val models = ArrayList<BmiSavedAdapterModel>()
            for (i in 0 until bmiData.size) {
                val model = BmiSavedAdapterModel()
                model.time = bmiData[i].time
                model.bmi = bmiData[i].bmi
                model.isMale = bmiData[i].isMale
                models.add(model)
            }
            return models
        }
    }
}