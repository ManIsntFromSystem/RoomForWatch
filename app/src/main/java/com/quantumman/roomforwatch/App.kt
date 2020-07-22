package com.quantumman.roomforwatch

import android.app.Application
import com.quantumman.roomforwatch.delegates.DaggerAppComponent

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    initDI()
  }

  private fun initDI() {
    DI.appComponent = DaggerAppComponent.builder().appContext(this).build()
  }

  //    companion object {
//        lateinit var roomAppDatabase: RoomAppDatabase
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        roomAppDatabase = RoomAppDatabase.buildDataSource(context = applicationContext)
//    }
}