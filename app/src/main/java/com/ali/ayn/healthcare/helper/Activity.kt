package com.ali.ayn.healthcare.helper

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation

fun AppCompatActivity.findNavController(@IdRes resId: Int): NavController =
    Navigation.findNavController(this, resId)