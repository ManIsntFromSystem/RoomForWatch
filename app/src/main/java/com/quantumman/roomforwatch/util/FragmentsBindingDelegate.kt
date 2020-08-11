package com.quantumman.roomforwatch.util

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentsBindingDelegate<T: ViewBinding> (
  val fragment: Fragment,
  private val bindingFactory: (View) -> T
) :ReadOnlyProperty<Fragment, T> {

  private var binding: T? = null

  init {
    fragment.lifecycle.addObserver(object : LifecycleEventObserver {
      override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_CREATE) {
          fragment.viewLifecycleOwnerLiveData.observe(fragment, Observer { lifecycleOwner ->
            lifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {
              override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                if (event == Lifecycle.Event.ON_DESTROY) { binding = null }
              }
            })
          })
        }
      }
    })
  }

//  init {
//    fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
//      override fun onCreate(owner: LifecycleOwner) {
//        fragment.viewLifecycleOwnerLiveData.observe(fragment) { viewLifecycleOwner ->
//          viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
//            override fun onDestroy(owner: LifecycleOwner) {
//              binding = null
//            }
//          })
//        }
//      }
//    })
//  }

  override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
    val binding = binding
    if (binding != null) return binding
    val lifecycle = fragment.viewLifecycleOwner.lifecycle
    if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
      throw IllegalStateException("Should not initialize binding when Fragment views are destroyed")
    }

    return bindingFactory.invoke(thisRef.requireView())
      .also { this@FragmentsBindingDelegate.binding = it }
  }
}

fun <T: ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
  FragmentsBindingDelegate(
    this,
    viewBindingFactory
  )