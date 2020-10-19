package com.ali.ayn.healthcare.data.bmiResult

import com.orm.SugarRecord
import javax.inject.Inject

class BmiDAO @Inject constructor() {

     fun save(dataModel: BmiData) {
        val model = BmiData(dataModel.time, dataModel.bmi, dataModel.isMale)
        model.save()
    }

     fun deleteByTime(time: Long) {
        val models =
            SugarRecord.findWithQuery(BmiData::class.java, "Select * from BmiData where time = ?", time.toString())
        models[0]?.delete()
    }

     fun findAll(): List<BmiData> {
        return SugarRecord.listAll(BmiData::class.java)
    }

    fun findFirst(): BmiData? {
        return SugarRecord.first(BmiData::class.java)
    }

    fun deleteAll() {
        SugarRecord.deleteAll(BmiData::class.java)
    }

}