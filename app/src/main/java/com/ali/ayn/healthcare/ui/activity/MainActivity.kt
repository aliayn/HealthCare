package com.ali.ayn.healthcare.ui.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.data.local.db.BMIDataBase
import com.ali.ayn.healthcare.helper.MainActivityDelegate
import com.ali.ayn.healthcare.helper.setupNavigation
import com.ali.ayn.healthcare.helper.setupToolbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainActivityDelegate {

    private var toggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
        setupToolbar()
        setupNavDrawer(toolbar_main)
    }

    override fun setupNavDrawer(toolbar: Toolbar) {
        toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ).apply {
            drawer_layout.addDrawerListener(this)
            syncState()
        }
    }

    override fun enableNavDrawer(enable: Boolean) {
        val lockMode = if (enable) DrawerLayout.LOCK_MODE_UNLOCKED
        else DrawerLayout.LOCK_MODE_LOCKED_CLOSED
        drawer_layout.setDrawerLockMode(lockMode)
        toggle?.isDrawerIndicatorEnabled = enable
    }

    override fun onDestroy() {
        BMIDataBase.destroyInstance()
        super.onDestroy()
    }
}