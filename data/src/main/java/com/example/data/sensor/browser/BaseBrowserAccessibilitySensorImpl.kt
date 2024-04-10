package com.example.data.sensor.browser

import android.annotation.SuppressLint
import com.example.domain.local.LocalRepository
import com.example.domain.model.local.BrowserHistory
import com.example.domain.sensor.accessibility.browsers.BrowserAccessibilitySensor
import com.example.feature.ext.withSchedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

abstract class BaseBrowserAccessibilitySensorImpl(private val localRepository: LocalRepository) :
    BrowserAccessibilitySensor {

    @SuppressLint("CheckResult")
    fun saveBrowserHistory(url: String, browser: BrowserHistory.Browser) {
        runCatching {
            if (url.contains("google.com")) {
                val startIndex = url.indexOf("q=") + 2
                val endIndex = url.indexOf("&", startIndex)
                val searchText = url.substring(startIndex, endIndex)
                localRepository.saveBrowserHistories(
                    listOf(
                        BrowserHistory(
                            url,
                            searchText,
                            System.currentTimeMillis(),
                            browser
                        )
                    )
                ).withSchedulers(AndroidSchedulers.mainThread(), Schedulers.io())
                    .subscribeBy(onComplete = {  })
            }
        }.onFailure {Timber.e(it) }
    }
}