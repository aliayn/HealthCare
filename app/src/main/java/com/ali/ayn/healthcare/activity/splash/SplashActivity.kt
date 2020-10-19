package com.ali.ayn.healthcare.activity.splash

import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.ali.ayn.healthcare.BuildConfig
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.activity.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        choose()
    }

    private fun choose() {
        val animation = AnimationUtils.loadAnimation(
            this,
            R.anim.splash_txt_version
        )
        txt_splash_version.text =
            String.format("%s %s", resources.getString(R.string.version), BuildConfig.VERSION_NAME)
        txt_splash_version.animation = animation
        next()
    }

    private fun next() {
        Handler().postDelayed({
            MainActivity.start(this@SplashActivity)
            finish()
        }, 1700)
    }
}