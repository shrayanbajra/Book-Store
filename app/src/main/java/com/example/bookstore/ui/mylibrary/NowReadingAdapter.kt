package com.example.bookstore.ui.mylibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.data.Book

class NowReadingAdapter :
    RecyclerView.Adapter<NowReadingAdapter.NowReadingViewHolder>() {

    private val books = arrayListOf<Book>()

    fun setBooks(books: List<Book>) {
        this.books.clear()
        this.books.addAll(books)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NowReadingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_now_reading, parent, false)
        return NowReadingViewHolder(view)
    }

    override fun onBindViewHolder(holder: NowReadingViewHolder, position: Int) {

        val currentBook = books[position]
        holder.bind(currentBook)

    }

    override fun getItemCount() = books.size

    class NowReadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivCover: ImageView = itemView.findViewById(R.id.iv_cover)
        private val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private val tvGenre: TextView = itemView.findViewById(R.id.tv_genre)

        fun bind(currentBook: Book) {
            ivCover.setImageResource(currentBook.cover)
            tvAuthor.text = currentBook.author
            tvTitle.text = currentBook.title
            tvGenre.text = currentBook.genre
        }

    }

}