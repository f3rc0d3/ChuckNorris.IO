package br.com.chucknorrisio.category.data

import br.com.chucknorrisio.category.data.datasource.CategoryDataSource
import br.com.chucknorrisio.category.data.datasource.CategoryRemoteDataSource
import br.com.chucknorrisio.category.data.rest.CategoryRestService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataSourceModule {
    @Provides
    @Singleton
    fun provideCategoryRemoteDataSource(categoryRestService: CategoryRestService): CategoryDataSource =
        CategoryRemoteDataSource(categoryRestService)
}