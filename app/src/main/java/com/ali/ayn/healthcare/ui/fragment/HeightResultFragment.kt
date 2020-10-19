package com.ali.ayn.healthcare.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.helper.HEIGHT
import com.ali.ayn.healthcare.helper.IS_BOY
import com.ali.ayn.healthcare.helper.initToolbar
import com.ali.ayn.healthcare.viewmodel.HeightViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.height_result_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.share

@AndroidEntryPoint
class HeightResultFragment : Fragment(R.layout.height_result_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = context ?: return

        initToolbar(toolbar, resources.getString(R.string.txt_main_height_result), true)

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