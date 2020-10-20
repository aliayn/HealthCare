package com.ali.ayn.healthcare.base

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.ali.ayn.healthcare.helper.MainActivityDelegate

open class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    private var delegate: MainActivityDelegate? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate = context as MainActivityDelegate
    }

    fun setupNavDrawer(toolbar: Toolbar) {
        delegate?.setupNavDrawer(toolbar)
    }

    fun enableNavDrawer(enable: Boolean) {
        delegate?.enableNavDrawer(enable)
    }

}