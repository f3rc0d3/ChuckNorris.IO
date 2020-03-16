package br.com.chucknorrisio.di.module

import android.content.Context
import br.com.chucknorrisio.ChuckNorrisApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule {
    @Provides
    @Singleton
    fun provideContext(application: ChuckNorrisApplication): Context =
        application.applicationContext
}