package com.example.historybrowser.di.module

import com.example.feature.di.scope.ServiceScope
import com.example.historybrowser.services.AppAccessibilityService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBuilderModule {
    @ServiceScope
    @ContributesAndroidInjector
    abstract fun createAccessibilityService(): AppAccessibilityService

}