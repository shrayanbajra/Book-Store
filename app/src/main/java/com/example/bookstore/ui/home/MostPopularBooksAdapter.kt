package com.example.bookstore.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.google.android.material.chip.Chip

class MostPopularBooksAdapter :
    RecyclerView.Adapter<MostPopularBooksAdapter.MostPopularBookViewHolder>() {

    private val books = arrayListOf<Book>()

    fun setBooks(books: List<Book>) {
        this.books.clear()
        this.books.addAll(books)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularBookViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_most_popular_book, parent, false)
        return MostPopularBookViewHolder(view)

    }

    override fun onBindViewHolder(holderBook: MostPopularBookViewHolder, position: Int) {

        val currentBook = books[position]
        holderBook.bind(currentBook)

    }

    override fun getItemCount() = books.size

    class MostPopularBookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivCover: ImageView = itemView.findViewById(R.id.iv_cover)
        private val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private val tvGenre: TextView = itemView.findViewById(R.id.tv_genre)
        private val tvPrice: Chip = itemView.findViewById(R.id.tv_price)

        fun bind(currentBook: Book) {

            ivCover.setImageResource(currentBook.cover)
            tvAuthor.text = currentBook.author
            tvTitle.text = currentBook.title
            tvGenre.text = currentBook.genre
            tvPrice.text = currentBook.price.toString()

        }

    }

}