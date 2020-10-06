package com.example.bookstore.ui.home

data class Book(
    var cover: Int = 0,
    var title: String = "",
    var author: String = "",
    var genre: String = "",
    var price: Double = 0.0
)