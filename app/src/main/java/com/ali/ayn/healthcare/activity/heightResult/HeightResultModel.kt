package com.ali.ayn.healthcare.activity.heightResult

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.widget.ImageButton
import android.widget.TextView
import com.ali.ayn.healthcare.R
import com.facebook.drawee.view.SimpleDraweeView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.share
import javax.inject.Inject

class HeightResultModel @Inject constructor() {

    private var height: Double = 0.toDouble()
    private var isBoy: Boolean = false

    fun setIntent(intent: Intent) {
        height = intent.getDoubleExtra("height", 0.0)
        isBoy = intent.getBooleanExtra("isBoy", true)
    }

    fun initView(imageView: SimpleDraweeView, textView: TextView, context: Context, imageButton: ImageButton) {
        textView.text = String.format("%s %s", height.toString(), context.resources.getString(R.string.cm))
        imageButton.onClick { shareData(context) }
        setPhoto(imageView)
    }

    private fun shareData(context: Context) {
        val shareBody = (context.resources.getString(R.string.your_Childs_Adulthood_height)
                + " : " + height + " " + context.resources.getString(R.string.cm))
        context.share(shareBody,context.resources.getString(R.string.share_main))
    }

    private fun setPhoto(imageView: SimpleDraweeView) {
        if (isBoy) {
            imageView.imageResource = R.drawable.boy
        } else {
            imageView.imageResource = R.drawable.girl
        }
    }

    fun finish() {
        HeightResultActivity.fa()?.finish()
    }
}