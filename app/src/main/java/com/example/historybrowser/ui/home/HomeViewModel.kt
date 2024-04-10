package com.example.historybrowser.ui.home

import androidx.lifecycle.ViewModel
import com.example.domain.local.LocalRepository
import com.example.domain.model.local.BrowserHistory
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val localRepository: LocalRepository): ViewModel() {
     val compositeDisposable = CompositeDisposable()

    fun getBrowserHistories(): Flowable<List<BrowserHistory>> {
        return localRepository.getBrowserHistories()

    }


}