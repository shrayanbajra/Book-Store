package com.example.bookstore.utils

import java.text.NumberFormat
import java.util.*

object CurrencyUtils {

    fun formatUsingUsCurrencySystem(amount: Double): String {

        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
        return format.format(amount)

    }

}