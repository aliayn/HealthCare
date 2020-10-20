package com.ali.ayn.healthcare.helper

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ali.ayn.healthcare.R
import com.google.android.material.navigation.NavigationView

fun AppCompatActivity.setupNavigation() {
    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHostFragment.navController
    findViewById<NavigationView>(R.id.nav_view).setupWithNavController(navController)
    setNavigationFont()
}

fun AppCompatActivity.setupToolbar() {
    val toolbar = findViewById<Toolbar>(R.id.toolbar_main)
    val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayShowTitleEnabled(false)
    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHostFragment.navController
    toolbar.setupWithNavController(navController, drawerLayout)
}

private fun AppCompatActivity.setNavigationFont() {
    findViewById<NavigationView>(R.id.nav_view).setFont(this)
}