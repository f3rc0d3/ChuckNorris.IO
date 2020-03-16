package br.com.chucknorrisio.di.module

import androidx.lifecycle.ViewModelProvider
import br.com.chucknorrisio.common.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}