package br.com.chucknorrisio.di.module

import br.com.chucknorrisio.ChuckActivity
import br.com.chucknorrisio.category.ChuckCategoryFragment
import br.com.chucknorrisio.category.di.CategoryModule
import br.com.chucknorrisio.detail.ChuckDetailFragment
import br.com.chucknorrisio.detail.di.DetailModule
import br.com.chucknorrisio.di.ChuckModule
import br.com.chucknorrisio.di.annotation.ActivityScope
import br.com.chucknorrisio.di.annotation.FragmentScope
import br.com.chucknorrisio.splash.SplashFragment
import br.com.chucknorrisio.splash.di.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [ChuckModule::class])
    abstract fun bindChuckActivity(): ChuckActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindSplashFragment(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [CategoryModule::class])
    abstract fun bindChuckCategoryFragment(): ChuckCategoryFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun bindChuckDetailFragment(): ChuckDetailFragment
}