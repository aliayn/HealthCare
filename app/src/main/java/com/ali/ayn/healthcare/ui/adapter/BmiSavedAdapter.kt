package com.ali.ayn.healthcare.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.data.local.entity.BMI
import com.ali.ayn.healthcare.helper.bmiDiffUtil
import kotlinx.android.synthetic.main.bmi_saved_recycler_layout.view.*
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.text.SimpleDateFormat
import java.util.*

class BmiSavedAdapter(private val callback: (BMI) -> Unit) :
    ListAdapter<BMI, BmiSavedAdapter.BMIViewHolder>(bmiDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BMIViewHolder {
        return BMIViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.bmi_saved_recycler_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BMIViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class BMIViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.img_bmi_saved_recycler
        private val txtResult: TextView = itemView.txt_bmi_result_recycler
        private val txtBmi: TextView = itemView.txt_bmi_saved_recycler
        private val txtDate: TextView = itemView.txt_bmi_time_recycler

        fun bind(model: BMI) {
            itemView.onClick { callback.invoke(model) }
            txtDate.text = model.time?.let { getDate(it) }
            txtResult.text = setDescription(model.bmi.toInt(), model.isMale, itemView.context)
            txtResult.setTextColor(getColor(model.bmi.toInt(), itemView.context))
            txtBmi.text = model.bmi.toString()
            if (!model.isMale) {
                imageView.imageResource = R.drawable.ic_woman
                txtDate.setBackgroundColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorPrimary
                    )
                )
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
                bmi < 20 -> ContextCompat.getColor(context, R.color.blue)
                bmi < 25 -> ContextCompat.getColor(context, R.color.green)
                bmi < 30 -> ContextCompat.getColor(context, R.color.yellow)
                else -> ContextCompat.getColor(context, R.color.red)
            }
        }
    }
}