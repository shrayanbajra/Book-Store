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

    private lateinit var rvNewestAndTrendingBooks: RecyclerView
    private val newestAndTrendingBooksAdapter = NewestAndTrendingBooksAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRvMostPopularBooks(view)
        initRvNewestAndTrendingBooks(view)

    }

    private fun initRvMostPopularBooks(view: View) {
        rvMostPopularBooks = view.findViewById(R.id.rv_most_popular_books)
        rvMostPopularBooks.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvMostPopularBooks.adapter = mostPopularBooksAdapter
    }

    private fun initRvNewestAndTrendingBooks(view: View) {
        rvNewestAndTrendingBooks = view.findViewById(R.id.rv_newest_and_trending_books)
        rvNewestAndTrendingBooks.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvNewestAndTrendingBooks.adapter = newestAndTrendingBooksAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val popularBooks = getMostPopularBooks()
        mostPopularBooksAdapter.setBooks(popularBooks)

        val newBooks = getNewestAndTrendingBooks()
        newestAndTrendingBooksAdapter.setBooks(newBooks)

    }

    private fun getMostPopularBooks(): List<Book> {
        val book1 = Book(
            cover = R.drawable.img_most_popular_book_1,
            title = getString(R.string.the_beekeeper_of_aleppo),
            author = getString(R.string.christy_lefteri),
            genre = getString(R.string.literary_fiction),
            price = 11.49,
        )

        val book2 = Book(
            cover = R.drawable.img_most_popular_book_2,
            title = getString(R.string.normal_people),
            author = getString(R.string.sally_rooney),
            genre = getString(R.string.psychological_fiction),
            price = 12.20,
        )

        val book3 = Book(
            cover = R.drawable.img_most_popular_book_3,
            title = getString(R.string.becoming),
            author = getString(R.string.michelle_obama),
            genre = getString(R.string.biography),
            price = 18.20,
        )
        return listOf(book1, book2, book3)
    }


    private fun getNewestAndTrendingBooks(): List<Book> {
        val book1 = Book(
            cover = R.drawable.img_newest_and_trending_book_1,
            title = getString(R.string.a_fire_sparkling),
            price = 12.20
        )

        val book2 = Book(
            cover = R.drawable.img_newest_and_trending_book_2,
            title = getString(R.string.the_man_with_no_borders),
            price = 10.09,
        )

        val book3 = Book(
            cover = R.drawable.img_newest_and_trending_book_3,
            title = getString(R.string.relative_fortunes),
            price = 9.00,
        )

        val book4 = Book(
            cover = R.drawable.img_newest_and_trending_book_4,
            title = getString(R.string.the_silent_ones),
            price = 7.98,
        )
        return listOf(book1, book2, book3, book4)
    }

}