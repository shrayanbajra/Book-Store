package com.example.bookstore.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bookstore.R

class SpecificGenreBooksFragment : Fragment() {

    private lateinit var tvGenre: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specific_genre_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments?.let { SpecificGenreBooksFragmentArgs.fromBundle(it) }
        val genre = args?.genre ?: ""

        tvGenre = view.findViewById(R.id.tv_genre)
        tvGenre.text = genre
    }

}