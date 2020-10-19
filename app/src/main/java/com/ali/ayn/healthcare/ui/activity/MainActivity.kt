package com.ali.ayn.healthcare.ui.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import com.ali.ayn.healthcare.R
import com.ali.ayn.healthcare.helper.MainActivityDelegate
import com.ali.ayn.healthcare.helper.setFont
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainActivityDelegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setFont(this)
    }

    override fun onSupportNavigateUp(): Boolean =
        findNavController(R.id.nav_host_fragment).navigateUp()

    override fun setupNavDrawer(toolbar: Toolbar) {
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }
}