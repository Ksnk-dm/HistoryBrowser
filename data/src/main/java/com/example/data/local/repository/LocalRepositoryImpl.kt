package com.example.data.local.repository

import com.example.data.local.LocalDatabase
import com.example.data.local.mapper.BrowserHistoryLocalMapper
import com.example.domain.local.LocalRepository
import com.example.domain.model.local.BrowserHistory
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val db: LocalDatabase,
    private val browserHistoryLocalMapper: BrowserHistoryLocalMapper
): LocalRepository {

    override fun saveBrowserHistories(histories: List<BrowserHistory>): Completable =
        db.browserHistoryDao.insert(histories.map { browserHistoryLocalMapper.mapBrowserHistoryModelToEntity(it) })

    override fun updateBrowserHistories(histories: BrowserHistory): Completable =
        db.browserHistoryDao.update(browserHistoryLocalMapper.mapBrowserHistoryModelToEntity(histories))


    override fun getBrowserHistories(): Flowable<List<BrowserHistory>> = db.browserHistoryDao.selectBrowserBookmarks()
        .map { list -> list.map { browserHistoryLocalMapper.mapBrowserHistoryEntityToModel(it) } }
}