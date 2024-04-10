package com.example.historybrowser.di.module

import com.example.feature.di.scope.FragmentScope
import com.example.historybrowser.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun createHomeFragmentInjector(): HomeFragment
}