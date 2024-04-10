package com.example.historybrowser.di.module

import com.example.feature.di.scope.ActivityScope
import com.example.historybrowser.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            FragmentBuilderModule::class,
        ]
    )
    abstract fun createMainActivityInjector(): MainActivity
}