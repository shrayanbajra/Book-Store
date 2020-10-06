package com.example.bookstore.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MostPopularAdapter : RecyclerView.Adapter<MostPopularAdapter.MostPopularViewHolder>() {

    private val books = arrayListOf<Book>()

    fun setBooks(books: List<Book>) {
        this.books.clear()
        this.books.addAll(books)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MostPopularViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class MostPopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}