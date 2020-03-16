package br.com.chucknorrisio.splash.di

import androidx.lifecycle.ViewModel
import br.com.chucknorrisio.category.ChuckCategoryViewModel
import br.com.chucknorrisio.di.annotation.ViewModelKey
import br.com.chucknorrisio.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun provideSplashViewModel(viewModel: SplashViewModel): ViewModel
}