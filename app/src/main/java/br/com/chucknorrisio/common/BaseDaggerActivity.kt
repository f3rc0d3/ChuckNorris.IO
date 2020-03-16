package br.com.chucknorrisio.common

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseDaggerActivity
@JvmOverloads
constructor(@LayoutRes layout: Int = 0) : BaseActivity(layout), HasAndroidInjector {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    protected inline fun <reified T : ViewModel> viewModels(): Lazy<T> {
        return viewModels { factory }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}