package com.example.belajarmvvm.ui.topheadline

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belajarmvvm.data.model.ArticlesItem
import com.example.belajarmvvm.databinding.TopItemBinding

class TopHeadlineAdapter(private val articleList: ArrayList<ArticlesItem>
) : RecyclerView.Adapter<TopHeadlineAdapter.DataViewHolder>() {

    class DataViewHolder(private val binding: TopItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticlesItem) {
            binding.textViewTitle.text = article.title
            binding.textViewDescription.text = article.description
            binding.textViewSource.text = article.source.name
            Glide.with(binding.imageViewBanner.context)
                .load(article.urlToImage)
                .into(binding.imageViewBanner)
            itemView.setOnClickListener {
                val builder = CustomTabsIntent.Builder()
                val customTabsIntent = builder.build()
                customTabsIntent.launchUrl(it.context, Uri.parse(article.url))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            TopItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(articleList[position])

    fun addData(list: List<ArticlesItem>) {
        articleList.addAll(list)
    }

    override fun getItemCount(): Int = articleList.size
}