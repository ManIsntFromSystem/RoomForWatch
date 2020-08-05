package com.quantumman.roomforwatch.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.quantumman.roomforwatch.model.base.ListItem

open class BaseDiffUtilItemCallBack : DiffUtil.ItemCallback<ListItem>() {
  override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
    return oldItem.itemId == newItem.itemId
  }



  @SuppressLint("DiffUtilEquals")
  override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
    return oldItem == newItem
  }
}