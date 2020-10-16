package com.example.bookstore.ui.catalog

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.data.Book
import com.example.bookstore.utils.BitmapUtils
import com.example.bookstore.utils.CurrencyUtils
import com.google.android.material.chip.Chip


class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    private val books = arrayListOf<Book>()

    fun setBooks(books: List<Book>) {
        this.books.clear()
        this.books.addAll(books)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BooksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_books, parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {

        val currentBook = books[position]
        holder.bind(currentBook)

    }

    override fun getItemCount() = books.size

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivBackgroundImage: ImageView = itemView.findViewById(R.id.iv_background_image)
        private val ivCover: ImageView = itemView.findViewById(R.id.iv_cover)
        private val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
        private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        private val chPrice: Chip = itemView.findViewById(R.id.ch_price)

        fun bind(currentBook: Book) {
            val dominantColor = getDominantColor(currentBook.cover)

            ivBackgroundImage.setColorFilter(dominantColor)
            ivCover.setImageResource(currentBook.cover)
            tvAuthor.text = currentBook.author
            tvTitle.text = currentBook.title
            chPrice.text = CurrencyUtils.formatUsingUsCurrencySystem(currentBook.price)
        }

        private fun getDominantColor(image: Int): Int {
            val bitmap = BitmapFactory.decodeResource(itemView.context.resources, image)
            return BitmapUtils.getDominantColor(bitmap)
        }

    }

}