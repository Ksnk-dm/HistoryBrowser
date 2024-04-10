package com.example.feature.ext

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single

fun <T> Observable<T>.withSchedulers(observeOn: Scheduler, subscribeOn: Scheduler): Observable<T> =
    observeOn(observeOn).subscribeOn(subscribeOn)

fun <T> Flowable<T>.withSchedulers(observeOn: Scheduler, subscribeOn: Scheduler): Flowable<T> =
    observeOn(observeOn).subscribeOn(subscribeOn)

fun <T> Single<T>.withSchedulers(observeOn: Scheduler, subscribeOn: Scheduler): Single<T> =
    observeOn(observeOn).subscribeOn(subscribeOn)

fun Completable.withSchedulers(observeOn: Scheduler, subscribeOn: Scheduler): Completable =
    observeOn(observeOn).subscribeOn(subscribeOn)

fun <T> Flowable<T>.withDoOnFirst(action: (T) -> Unit): Flowable<T> =
    this.take(1).doOnNext(action).concatWith(this)