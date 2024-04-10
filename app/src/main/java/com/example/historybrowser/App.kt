package com.example.historybrowser

import android.app.Application
import com.example.feature.util.AppInjector
import com.example.historybrowser.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this@App) {
            DaggerAppComponent.builder()
                .application(this)
                .appContext(this)
                .build()
                .inject(this)
        }
    }
}