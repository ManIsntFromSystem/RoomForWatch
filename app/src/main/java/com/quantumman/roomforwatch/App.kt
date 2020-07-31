package com.quantumman.roomforwatch

import android.app.Application
import com.quantumman.data.db.DaggerStorageComponent
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

    DI.storageComponent = DaggerStorageComponent.builder()
      .appContext(this)
      .build()
  }
}