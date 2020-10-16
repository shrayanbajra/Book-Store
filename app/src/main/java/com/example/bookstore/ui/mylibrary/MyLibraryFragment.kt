package com.example.bookstore.ui.mylibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.data.Book

class MyLibraryFragment : Fragment() {

    private lateinit var rvNowReading: RecyclerView
    private val rvNowReadingAdapter = NowReadingAdapter()

    private lateinit var rvBooksToRead: RecyclerView
    private val rvBooksToReadAdapter = BooksToReadAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRvNowReading(view)
        initRvBooksToRead(view)

    }

    private fun initRvNowReading(view: View) {
        rvNowReading = view.findViewById(R.id.rv_now_reading)
        rvNowReading.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvNowReading.adapter = rvNowReadingAdapter
    }

    private fun initRvBooksToRead(view: View) {
        rvBooksToRead = view.findViewById(R.id.rv_books_to_read)
        rvBooksToRead.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvBooksToRead.adapter = rvBooksToReadAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val nowReadingBooks = getNowReadingBooks()
        rvNowReadingAdapter.setBooks(nowReadingBooks)

        val booksToRead = getBooksToRead()
        rvBooksToReadAdapter.setBooks(booksToRead)
    }

    private fun getNowReadingBooks(): List<Book> {

        val books1 = Book(
            cover = R.drawable.img_now_reading_1,
            title = getString(R.string.lolita),
            author = getString(R.string.vladimir_nabokov),
            genre = getString(R.string.novel)
        )

        val books2 = Book(
            cover = R.drawable.img_now_reading_2,
            title = getString(R.string.milkman),
            author = getString(R.string.anna_burns),
            genre = getString(R.string.novel)
        )

        return listOf(books1, books2)

    }

    private fun getBooksToRead(): List<Book> {

        val book1 = Book(
            cover = R.drawable.img_book_to_read_1,
            title = getString(R.string.play_dead)
        )

        val book2 = Book(
            cover = R.drawable.img_book_to_read_2,
            title = getString(R.string.the_handmaids_tale)
        )

        val book3 = Book(
            cover = R.drawable.img_book_to_read_3,
            title = getString(R.string.the_bridal_party)
        )

        val book4 = Book(
            cover = R.drawable.img_book_to_read_4,
            title = getString(R.string.the_aftermath)
        )

        return listOf(book1, book2, book3, book4)

    }

}