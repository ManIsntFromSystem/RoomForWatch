package com.quantumman.roomforwatch.util

import android.content.Context
import javax.inject.Inject

class AndroidResourceProvider @Inject constructor(private val context: Context) : ResourceProvider {
  override fun string(id: Int): String = context.resources.getString(id)
}