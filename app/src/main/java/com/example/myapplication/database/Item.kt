package com.example.myapplication.database

import androidx.room.Entity


data class Item(
    val id: Int = 0,
    val itemName: String,
    val itemPrice: Double,
    val quantityInStock: Int
)