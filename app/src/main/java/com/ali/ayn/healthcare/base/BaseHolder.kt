package com.ali.ayn.healthcare.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseHolder<P : BasePresenter<*, *>>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var presenter: P? = null

    fun setPresenter(presenter: P) {
        this.presenter = presenter
    }

    fun unbindPresenter() {
        presenter = null
    }
}