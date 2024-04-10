package com.example.domain.local.repository

import com.example.domain.model.local.BrowserHistory
import io.reactivex.Completable
import io.reactivex.Flowable

interface BrowserHistoryLocalProvider {

    fun saveBrowserHistories(histories: List<BrowserHistory>): Completable

    fun updateBrowserHistories(histories: BrowserHistory): Completable

    fun getBrowserHistories(): Flowable<List<BrowserHistory>>

    fun deleteBrowserHistory(id: Long): Completable
}