package com.yeminnaing.drawerlayout

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.drawer_open, R.string.drawer_close
        )
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
        btnStop.setOnClickListener {
            swlMain.isRefreshing=false
        }

    }

    override fun onBackPressed() {
        when {
            drawerLayout.isDrawerOpen(GravityCompat.START) -> {
                drawerLayout.closeDrawer(GravityCompat.START)

            }
            else -> {
                super.onBackPressed()
            }
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {
                Toast.makeText(this, "This is a camera navigation", Toast.LENGTH_SHORT).show()
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            R.id.nav_gallery -> {
                Toast.makeText(this, "This is a gallery navigation", Toast.LENGTH_SHORT).show()

            }
            R.id.nav_slideShow -> {
                Toast.makeText(this, "This is a slideShow navigation", Toast.LENGTH_SHORT).show()

            }
            R.id.nav_manage -> {
                Toast.makeText(this, "This is a Mange navigation", Toast.LENGTH_SHORT).show()

            }
        }

        return true
    }


}