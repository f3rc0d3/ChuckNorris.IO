package br.com.chucknorrisio.detail.di

import androidx.lifecycle.ViewModel
import br.com.chucknorrisio.category.ChuckCategoryViewModel
import br.com.chucknorrisio.detail.ChuckDetailViewModel
import br.com.chucknorrisio.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailModule {
    @Binds
    @IntoMap
    @ViewModelKey(ChuckDetailViewModel::class)
    abstract fun provideChuckDetailViewModel(viewModel: ChuckDetailViewModel): ViewModel
}