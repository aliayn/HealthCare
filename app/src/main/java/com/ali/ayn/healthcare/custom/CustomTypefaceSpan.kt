package com.ali.ayn.healthcare.custom

import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextPaint
import android.text.style.TypefaceSpan
import androidx.annotation.NonNull

class CustomTypefaceSpan(family: String?, private val type: Typeface) : TypefaceSpan(family) {

    override fun updateDrawState(@NonNull ds: TextPaint) {
        applyCustomTypeFace(ds, type)
    }

    override fun updateMeasureState(@NonNull paint: TextPaint) {
        applyCustomTypeFace(paint, type)
    }

    private fun applyCustomTypeFace(paint: Paint, tf: Typeface) {
        val oldStyle: Int
        val old = paint.typeface
        oldStyle = old?.style ?: 0

        val fake = oldStyle and tf.style.inv()
        if (fake and Typeface.BOLD != 0) {
            paint.isFakeBoldText = true
        }

        if (fake and Typeface.ITALIC != 0) {
            paint.textSkewX = -0.25f
        }

        paint.typeface = tf
    }
}