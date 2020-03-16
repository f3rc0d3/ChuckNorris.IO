package br.com.chucknorrisio.di.component

import br.com.chucknorrisio.ChuckNorrisApplication
import br.com.chucknorrisio.di.module.ActivityBindingModule
import br.com.chucknorrisio.di.module.ApplicationModule
import br.com.chucknorrisio.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<ChuckNorrisApplication> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<ChuckNorrisApplication>
}