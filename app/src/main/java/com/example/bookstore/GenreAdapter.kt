package com.example.bookstore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GenreAdapter : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    private val genres = arrayListOf<Genre>()

    fun setGenres(genres: List<Genre>) {
        this.genres.clear()
        this.genres.addAll(genres)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genre, parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val currentGenre = genres[position]
        holder.bind(currentGenre)
    }

    override fun getItemCount(): Int {
        return genres.size
    }

    class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvGenreIcon: ImageView = itemView.findViewById(R.id.iv_genre_icon)
        private val tvGenreTitle: TextView = itemView.findViewById(R.id.tv_genre_title)

        fun bind(currentGenre: Genre) {
            tvGenreIcon.setImageResource(currentGenre.imageResource)
            tvGenreTitle.text = currentGenre.title
        }

    }

}