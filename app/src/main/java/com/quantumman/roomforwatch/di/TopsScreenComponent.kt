package com.quantumman.roomforwatch.di

import androidx.lifecycle.ViewModel
import com.quantumman.data.db.dao.MovieDao
import com.quantumman.data.remote.services.MovieService
import com.quantumman.roomforwatch.DI
import com.quantumman.roomforwatch.interactors.main.TopScreenInteractor
import com.quantumman.roomforwatch.interactors.main.TopScreenInteractorImpl
import com.quantumman.roomforwatch.util.ResourceProvider
import com.quantumman.roomforwatch.vm.main.TopsMoviesViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@Component(modules = [TopsScreenModule::class])
@ScreenScope
interface TopsScreenComponent {

  fun viewModelFactory(): ViewModelFactory

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun resources(resourceProvider: ResourceProvider): Builder

    @BindsInstance
    fun api(service: MovieService): Builder

    @BindsInstance
    fun storage(movieDao: MovieDao): Builder

    fun build(): TopsScreenComponent
  }

  companion object {
    fun create() = with(DI.appComponent) {
      DaggerTopsScreenComponent.builder()
        .resources(resources())
        .api(DI.networkComponent.api())
        .storage(DI.storageComponent.movieDao())
        .build()
    }
  }
}

@Module
interface TopsScreenModule {
  @Binds
  @IntoMap
  @ViewModelKey(TopsMoviesViewModel::class)
  fun topsScreenViewModel(viewModel: TopsMoviesViewModel): ViewModel

  @Binds
  @ScreenScope
  fun topsScreenInteractor(interactor: TopScreenInteractorImpl): TopScreenInteractor
}
