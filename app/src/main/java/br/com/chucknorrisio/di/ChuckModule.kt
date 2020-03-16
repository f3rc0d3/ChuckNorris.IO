package br.com.chucknorrisio.di

import androidx.lifecycle.ViewModel
import br.com.chucknorrisio.ChuckViewModel
import br.com.chucknorrisio.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ChuckModule {
    @Binds
    @IntoMap
    @ViewModelKey(ChuckViewModel::class)
    abstract fun provideChuckViewModel(viewModel: ChuckViewModel): ViewModel
}