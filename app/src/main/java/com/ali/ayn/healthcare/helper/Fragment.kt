package com.ali.ayn.healthcare.helper

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

fun Fragment.initToolbar(toolbar: Toolbar, title: String, backEnabled: Boolean) {
    val appCompatActivity = activity as AppCompatActivity
    appCompatActivity.setSupportActionBar(toolbar)
    appCompatActivity.supportActionBar?.title = title
    appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(backEnabled)
}

fun Fragment.findNavController(): NavController =
    NavHostFragment.findNavController(this)

fun Fragment.navigate(@IdRes resId: Int): Unit =
    findNavController().navigate(resId)

fun Fragment.navigate(@IdRes resId: Int, bundle: Bundle): Unit =
    findNavController().navigate(resId, bundle)