package com.example.historybrowser.ui.home

import androidx.lifecycle.ViewModel
import com.example.domain.local.LocalRepository
import com.example.domain.model.local.BrowserHistory
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val localRepository: LocalRepository) : ViewModel() {

    fun getBrowserHistories(): Flowable<List<BrowserHistory>> =
        localRepository.getBrowserHistories()

    fun removeBrowserHistory(id: Long): Completable =
        localRepository.deleteBrowserHistory(id)
}