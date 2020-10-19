package com.ali.ayn.healthcare.activity.bmiResult

import android.content.Context
import android.content.Intent
import android.widget.ImageButton
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.data.bmiResult.BmiDAO
import com.ali.ayn.healthcare.data.bmiResult.BmiData
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.share
import java.util.*

class BMIResultModel constructor(private val bmiDAO: BmiDAO) {

    private var bmi: Int = 0
    private var isSaved: Boolean = false
    private var saved: Boolean = false
    private var time: Long = 0
    private var isMale: Boolean = false

    fun setData(intent: Intent) {
        bmi = intent.getIntExtra("bmi", 0)
        isSaved = intent.getBooleanExtra("isSaved", false)
        saved = intent.getBooleanExtra("isSaved", false)
        time = intent.getLongExtra("time", 0)
        isMale = intent.getBooleanExtra("isMale", true)
    }

    fun getBmi(): Int {
        return bmi
    }

    fun isSaved(): Boolean {
        return isSaved
    }

    fun setDescription(context: Context): String {
        val i: Int = if (!isMale)
            bmi + 1
        else
            bmi
        return if (i < 15)
            context.resources.getString(R.string.Very_Severely_Underweight)
        else if (i < 15.9)
            context.resources.getString(R.string.Severely_Underweight)
        else if (i >= 16 && i < 18.4)
            context.resources.getString(R.string.Underweight)
        else if (i >= 18.5 && i < 24.9)
            context.resources.getString(R.string.Normal)
        else if (i >= 25 && i < 29.9)
            context.resources.getString(R.string.Overweight)
        else if (i >= 30 && i < 34.9)
            context.resources.getString(R.string.Obese_Class_1)
        else if (i >= 35 && i < 39.9)
            context.resources.getString(R.string.Obese_Class_2)
        else if (i >= 40)
            context.resources.getString(R.string.Obese_Class_3)
        else
            context.resources.getString(R.string.Normal)

    }

    fun setSaveData(btnSave: ImageButton) {
        if (!isSaved) {//not saved
            btnSave.imageResource = R.drawable.ic_turned_in_48px
            isSaved = true
        } else { // was saved
            btnSave.imageResource = R.drawable.ic_turned_in_not_48px
            isSaved = false
        }
    }

    fun shareData(context: Context) {
        val shareBody =
            context.resources.getString(R.string.your_bmi_result) + bmi + "\n" + context.resources.getString(
                R.string.Result
            ) + " " +
                    setDescription(context)
        context.share(shareBody, context.resources.getString(R.string.share_main))
    }

    private fun setDataInDB() {
        if (isSaved && !saved)
            bmiDAO.save(BmiData(Date().time, bmi, isMale))
        else if (saved && !isSaved) {
            if (time != 0L) {
                bmiDAO.deleteByTime(time)
            }
        }
    }

    fun getColor(context: Context): Int {
        return when {
            bmi < 20 -> context.resources.getColor(R.color.blue)
            bmi < 25 -> context.resources.getColor(R.color.green)
            bmi < 30 -> context.resources.getColor(R.color.yellow)
            else -> context.resources.getColor(R.color.red)
        }
    }

    fun finish() {
        setDataInDB()
        BMIResultActivity.fa()?.finish()
    }
}