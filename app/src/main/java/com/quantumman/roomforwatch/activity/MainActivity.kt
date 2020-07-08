package com.quantumman.roomforwatch.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.quantumman.roomforwatch.R
import com.quantumman.roomforwatch.fragments.FavouritesMoviesFragment
import com.quantumman.roomforwatch.fragments.MapFragment
import com.quantumman.roomforwatch.fragments.TopsMoviesFragment
import com.quantumman.roomforwatch.fragments.UserFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ClassCastException

const val TAG_MAIN = "Main Activity TAG: "

class MainActivity : AppCompatActivity() {

    private lateinit var botNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botNavView = findViewById(R.id.bottom_navigation)

        if (savedInstanceState == null) loadFragments(TopsMoviesFragment())
        initNavigation()
    }

    private fun initNavigation() {
        botNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bot_nav_tops -> {
                    loadFragments(TopsMoviesFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bot_nav_maps -> {
                    loadFragments(MapFragment())
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
            it.replace(R.id.fragment_container, fragment)
            it.addToBackStack(null)
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