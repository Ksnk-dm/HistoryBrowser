package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.Database
import com.example.data.local.repository.LocalRepositoryImpl
import com.example.data.manager.AppAccessibilityServiceManagerImpl
import com.example.data.sensor.browser.ChromeBrowserAccessibilitySensorImpl
import com.example.data.sensor.browser.MozillaBrowserAccessibilityImpl
import com.example.data.sensor.browser.SamsungBrowserAccessibilityImpl
import com.example.domain.local.LocalRepository
import com.example.domain.manager.AppAccessibilityServiceManager
import com.example.domain.sensor.accessibility.browsers.ChromeBrowserAccessibilitySensor
import com.example.domain.sensor.accessibility.browsers.MozillaBrowserAccessibilitySensor
import com.example.domain.sensor.accessibility.browsers.SamsungBrowserAccessibilitySensor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): Database =
        Room.databaseBuilder(context, Database::class.java, "database.db")
            .build()

    @Provides
    @Singleton
    fun provideLocalRepository(repositoryImpl: LocalRepositoryImpl): LocalRepository =
        repositoryImpl

    @Provides
    @Singleton
    fun provideAppAccessibilityServiceManager(appAccessibilityServiceManager: AppAccessibilityServiceManagerImpl): AppAccessibilityServiceManager =
        appAccessibilityServiceManager


    @Provides
    @Singleton
    fun provideChromeBrowserAccessibilitySensor(sensorImpl: ChromeBrowserAccessibilitySensorImpl): ChromeBrowserAccessibilitySensor =
        sensorImpl

    @Provides
    @Singleton
    fun provideSamsungBrowserAccessibilitySensor(sensorImpl: SamsungBrowserAccessibilityImpl): SamsungBrowserAccessibilitySensor =
        sensorImpl

    @Provides
    @Singleton
    fun provideMozillaBrowserAccessibilitySensor(sensorImpl: MozillaBrowserAccessibilityImpl): MozillaBrowserAccessibilitySensor =
        sensorImpl
}