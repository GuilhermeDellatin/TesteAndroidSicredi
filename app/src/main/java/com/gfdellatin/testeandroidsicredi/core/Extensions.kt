package com.gfdellatin.testeandroidsicredi.core

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


fun Long.toFormatDate() : String =
        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(this))

fun Long.toFormatHour() : String =
    SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(this))


fun Double.formatCurrency(locale: Locale = Locale.getDefault()) : String {
    return NumberFormat.getCurrencyInstance(locale).format(this)
}