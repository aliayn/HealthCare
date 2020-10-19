package com.ali.ayn.healthcare.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<V : BaseView, P : BasePresenter<V, *>> : AppCompatActivity() {


    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        setPresenter()
        super.onCreate(savedInstanceState)
        val view = view
        setContentView(view)
        presenter.onCreate(view)
    }

    override fun onResume() {
        super.onResume()
        fa = activity
        presenter.resume()

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroyed()
    }

    abstract val view: V

    abstract fun setPresenter()

    abstract val activity: Activity

    companion object {

        @SuppressLint("StaticFieldLeak")
        private lateinit var fa: Activity

        fun getFa(): Activity? {
            return fa
        }

        fun start(context: Context, cls: Class<*>?) {
            val myIntent = Intent(context, cls)
            myIntent.addFlags(FLAG_ACTIVITY_SINGLE_TOP or FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(myIntent)
        }

        fun start(context: Context, bmi: Int, isSaved: Boolean, isMale: Boolean, cls: Class<*>) {
            val myIntent = Intent(context, cls)
            myIntent.addFlags(FLAG_ACTIVITY_SINGLE_TOP or FLAG_ACTIVITY_NEW_TASK)
            myIntent.putExtra("bmi", bmi)
            myIntent.putExtra("isSaved", isSaved)
            myIntent.putExtra("isMale", isMale)
            context.startActivity(myIntent)
        }

        fun start(
            context: Context,
            bmi: Int,
            isSaved: Boolean,
            time: Long,
            isMale: Boolean,
            cls: Class<*>
        ) {
            val myIntent = Intent(context, cls)
            myIntent.addFlags(FLAG_ACTIVITY_SINGLE_TOP or FLAG_ACTIVITY_NEW_TASK)
            myIntent.putExtra("bmi", bmi)
            myIntent.putExtra("isSaved", isSaved)
            myIntent.putExtra("time", time)
            myIntent.putExtra("isMale", isMale)
            context.startActivity(myIntent)
        }

        fun start(context: Context, height: Double, isBoy: Boolean, cls: Class<*>) {
            val myIntent = Intent(context, cls)
            myIntent.addFlags(FLAG_ACTIVITY_SINGLE_TOP or FLAG_ACTIVITY_NEW_TASK)
            myIntent.putExtra("height", height)
            myIntent.putExtra("isBoy", isBoy)
            context.startActivity(myIntent)
        }
    }
}