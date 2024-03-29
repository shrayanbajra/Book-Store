package com.example.bookstore.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.R
import com.example.bookstore.data.Book
import com.example.bookstore.utils.DisplayMetricsUtils

class SpecificGenreBooksFragment : Fragment() {

    private lateinit var ivBackButton: ImageView
    private lateinit var tvGenre: TextView

    private lateinit var rvBooks: RecyclerView
    private val rvBooksAdapter = BooksAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specific_genre_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initRvBooks(view)

    }

    private fun initViews(view: View) {
        tvGenre = view.findViewById(R.id.tv_genre)
        ivBackButton = view.findViewById(R.id.iv_back_button)
    }

    private fun initRvBooks(view: View) {
        rvBooks = view.findViewById(R.id.rv_books)
        rvBooks.apply {
            val spanCount = 2
            addItemDecoration(getGridSpacingItemDecoration(spanCount, view))
            adapter = rvBooksAdapter
            layoutManager = GridLayoutManager(
                view.context, spanCount, GridLayoutManager.VERTICAL, false
            )
        }
    }

    @Suppress("SameParameterValue")
    private fun getGridSpacingItemDecoration(
        spanCount: Int,
        view: View
    ): GridSpacingItemDecoration {
        val spacing = DisplayMetricsUtils.getPixelValue(32f, view)
        val includeEdge = false
        return GridSpacingItemDecoration(spanCount, spacing.toInt(), includeEdge)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val args = arguments?.let { SpecificGenreBooksFragmentArgs.fromBundle(it) }
        val genre = args?.genre ?: ""
        tvGenre.text = genre

        val books = getBooks()
        rvBooksAdapter.setBooks(books)

        ivBackButton.setOnClickListener { navigateUp() }
    }

    private fun getBooks(): List<Book> {
        val book1 = Book(
            cover = R.drawable.img_dummy_book_1,
            title = getString(R.string.all_we_know_three_lives),
            author = getString(R.string.lisa_cohen),
            price = 12.00
        )

        val book2 = Book(
            cover = R.drawable.img_dummy_book_2,
            title = getString(R.string.hidden_figures),
            author = getString(R.string.margot_lee_shetterly),
            price = 15.99
        )

        val book3 = Book(
            cover = R.drawable.img_dummy_book_3,
            title = getString(R.string.the_wives_of_henry_viii),
            author = getString(R.string.lady_antonia_fraser),
            price = 10.00
        )

        val book4 = Book(
            cover = R.drawable.img_dummy_book_4,
            title = getString(R.string.frida),
            author = getString(R.string.hayden_herrera),
            price = 16.09
        )

        val book5 = Book(
            cover = R.drawable.img_dummy_book_5,
            title = getString(R.string.invisible),
            author = getString(R.string.stephen_l_carter),
            price = 12.90
        )

        val book6 = Book(
            cover = R.drawable.img_dummy_book_6,
            title = getString(R.string.wild_swans),
            author = getString(R.string.jung_chang),
            price = 13.30
        )
        return listOf(book1, book2, book3, book4, book5, book6)
    }

    private fun navigateUp() {
        findNavController().navigateUp()
    }

}