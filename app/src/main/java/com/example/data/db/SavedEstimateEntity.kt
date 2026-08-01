package com.example.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_estimates")
data class SavedEstimateEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val categoryName: String,
    val duration: String,
    val tierName: String,
    val selectedAddons: String,
    val totalPrice: Int,
    val timestamp: Long = System.currentTimeMillis()
)
