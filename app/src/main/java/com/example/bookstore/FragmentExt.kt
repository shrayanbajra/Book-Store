package com.example.bookstore

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.shortToast(message: String) {

    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

}