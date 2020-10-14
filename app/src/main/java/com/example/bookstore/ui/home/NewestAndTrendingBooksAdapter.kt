package com.example.bookstore.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

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
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NewestAndTrendingBooksViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = books.size

    class NewestAndTrendingBooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}