package com.ali.ayn.healthcare.activity.bmiSaved.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ali.ayn.healthcare.activity.bmiSaved.adapter.mvp.BmiSavedAdapterModel
import com.ali.ayn.healthcare.activity.bmiSaved.adapter.mvp.BmiSavedViewHolder
import com.ali.ayn.healthcare.base.BaseHolder
import com.ali.ayn.healthcare.base.BasePresenter
import java.util.*

abstract class RecyclerViewAdapter<M, P : BasePresenter<VH, M>, VH : BaseHolder<P>> :
    RecyclerView.Adapter<VH>() {

    var presenter: Map<Any, P>? = null
    var itemClickListener: ItemClickListener? = null

    init {
        presenter = HashMap()
    }

    fun getPresenter(m: M): P? {
        return presenter?.get(getModelId(m))
    }

    override fun onFailedToRecycleView(holder: VH): Boolean {
        holder.unbindPresenter()
        return super.onFailedToRecycleView(holder)
    }

    override fun onViewRecycled(holder: VH) {
        super.onViewRecycled(holder)
        holder.unbindPresenter()
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setPresenter(createPresenter(getItem(position)))
        val viewHolder = holder as BmiSavedViewHolder
        viewHolder.setData(getItem(position) as BmiSavedAdapterModel, itemClickListener)
    }

    protected abstract fun getModelId(model: M): Any

    protected abstract fun createPresenter(model: M): P

    protected abstract fun getItem(position: Int): M
}