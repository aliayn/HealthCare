package com.ali.ayn.healthcare.ui.fragment

import android.os.Bundle
import android.view.View
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.base.BaseFragment
import com.ali.ayn.healthcare.helper.HEIGHT
import com.ali.ayn.healthcare.helper.IS_BOY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.height_result_fragment.*
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.share

@AndroidEntryPoint
class HeightResultFragment : BaseFragment(R.layout.height_result_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = context ?: return

        val height = arguments?.getLong(HEIGHT)
        val isBoy = arguments?.getBoolean(IS_BOY)

        txt_height_result.text =
            String.format("%s %s", height.toString(), context.resources.getString(R.string.cm))
        isBoy?.let { value -> setPhoto(value) }
        btn_share_result.onClick { shareData(height.toString()) }
    }

    private fun setPhoto(isBoy: Boolean) {
        if (isBoy) {
            image_height_result.imageResource = R.drawable.boy
        } else {
            image_height_result.imageResource = R.drawable.girl
        }
    }

    private fun shareData(height: String) {
        val shareBody = (resources.getString(R.string.your_Childs_Adulthood_height)
                + " : $height " + resources.getString(R.string.cm))
        share(shareBody, resources.getString(R.string.share_main))
    }
}