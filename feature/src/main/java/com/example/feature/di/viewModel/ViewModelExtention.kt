package com.example.feature.di.viewModel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

inline fun <reified T : ViewModel> Fragment.viewModel(factory: ViewModelProvider.Factory) =
    ViewModelProvider(this, factory)[T::class.java]

inline fun <reified T : ViewModel> Fragment.sharedViewModel(
    owner: ViewModelStoreOwner,
    factory: ViewModelProvider.Factory
) = ViewModelProvider(owner, factory)[T::class.java]

inline fun <reified T : ViewModel> FragmentActivity.viewModel(factory: ViewModelProvider.Factory) =
    ViewModelProvider(this, factory)[T::class.java]