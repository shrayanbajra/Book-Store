package com.example.bookstore.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.utils.CurrencyUtils
import com.google.android.material.chip.Chip

class NewestAndTrendingBooksAdapter :
    RecyclerView.Adapter<NewestAndTrendingBooksAdapter.NewestAndTrendingBooksViewHolder>() {

    private val books = arrayListOf<Book>()

    fun setBooks(books: List<Book>) {
        this.books.clear()
        this.books.addAll(books)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewestAndTrendingBooksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_newest_and_trending_book, parent, false)
        return NewestAndTrendingBooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewestAndTrendingBooksViewHolder, position: Int) {

        val currentBook = books[position]
        holder.bind(currentBook)

    }

    override fun getItemCount() = books.size

    class NewestAndTrendingBooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivCover: ImageView = itemView.findViewById(R.id.iv_cover)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private val chPrice: Chip = itemView.findViewById(R.id.ch_price)

        fun bind(currentBook: Book) {
            ivCover.setImageResource(currentBook.cover)
            tvTitle.text = currentBook.title
            chPrice.text = CurrencyUtils.formatUsingUsCurrencySystem(currentBook.price)
        }

    }

}