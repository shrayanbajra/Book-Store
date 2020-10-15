package com.example.bookstore.ui.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.data.Article

class MoreArticlesAdapter : RecyclerView.Adapter<MoreArticlesAdapter.MoreArticlesViewHolder>() {

    private val articles = arrayListOf<Article>()

    fun setArticles(articles: List<Article>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoreArticlesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_more_article, parent, false)
        return MoreArticlesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoreArticlesViewHolder, position: Int) {

        val currentArticle = articles[position]
        holder.bind(currentArticle)

    }

    override fun getItemCount() = articles.size

    class MoreArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivImage: ImageView = itemView.findViewById(R.id.iv_image)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)

        fun bind(currentArticle: Article) {
            ivImage.setImageResource(currentArticle.image)
            tvTitle.text = currentArticle.title
        }

    }

}