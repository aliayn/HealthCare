package com.ali.ayn.healthcare.helper

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView

fun NavigationView.setFont(context: Context) {
    val m = menu
    for (i in 0 until m.size()) {
        val mi = m.getItem(i)

        val subMenu = mi.subMenu
        if (subMenu != null && subMenu.size() > 0) {
            for (j in 0 until subMenu.size()) {
                val subMenuItem = subMenu.getItem(j)
                applyFontToMenuItem(context,subMenuItem)
            }
        }
        applyFontToMenuItem(context, mi)
    }
}

private fun applyFontToMenuItem(context: Context, mi: MenuItem) {
    val font = Typeface.createFromAsset(context.assets, "fonts/iransans_mobile_fanum_light.ttf")
    val mNewTitle = SpannableString(mi.title)
    mNewTitle.setSpan(
        CustomTypefaceSpan("", font),
        0,
        mNewTitle.length,
        Spannable.SPAN_INCLUSIVE_INCLUSIVE
    )
    mi.title = mNewTitle
}