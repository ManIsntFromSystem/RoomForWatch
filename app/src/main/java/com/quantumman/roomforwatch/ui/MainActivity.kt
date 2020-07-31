package com.quantumman.roomforwatch.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.arch.core.util.Function
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.ui.fragments.FavouritesMoviesFragment
import com.quantumman.roomforwatch.ui.fragments.UserFragment
import com.quantumman.roomforwatch.ui.main.TopsMoviesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var botNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botNavView = findViewById(R.id.bottom_navigation)

        if (savedInstanceState == null)
            loadFragments(TopsMoviesFragment())
        initNavigation()
    }

    private fun initNavigation() {
        botNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bot_nav_tops -> {
                    loadFragments(TopsMoviesFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bot_nav_favourites -> {
                    loadFragments(FavouritesMoviesFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bot_nav_user -> {
                    loadFragments(UserFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> throw ClassCastException ("Unknown class")
            }
        }
    }

    private fun loadFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().also {
            println("loadFragments future from Main")
            it.replace(R.id.nav_host_fragment, fragment)
            it.commit()
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return findNavController(this@MainActivity, R.id.nav_host_fragment).navigateUp()
//    }
//
//    private fun startNavigation() {
//        val navControl = findNavController(this@MainActivity, R.id.nav_host_fragment)
//        botNavView.setupWithNavController(navController = navControl)
//    }
}