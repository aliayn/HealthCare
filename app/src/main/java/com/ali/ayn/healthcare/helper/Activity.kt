package com.ali.ayn.healthcare.helper

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.ali.ayn.healthcare.R
import com.google.android.material.navigation.NavigationView

fun AppCompatActivity.setNavControllerForNavigation() {
    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHostFragment.navController
    findViewById<NavigationView>(R.id.nav_view).setupWithNavController(navController)
}

fun AppCompatActivity.setNavControllerForToolbar() {
    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHostFragment.navController
    val appBarConfiguration = AppBarConfiguration(navController.graph)
    findViewById<Toolbar>(R.id.toolbar_main)
        .setupWithNavController(navController, appBarConfiguration)
}

fun AppCompatActivity.setNavigationFont() {
    findViewById<NavigationView>(R.id.nav_view).setFont(this)
}