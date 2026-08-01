package com.example.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trial_bookings")
data class TrialBookingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val fullName: String,
    val phone: String,
    val preferredProgram: String,
    val preferredDate: String,
    val preferredTimeSlot: String,
    val notes: String,
    val status: String = "Booked",
    val timestamp: Long = System.currentTimeMillis()
)
