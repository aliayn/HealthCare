package com.ali.ayn.healthcare.activity.main

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.view.MenuItem
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseView
import com.ali.ayn.healthcare.custom.CustomTypefaceSpan
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainView(context: Context) : BaseView(context, R.layout.activity_main) {

    fun initViews(presenter: MainPresenter) {
       /* btn_navigation.onClick { *//*drawer_layout.openDrawer(Gravity.START, true)*//* }
        relative_main_height.onClick { presenter.heightActivity(context) }
        relative_main_bmi.onClick { presenter.bmiActivity(context) }*/
        nav_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bmi_saved -> presenter.bmiSavedActivity(context)
            };false
        }

        val m = nav_view.menu
        for (i in 0 until m.size()) {
            val mi = m.getItem(i)

            val subMenu = mi.subMenu
            if (subMenu != null && subMenu.size() > 0) {
                for (j in 0 until subMenu.size()) {
                    val subMenuItem = subMenu.getItem(j)
                    applyFontToMenuItem(subMenuItem)
                }
            }
            applyFontToMenuItem(mi)
        }
    }

    fun checkTapTarget(presenter: MainPresenter) {
       // presenter.checkFirstLogin(relative_main_height, relative_main_bmi, btn_navigation, context)
    }

    private fun applyFontToMenuItem(mi: MenuItem) {
        val font = Typeface.createFromAsset(context.assets, "fonts/b_yekan.ttf")
        val mNewTitle = SpannableString(mi.title)
        mNewTitle.setSpan(
            CustomTypefaceSpan("", font),
            0,
            mNewTitle.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        mi.title = mNewTitle
    }

}