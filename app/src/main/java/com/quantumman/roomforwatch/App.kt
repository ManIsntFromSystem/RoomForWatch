package com.quantumman.roomforwatch

import android.app.Application
import android.util.Log
import com.quantumman.data.remote.helpers.DaggerNetworkComponent
import com.quantumman.roomforwatch.di.DaggerAppComponent

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    initDI()
  }

  private fun initDI() {
    DI.appComponent = DaggerAppComponent.builder()
      .appContext(this)
      .build()

    DI.networkComponent = DaggerNetworkComponent.create()
  }
}

  //    companion object {
//        lateinit var roomAppDatabase: RoomAppDatabase
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        roomAppDatabase = RoomAppDatabase.buildDataSource(context = applicationContext)
//    }