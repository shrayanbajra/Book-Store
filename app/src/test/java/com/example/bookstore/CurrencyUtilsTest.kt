package com.example.bookstore

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import java.text.NumberFormat
import java.util.*

class CurrencyUtilsTest {

    @Test
    fun `no decimal price has only 2 decimal places`() {
        val price = 12

        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
        val formattedPrice = format.format(price)

        assertThat(formattedPrice).isEqualTo("$12.00")
    }

    @Test
    fun `more than 2 decimal places price rounds off to 2 decimal places`() {
        val price = 12.349

        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
        val formattedPrice = format.format(price)

        assertThat(formattedPrice).isEqualTo("$12.35")
    }

    @Test
    fun `price in thousands have commas in the right place`() {
        val price = 12349

        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
        val formattedPrice = format.format(price)

        assertThat(formattedPrice).isEqualTo("$12,349.00")
    }

    @Test
    fun `price in millions have commas in the right place`() {
        val price = 1234569

        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
        val formattedPrice = format.format(price)

        assertThat(formattedPrice).isEqualTo("$1,234,569.00")
    }

}