package com.ali.ayn.healthcare.activity.bmiSaved.adapter.mvp

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.activity.bmiSaved.adapter.ItemClickListener
import com.ali.ayn.healthcare.base.BaseHolder
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.text.SimpleDateFormat
import java.util.*

class BmiSavedViewHolder(itemView: View) : BaseHolder<BmiSavedAdapterPresenter>(itemView) {

    private val imageView: ImageView = itemView.findViewById(R.id.img_bmi_saved_recycler) as ImageView
    private val txtResult: TextView = itemView.findViewById(R.id.txt_bmi_result_recycler) as TextView
    private val txtBmi: TextView = itemView.findViewById(R.id.txt_bmi_saved_recycler) as TextView
    private val txtDate: TextView = itemView.findViewById(R.id.txt_bmi_time_recycler) as TextView

    fun setData(model: BmiSavedAdapterModel, itemClickListener: ItemClickListener?) {
        itemView.onClick { itemClickListener?.onItemClick(adapterPosition) }
        txtDate.text = getDate(model.time)
        txtResult.text = setDescription(model.bmi, model.isMale,itemView.context)
        txtResult.setTextColor(getColor(model.bmi,itemView.context))
        txtBmi.text = model.bmi.toString()
        if (!model.isMale) {
            imageView.imageResource = R.drawable.ic_woman
            txtDate.setBackgroundColor(itemView.context.resources.getColor(R.color.colorPrimary))
        }
    }

    private fun getDate(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        return format.format(date)
    }

    private fun setDescription(bmi1: Int, isMale: Boolean, context: Context): String {
        var bmi = bmi1
        if (!isMale)
            bmi++
        return if (bmi < 15)
            context.resources.getString(R.string.Very_Severely_Underweight)
        else if (bmi < 15.9)
            context.resources.getString(R.string.Severely_Underweight)
        else if (bmi >= 16 && bmi < 18.4)
            context.resources.getString(R.string.Underweight)
        else if (bmi >= 18.5 && bmi < 24.9)
            context.resources.getString(R.string.Normal)
        else if (bmi >= 25 && bmi < 29.9)
            context.resources.getString(R.string.Overweight)
        else if (bmi >= 30 && bmi < 34.9)
            context.resources.getString(R.string.Obese_Class_1)
        else if (bmi >= 35 && bmi < 39.9)
            context.resources.getString(R.string.Obese_Class_2)
        else if (bmi >= 40)
            context.resources.getString(R.string.Obese_Class_3)
        else
            context.resources.getString(R.string.Normal)

    }

    private fun getColor(bmi: Int, context: Context): Int {
        return when {
            bmi < 20 -> context.resources.getColor(R.color.blue)
            bmi < 25 -> context.resources.getColor(R.color.green)
            bmi < 30 -> context.resources.getColor(R.color.yellow)
            else -> context.resources.getColor(R.color.red)
        }
    }
}