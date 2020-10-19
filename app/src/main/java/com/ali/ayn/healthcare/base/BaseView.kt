package com.ali.ayn.healthcare.base

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout

@SuppressLint("ViewConstructor")
open class BaseView(context: Context, layout: Int) : FrameLayout(context) {

    init {
        LayoutInflater.from(context).inflate(layout, this)
    }
}
