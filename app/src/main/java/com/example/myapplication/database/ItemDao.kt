package com.example.myapplication.database

import kotlinx.coroutines.flow.Flow

interface ItemDao {
    suspend fun insert(groceryItem: Item)
    suspend   fun update(item: Item)
    suspend fun delete(item: Item)
    fun getItem(id: Int): Flow<Item>
    fun getItems(): Flow<List<Item>>
}