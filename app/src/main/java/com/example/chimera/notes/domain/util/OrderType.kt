package com.example.chimera.notes.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}