package com.example.historybrowser.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.feature.di.viewModel.SimpleViewModelProviderFactory
import com.example.feature.di.viewModel.viewModel
import com.example.feature.ext.unsafeLazy
import com.example.feature.ext.withSchedulers
import com.example.feature.util.Injectable
import com.example.historybrowser.R
import com.example.historybrowser.databinding.FragmentHomeBinding
import com.example.historybrowser.ui.home.adapter.HomeAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Provider


class HomeFragment : Fragment(R.layout.fragment_home), Injectable {

    private val viewBinding by viewBinding(FragmentHomeBinding::bind)

    @Inject
    lateinit var viewModelProvider: Provider<HomeViewModel>

    private val viewModel by unsafeLazy {
        viewModel<HomeViewModel>(SimpleViewModelProviderFactory(viewModelProvider))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(viewBinding) {
            viewModel.getBrowserHistories()
                .withSchedulers(AndroidSchedulers.mainThread(), Schedulers.io())
                .subscribeBy(onComplete = {}, onNext = { list->
                    recyclerViewHome.adapter = HomeAdapter(list)
                    recyclerViewHome.layoutManager = GridLayoutManager(context, 1, RecyclerView.VERTICAL, false)

                    Log.d("MESSAGE::: ", list.toString())})
        }
    }
}