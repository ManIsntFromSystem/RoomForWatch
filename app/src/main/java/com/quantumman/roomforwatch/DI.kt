package com.quantumman.roomforwatch

import com.quantumman.data.db.StorageComponent
import com.quantumman.data.remote.helpers.NetworkComponent
import com.quantumman.roomforwatch.di.AppComponent

object DI {
  lateinit var appComponent: AppComponent
  internal set

  lateinit var networkComponent: NetworkComponent
    internal set

  lateinit var storageComponent: StorageComponent
    internal set
}