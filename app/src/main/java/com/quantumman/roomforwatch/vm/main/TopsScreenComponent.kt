package com.quantumman.roomforwatch.vm.main

import androidx.lifecycle.ViewModel
import com.quantumman.roomforwatch.di.ScreenScope
import com.quantumman.roomforwatch.di.ViewModelFactory
import com.quantumman.roomforwatch.di.ViewModelKey
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@Component(modules = [TopsScreenModule::class])
@ScreenScope
interface TopsScreenComponent {

  fun viewModelFactory(): ViewModelFactory
}

@Module
abstract class TopsScreenModule {
  @Binds
  @IntoMap
  @ViewModelKey(TopsMoviesViewModel::class)
  abstract fun topsMoviesViewModel(viewModel: TopsMoviesViewModel): ViewModel
}
