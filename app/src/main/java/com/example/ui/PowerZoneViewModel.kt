package com.example.ui

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.db.PowerZoneDatabase
import com.example.data.db.SavedEstimateEntity
import com.example.data.db.TrialBookingEntity
import com.example.data.repository.PowerZoneRepository
import com.example.model.GymConstants
import com.example.model.MembershipAddon
import com.example.model.MembershipCategory
import com.example.model.PricingTier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.net.URLEncoder

class PowerZoneViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PowerZoneRepository

    val trialBookings: StateFlow<List<TrialBookingEntity>>
    val savedEstimates: StateFlow<List<SavedEstimateEntity>>

    init {
        val db = PowerZoneDatabase.getDatabase(application)
        repository = PowerZoneRepository(db.powerZoneDao())
        trialBookings = repository.allTrialBookings.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
        savedEstimates = repository.allSavedEstimates.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    }

    // Active Navigation Section: "home", "programs", "estimator", "why_us", "results", "contact"
    private val _activeSection = MutableStateFlow("home")
    val activeSection: StateFlow<String> = _activeSection.asStateFlow()

    // Dialog & Sheet States
    private val _showBookingModal = MutableStateFlow(false)
    val showBookingModal: StateFlow<Boolean> = _showBookingModal.asStateFlow()

    private val _showHistorySheet = MutableStateFlow(false)
    val showHistorySheet: StateFlow<Boolean> = _showHistorySheet.asStateFlow()

    // Trial Booking Form State
    var bookingName = MutableStateFlow("")
    var bookingPhone = MutableStateFlow("")
    var bookingProgram = MutableStateFlow(GymConstants.PROGRAMS_OFFERED.first().name)
    var bookingDate = MutableStateFlow("Tomorrow")
    var bookingTimeSlot = MutableStateFlow("Morning (7:00 AM - 9:00 AM)")
    var bookingNotes = MutableStateFlow("")

    // Estimator State
    private val _selectedCategory = MutableStateFlow<MembershipCategory>(GymConstants.PRICING_CATEGORIES.first())
    val selectedCategory: StateFlow<MembershipCategory> = _selectedCategory.asStateFlow()

    private val _selectedDuration = MutableStateFlow("1 Month")
    val selectedDuration: StateFlow<String> = _selectedDuration.asStateFlow()

    private val _selectedTier = MutableStateFlow<PricingTier>(GymConstants.PRICING_TIERS.first())
    val selectedTier: StateFlow<PricingTier> = _selectedTier.asStateFlow()

    private val _selectedAddons = MutableStateFlow<Set<MembershipAddon>>(emptySet())
    val selectedAddons: StateFlow<Set<MembershipAddon>> = _selectedAddons.asStateFlow()

    // Program Filter State
    private val _programCategoryFilter = MutableStateFlow("All")
    val programCategoryFilter: StateFlow<String> = _programCategoryFilter.asStateFlow()

    // Gallery Filter State
    private val _galleryCategoryFilter = MutableStateFlow("All")
    val galleryCategoryFilter: StateFlow<String> = _galleryCategoryFilter.asStateFlow()

    // Phase 2: Timetable Day Filter ("Monday", "Tuesday", etc.)
    private val _selectedTimetableDay = MutableStateFlow("Monday")
    val selectedTimetableDay: StateFlow<String> = _selectedTimetableDay.asStateFlow()

    // Phase 2: Blog Article Modal State
    private val _activeArticle = MutableStateFlow<com.example.model.ArticleItem?>(null)
    val activeArticle: StateFlow<com.example.model.ArticleItem?> = _activeArticle.asStateFlow()

    // Phase 2: Video Preview Modal State
    private val _activeVideo = MutableStateFlow<com.example.model.VideoItem?>(null)
    val activeVideo: StateFlow<com.example.model.VideoItem?> = _activeVideo.asStateFlow()

    // Active Instagram-style Story Reel Modal State
    private val _activeStory = MutableStateFlow<com.example.model.StoryReelItem?>(null)
    val activeStory: StateFlow<com.example.model.StoryReelItem?> = _activeStory.asStateFlow()

    // Phase 2: Pricing estimator Billing Cycle toggle (false = Monthly, true = Annual 35% Save)
    private val _isAnnualBilling = MutableStateFlow(false)
    val isAnnualBilling: StateFlow<Boolean> = _isAnnualBilling.asStateFlow()

    fun navigateTo(section: String) {
        _activeSection.value = section
    }

    fun openStory(story: com.example.model.StoryReelItem) {
        _activeStory.value = story
    }

    fun closeStory() {
        _activeStory.value = null
    }

    fun setSelectedTimetableDay(day: String) {
        _selectedTimetableDay.value = day
    }

    fun openArticle(article: com.example.model.ArticleItem) {
        _activeArticle.value = article
    }

    fun closeArticle() {
        _activeArticle.value = null
    }

    fun openVideo(video: com.example.model.VideoItem) {
        _activeVideo.value = video
    }

    fun closeVideo() {
        _activeVideo.value = null
    }

    fun toggleAnnualBilling(isAnnual: Boolean) {
        _isAnnualBilling.value = isAnnual
    }

    fun openBookingModal(preselectedProgram: String? = null) {
        if (!preselectedProgram.isNullOrBlank()) {
            bookingProgram.value = preselectedProgram
        }
        _showBookingModal.value = true
    }

    fun closeBookingModal() {
        _showBookingModal.value = false
    }

    fun toggleHistorySheet(show: Boolean) {
        _showHistorySheet.value = show
    }

    fun setProgramCategoryFilter(cat: String) {
        _programCategoryFilter.value = cat
    }

    fun setGalleryCategoryFilter(cat: String) {
        _galleryCategoryFilter.value = cat
    }

    // Estimator Setters
    fun selectCategory(category: MembershipCategory) {
        _selectedCategory.value = category
        // Reset duration to first valid key in pricingMap
        val available = category.pricingMap.filterValues { it != null }.keys
        if (!available.contains(_selectedDuration.value) && available.isNotEmpty()) {
            _selectedDuration.value = available.first()
        }
    }

    fun selectDuration(duration: String) {
        _selectedDuration.value = duration
    }

    fun selectTier(tier: PricingTier) {
        _selectedTier.value = tier
    }

    fun toggleAddon(addon: MembershipAddon) {
        val current = _selectedAddons.value.toMutableSet()
        if (current.contains(addon)) {
            current.remove(addon)
        } else {
            current.add(addon)
        }
        _selectedAddons.value = current
    }

    fun calculateTotalCost(): Int {
        val basePrice = _selectedCategory.value.pricingMap[_selectedDuration.value] ?: 0
        val tieredPrice = (basePrice * _selectedTier.value.priceMultiplier).toInt()
        val discountMultiplier = if (_isAnnualBilling.value && _selectedDuration.value == "12 Months") 0.85f else 1.0f
        val addonsTotal = _selectedAddons.value.sumOf { it.price }
        return (tieredPrice * discountMultiplier).toInt() + addonsTotal
    }

    fun submitTrialBooking(context: Context) {
        val name = bookingName.value.trim()
        val phone = bookingPhone.value.trim()

        if (name.isBlank() || phone.isBlank()) {
            Toast.makeText(context, "Please enter your name and phone number", Toast.LENGTH_SHORT).show()
            return
        }

        val booking = TrialBookingEntity(
            fullName = name,
            phone = phone,
            preferredProgram = bookingProgram.value,
            preferredDate = bookingDate.value,
            preferredTimeSlot = bookingTimeSlot.value,
            notes = bookingNotes.value.ifBlank { "None" }
        )

        viewModelScope.launch {
            repository.saveTrialBooking(booking)
            _showBookingModal.value = false

            // Format WhatsApp Lead Message
            val message = """
                *NEW FREE TRIAL BOOKING - POWERZONE FITNESS*
                
                👤 *Name:* $name
                📞 *Phone:* $phone
                🏋️ *Program:* ${booking.preferredProgram}
                📅 *Date:* ${booking.preferredDate}
                ⏰ *Time Slot:* ${booking.preferredTimeSlot}
                📝 *Notes:* ${booking.notes}
                
                📍 *Location:* PowerZone, Baner Road Signal, Pune
            """.trimIndent()

            sendWhatsAppMessage(context, GymConstants.WHATSAPP_LEAD_ROUTING, message)

            // Reset inputs
            bookingName.value = ""
            bookingPhone.value = ""
            bookingNotes.value = ""
        }
    }

    fun saveCurrentEstimate(context: Context) {
        val category = _selectedCategory.value
        val duration = _selectedDuration.value
        val tier = _selectedTier.value
        val addons = _selectedAddons.value.joinToString(", ") { it.name }.ifEmpty { "None" }
        val total = calculateTotalCost()

        val estimate = SavedEstimateEntity(
            categoryName = category.title,
            duration = duration,
            tierName = tier.name,
            selectedAddons = addons,
            totalPrice = total
        )

        viewModelScope.launch {
            repository.saveEstimate(estimate)
            Toast.makeText(context, "Membership Estimate Saved to Local DB!", Toast.LENGTH_SHORT).show()

            // Option to route estimate lead via WhatsApp
            val message = """
                *POWERZONE MEMBERSHIP COST ESTIMATE*
                
                📋 *Category:* ${category.title}
                ⏳ *Duration:* $duration
                🌟 *Tier:* ${tier.name} (${tier.badge})
                ➕ *Add-ons:* $addons
                💰 *Calculated Total:* ₹$total
                
                Hi Sameer sir! I generated this membership estimate on the PowerZone App and would like to claim this plan!
            """.trimIndent()

            sendWhatsAppMessage(context, GymConstants.WHATSAPP_LEAD_ROUTING, message)
        }
    }

    fun deleteBooking(id: Long) {
        viewModelScope.launch {
            repository.deleteTrialBooking(id)
        }
    }

    fun deleteEstimate(id: Long) {
        viewModelScope.launch {
            repository.deleteEstimate(id)
        }
    }

    fun openPhoneDialer(context: Context, phoneNumber: String = GymConstants.PHONE_CALLING) {
        try {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Unable to open dialer: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    fun sendWhatsAppMessage(context: Context, phone: String, message: String) {
        try {
            val encodedMessage = URLEncoder.encode(message, "UTF-8")
            val whatsappUrl = "https://api.whatsapp.com/send?phone=$phone&text=$encodedMessage"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(whatsappUrl))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Unable to launch WhatsApp: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    fun openGoogleMaps(context: Context) {
        try {
            val address = URLEncoder.encode("PowerZone Fitness Studio, Sai Complex, Baner Road Signal, Baner, Pune", "UTF-8")
            val gmmIntentUri = Uri.parse("geo:0,0?q=$address")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(context.packageManager) != null) {
                context.startActivity(mapIntent)
            } else {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com/?q=$address"))
                context.startActivity(browserIntent)
            }
        } catch (e: Exception) {
            Toast.makeText(context, "Opening Location...", Toast.LENGTH_SHORT).show()
        }
    }
}
