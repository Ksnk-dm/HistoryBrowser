package com.example.data.local.mapper

import com.example.data.local.db.model.BrowserHistoryEntity
import com.example.domain.model.local.BrowserHistory
import javax.inject.Inject

class BrowserHistoryLocalMapper @Inject constructor() {

    fun mapBrowserHistoryEntityToModel(entity: BrowserHistoryEntity): BrowserHistory =
        BrowserHistory(
            entity.url,
            entity.date,
            entity.browser
        ).apply { id = entity.id }

    fun mapBrowserHistoryModelToEntity(model: BrowserHistory): BrowserHistoryEntity =
        BrowserHistoryEntity(
            model.id,
            model.url,
            model.date,
            model.browser
        )
}