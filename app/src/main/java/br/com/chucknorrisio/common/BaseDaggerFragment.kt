package br.com.chucknorrisio.common

import android.content.Context
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.MainThread
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseDaggerFragment
@JvmOverloads
constructor(@LayoutRes layout: Int = 0) : BaseFragment(layout), HasAndroidInjector {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @MainThread
    protected inline fun <reified T : ViewModel> viewModels(): Lazy<T> {
        return viewModels { factory }
    }

    @MainThread
    protected inline fun <reified T : ViewModel> activityViewModels(): Lazy<T> {
        return activityViewModels { factory }
    }

    @MainThread
    protected inline fun <reified T : ViewModel> graphViewModels(@IdRes navGraphId: Int): Lazy<T> {
        return navGraphViewModels(navGraphId) { factory }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}