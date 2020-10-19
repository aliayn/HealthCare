package com.ali.ayn.healthcare.helper

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation

fun AppCompatActivity.initToolbar(toolbar: Toolbar, backEnabled: Boolean) {
    setSupportActionBar(toolbar)
    supportActionBar?.title = ""
    supportActionBar?.setDisplayHomeAsUpEnabled(backEnabled)
}

fun AppCompatActivity.findNavController(@IdRes resId: Int): NavController =
    Navigation.findNavController(this, resId)

fun AppCompatActivity.navigate(@IdRes resId: Int): Unit =
    findNavController(resId).navigate(resId)

fun AppCompatActivity.navigate(@IdRes resId: Int, @Nullable bundle: Bundle): Unit =
    findNavController(resId).navigate(resId, bundle)