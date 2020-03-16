package br.com.chucknorrisio

import android.app.Application
import br.com.chucknorrisio.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class ChuckNorrisApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent
            .factory()
            .create(this)
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}