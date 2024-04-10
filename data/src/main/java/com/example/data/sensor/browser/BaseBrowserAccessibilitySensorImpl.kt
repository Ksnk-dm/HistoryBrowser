package com.example.data.sensor.browser

import com.example.domain.local.LocalRepository
import com.example.domain.model.local.BrowserHistory
import com.example.domain.sensor.accessibility.browsers.BrowserAccessibilitySensor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.feature.ext.withSchedulers

abstract class BaseBrowserAccessibilitySensorImpl(private val localRepository: LocalRepository) :
    BrowserAccessibilitySensor {


    fun saveBrowserHistory(url: String) {
        localRepository.saveBrowserHistories(
            listOf(BrowserHistory(url, System.currentTimeMillis().toLong(), "test"))
        ).withSchedulers(AndroidSchedulers.mainThread(), Schedulers.io())
    }
}