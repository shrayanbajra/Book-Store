package com.example.bookstore.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R

class HomeFragment : Fragment() {

    private lateinit var rvMostPopularBooks: RecyclerView
    private val mostPopularBooksAdapter = MostPopularBooksAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRvMostPopularBooks(view)

    }

    private fun initRvMostPopularBooks(view: View) {
        rvMostPopularBooks = view.findViewById(R.id.rv_most_popular_books)
        rvMostPopularBooks.layoutManager = LinearLayoutManager(context)
        rvMostPopularBooks.adapter = mostPopularBooksAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val book1 = Book(
            cover = R.drawable.img_most_popular_book,
            title = getString(R.string.the_beekeeper_of_aleppo),
            author = getString(R.string.christy_lefteri),
            genre = getString(R.string.literary_fiction),
            price = 11.49,
        )
        val books = listOf(book1)
        mostPopularBooksAdapter.setBooks(books)
    }

}