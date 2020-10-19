package com.ali.ayn.healthcare.activity.bmiSaved.adapter

import com.ali.ayn.healthcare.base.BaseHolder
import com.ali.ayn.healthcare.base.BasePresenter
import java.util.ArrayList

abstract class RecyclerViewList<M, P : BasePresenter<VH, M>, VH : BaseHolder<P>> : RecyclerViewAdapter<M, P, VH>() {

    var list: MutableList<M> = ArrayList()

    fun addItem(model: M) {
        this.list.add(model)
        notifyItemRangeInserted(list.size, 1)
    }

    fun addAll(data: Collection<M>) {
        for (model in data) {
            addItem(model)
        }
        val addSize = data.size
        val oldSize = list.size - addSize
        notifyItemRangeInserted(oldSize, addSize)
    }

    fun clear() {
        val size = this.list.size
        if (size > 0) {
            for (i in 0 until size) {
                this.list.removeAt(0)
            }
            this.notifyItemRangeRemoved(0, size)
        }

    }

    fun remove(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItem(position: Int): M {
        return list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}