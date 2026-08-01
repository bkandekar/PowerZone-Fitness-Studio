package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PowerZoneDao {
    @Query("SELECT * FROM trial_bookings ORDER BY timestamp DESC")
    fun getAllTrialBookings(): Flow<List<TrialBookingEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrialBooking(booking: TrialBookingEntity): Long

    @Query("DELETE FROM trial_bookings WHERE id = :id")
    suspend fun deleteTrialBooking(id: Long)

    @Query("SELECT * FROM saved_estimates ORDER BY timestamp DESC")
    fun getAllSavedEstimates(): Flow<List<SavedEstimateEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSavedEstimate(estimate: SavedEstimateEntity): Long

    @Query("DELETE FROM saved_estimates WHERE id = :id")
    suspend fun deleteSavedEstimate(id: Long)
}
