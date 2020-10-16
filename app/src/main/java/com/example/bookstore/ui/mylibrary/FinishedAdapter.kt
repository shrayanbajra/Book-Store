package com.example.bookstore.ui.mylibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.data.Book

class FinishedAdapter : RecyclerView.Adapter<FinishedAdapter.FinishedBooksViewHolder>() {

    private val books = arrayListOf<Book>()

    fun setBooks(books: List<Book>) {
        this.books.clear()
        this.books.addAll(books)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FinishedBooksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_books_finished, parent, false)
        return FinishedBooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: FinishedBooksViewHolder, position: Int) {

        val currentBook = books[position]
        holder.bind(currentBook)

    }

    override fun getItemCount() = books.size

    class FinishedBooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivCover: ImageView = itemView.findViewById(R.id.iv_cover)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)

        fun bind(currentBook: Book) {
            ivCover.setImageResource(currentBook.cover)
            tvTitle.text = currentBook.title
        }

    }

}