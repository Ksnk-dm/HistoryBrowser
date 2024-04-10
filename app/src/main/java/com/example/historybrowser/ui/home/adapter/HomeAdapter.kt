package com.example.historybrowser.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.local.BrowserHistory
import com.example.historybrowser.R
import com.example.historybrowser.databinding.HistoryItemBinding

class HomeAdapter(private val items: List<BrowserHistory>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
        create(parent)

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) =
        holder.bind(items[position])

    inner class HomeViewHolder(
        private val binding: HistoryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BrowserHistory) {
            binding.textViewUrl.text = item.url
            binding.textViewDate.text = item.date.toString()
            binding.textViewRequest.text = item.request
            when (item.browser) {
                BrowserHistory.Browser.Chrome -> binding.imageViewBrowserIcon.setImageResource(R.drawable.ic_chrome)
                BrowserHistory.Browser.Mozilla -> binding.imageViewBrowserIcon.setImageResource(R.drawable.ic_mozilla)
                BrowserHistory.Browser.Samsung -> binding.imageViewBrowserIcon.setImageResource(R.drawable.ic_samsung)
            }
        }
    }

    private fun create(
        parent: ViewGroup
    ): HomeViewHolder =
        HomeViewHolder(
            HistoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
}