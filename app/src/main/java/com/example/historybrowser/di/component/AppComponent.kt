package com.example.historybrowser.di.component

import android.app.Application
import android.content.Context
import com.example.data.di.DataModule
import com.example.historybrowser.App
import com.example.historybrowser.di.module.ServiceBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ServiceBuilderModule::class,
        DataModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun appContext(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}