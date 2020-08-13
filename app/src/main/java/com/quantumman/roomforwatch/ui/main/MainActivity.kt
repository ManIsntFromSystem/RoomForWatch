package com.quantumman.roomforwatch.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.quantumman.roomforwatch.R

class MainActivity : AppCompatActivity() {

  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    if (savedInstanceState == null)
      startNavigation()
  }

  override fun onRestoreInstanceState(savedInstanceState: Bundle) {
    super.onRestoreInstanceState(savedInstanceState)
    startNavigation()
  }

  override fun onSupportNavigateUp() = NavigationUI.navigateUp(navController, null)

  private fun startNavigation() {
      val botNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
      navController = findNavController(this, R.id.nav_host_fragment)
      botNavView.setupWithNavController(navController)
  }
}

//old method
/**
 *     private fun initNavigation() {
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
it.replace(R.id.nav_host_fragment, fragment)
it.commit()
}
}
 */
