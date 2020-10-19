package com.ali.ayn.healthcare.base

import java.lang.ref.WeakReference

abstract class BasePresenterK<V, M> constructor(model: M) {

    private var model : M? = null
    private var view: WeakReference<V>? = null

    init {
        setModel(model)
    }

    private fun setModel(model: M){
        this.model = model
        if (setup())
            start()
    }

    private fun bindView(view: V) {
        this.view = WeakReference(view)
        if (setup()) {
            start()
        }
    }

    private fun unBindView() {
        this.view = null
        System.gc()
    }

    fun getView() : V{
         return if (view == null){
            null!!
        }else{
             view!!.get()!!
        }
    }

    private fun setup(): Boolean {
        return model != null && view != null
    }

    fun onCreate(view: V) {
        bindView(view)
    }

    fun onDestroyed() {
        unBindView()
    }

    protected abstract fun start()

    protected abstract fun resume()
}