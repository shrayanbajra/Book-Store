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
import com.example.bookstore.ui.mylibrary.adapters.BooksFinishedAdapter
import com.example.bookstore.ui.mylibrary.adapters.BooksToReadAdapter
import com.example.bookstore.ui.mylibrary.adapters.NowReadingAdapter

class MyLibraryFragment : Fragment() {

    private lateinit var rvNowReading: RecyclerView
    private val rvNowReadingAdapter = NowReadingAdapter()

    private lateinit var rvBooksToRead: RecyclerView
    private val rvBooksToReadAdapter = BooksToReadAdapter()

    private lateinit var rvFinished: RecyclerView
    private val rvBooksFinishedAdapter = BooksFinishedAdapter()

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
        initRvFinishedBooks(view)

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

    private fun initRvFinishedBooks(view: View) {
        rvFinished = view.findViewById(R.id.rv_finished_books)
        rvFinished.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvFinished.adapter = rvBooksFinishedAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val nowReadingBooks = getNowReadingBooks()
        rvNowReadingAdapter.setBooks(nowReadingBooks)

        val booksToRead = getBooksToRead()
        rvBooksToReadAdapter.setBooks(booksToRead)

        val finishedBooks = getFinishedBooks()
        rvBooksFinishedAdapter.setBooks(finishedBooks)
    }

    private fun getNowReadingBooks(): List<Book> {

        val book1 = Book(
            cover = R.drawable.img_now_reading_1,
            title = getString(R.string.lolita),
            author = getString(R.string.vladimir_nabokov),
            genre = getString(R.string.novel)
        )

        val book2 = Book(
            cover = R.drawable.img_now_reading_2,
            title = getString(R.string.milkman),
            author = getString(R.string.anna_burns),
            genre = getString(R.string.novel)
        )

        return listOf(book1, book2)

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

    private fun getFinishedBooks(): List<Book> {

        val book1 = Book(
            cover = R.drawable.img_finished_book_1,
            title = getString(R.string.i_looked_away)
        )

        val book2 = Book(
            cover = R.drawable.img_finished_book_2,
            title = getString(R.string.this_is_going_to_hurt)
        )

        val book3 = Book(
            cover = R.drawable.img_finished_book_3,
            title = getString(R.string.the_reckoning)
        )

        val book4 = Book(
            cover = R.drawable.img_finished_book_4,
            title = getString(R.string.after)
        )

        return listOf(book1, book2, book3, book4)

    }

}