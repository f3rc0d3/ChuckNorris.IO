package br.com.chucknorrisio.category.di

import androidx.lifecycle.ViewModel
import br.com.chucknorrisio.category.ChuckCategoryViewModel
import br.com.chucknorrisio.category.data.RemoteDataSourceModule
import br.com.chucknorrisio.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [RemoteDataSourceModule::class])
abstract class CategoryModule {
    @Binds
    @IntoMap
    @ViewModelKey(ChuckCategoryViewModel::class)
    abstract fun provideChuckCategoryViewModel(viewModel: ChuckCategoryViewModel): ViewModel
}