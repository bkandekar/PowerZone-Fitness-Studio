package com.example.data.repository

import com.example.data.db.PowerZoneDao
import com.example.data.db.SavedEstimateEntity
import com.example.data.db.TrialBookingEntity
import kotlinx.coroutines.flow.Flow

class PowerZoneRepository(private val powerZoneDao: PowerZoneDao) {
    val allTrialBookings: Flow<List<TrialBookingEntity>> = powerZoneDao.getAllTrialBookings()
    val allSavedEstimates: Flow<List<SavedEstimateEntity>> = powerZoneDao.getAllSavedEstimates()

    suspend fun saveTrialBooking(booking: TrialBookingEntity): Long {
        return powerZoneDao.insertTrialBooking(booking)
    }

    suspend fun deleteTrialBooking(id: Long) {
        powerZoneDao.deleteTrialBooking(id)
    }

    suspend fun saveEstimate(estimate: SavedEstimateEntity): Long {
        return powerZoneDao.insertSavedEstimate(estimate)
    }

    suspend fun deleteEstimate(id: Long) {
        powerZoneDao.deleteSavedEstimate(id)
    }
}
