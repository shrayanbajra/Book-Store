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
        val biography = Genre(imageResource = R.drawable.ic_glasses, title = "Biography")
        val cookbook = Genre(imageResource = R.drawable.ic_apple, title = "Cookbook")
        val crime = Genre(imageResource = R.drawable.ic_knife, title = "Crime")
        val drama = Genre(imageResource = R.drawable.ic_theater_masks, title = "Drama")
        val fantasy = Genre(imageResource = R.drawable.ic_magic, title = "Fantasy")
        val guide = Genre(imageResource = R.drawable.ic_map_signs, title = "Guide")
        val health = Genre(imageResource = R.drawable.ic_health, title = "Health")
        val horror = Genre(imageResource = R.drawable.ic_grave, title = "Horror")
        val poetry = Genre(imageResource = R.drawable.ic_pen_nib, title = "Poetry")
        val religion = Genre(imageResource = R.drawable.ic_praying_hands, title = "Religion")
        val romance = Genre(imageResource = R.drawable.ic_heart, title = "Romance")
        val science = Genre(imageResource = R.drawable.ic_genius, title = "Science")
        val scienceFiction = Genre(imageResource = R.drawable.ic_alien, title = "Science fiction")
        val thriller = Genre(imageResource = R.drawable.ic_skull, title = "Thriller")
        val travel = Genre(imageResource = R.drawable.ic_airplane, title = "Travel")
        return listOf(
            action, biography, cookbook, crime, drama, fantasy, guide, health, horror, poetry,
            religion, romance, science, scienceFiction, thriller, travel
        )
    }
}