package com.ali.ayn.healthcare.helper

import androidx.recyclerview.widget.DiffUtil
import com.ali.ayn.healthcare.data.local.entity.BMI

val bmiDiffUtil by lazy {
    object : DiffUtil.ItemCallback<BMI>() {

        override fun areItemsTheSame(oldItem: BMI, newItem: BMI): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: BMI, newItem: BMI): Boolean =
            oldItem == newItem
    }
}
