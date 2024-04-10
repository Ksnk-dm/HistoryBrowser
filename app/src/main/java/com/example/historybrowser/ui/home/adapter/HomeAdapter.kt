package com.example.historybrowser.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.local.BrowserHistory
import com.example.feature.ext.withSchedulers
import com.example.historybrowser.R
import com.example.historybrowser.databinding.HistoryItemBinding
import com.example.historybrowser.ui.home.HomeViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class HomeAdapter(private val items: List<BrowserHistory>, private val viewModel: HomeViewModel) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        create(parent, viewModel)

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) =
        holder.bind(items[position])

    inner class HomeViewHolder(
        private val binding: HistoryItemBinding,
        private val viewModel: HomeViewModel
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("CheckResult")
        fun bind(item: BrowserHistory) {
            binding.textViewUrl.text = item.url
            binding.textViewDate.text = item.date.toString()
            binding.textViewRequest.text = item.request
            binding.imageButtonDelete.setOnClickListener {
                viewModel.removeBrowserHistory(item.id)
                    .withSchedulers(AndroidSchedulers.mainThread(), Schedulers.io())
                    .subscribeBy(onComplete = {
                        Timber.d("remove complete")
                    })
            }
            when (item.browser) {
                BrowserHistory.Browser.Chrome -> binding.imageViewBrowserIcon.setImageResource(R.drawable.ic_chrome)
                BrowserHistory.Browser.Mozilla -> binding.imageViewBrowserIcon.setImageResource(R.drawable.ic_mozilla)
                BrowserHistory.Browser.Samsung -> binding.imageViewBrowserIcon.setImageResource(R.drawable.ic_samsung)
            }
        }
    }

    private fun create(
        parent: ViewGroup,
        viewModel: HomeViewModel
    ): HomeViewHolder =
        HomeViewHolder(
            HistoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), viewModel
        )
}