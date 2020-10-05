package com.example.bookstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CatalogFragment : Fragment() {

    private lateinit var rvGenres: RecyclerView
    private val rvGenresAdapter = GenreAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRvGenres(view)
    }

    private fun initRvGenres(view: View) {
        rvGenres = view.findViewById(R.id.rv_genres)
        rvGenres.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = rvGenresAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val genres = getGenres()
        rvGenresAdapter.setGenres(genres)
    }

    private fun getGenres(): List<Genre> {
        val action = Genre(imageResource = R.drawable.ic_car_crash, title = "Action")
        val biography = Genre(imageResource = R.drawable.ic_vaadin_glasses, title = "Biography")
        return listOf(action, biography)
    }
}