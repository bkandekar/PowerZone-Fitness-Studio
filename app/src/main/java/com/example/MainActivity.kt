package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.model.GymConstants
import com.example.ui.PowerZoneViewModel
import com.example.ui.components.AmenitiesShowcase
import com.example.ui.components.BmiMacroCalculatorSection
import com.example.ui.components.BookingModal
import com.example.ui.components.ClassTimetableSection
import com.example.ui.components.ContactFooterSection
import com.example.ui.components.CostEstimatorSection
import com.example.ui.components.FitnessHubSection
import com.example.ui.components.FloatingWhatsAppBubble
import com.example.ui.components.GoogleReviewsWidget
import com.example.ui.components.HeroSection
import com.example.ui.components.HistoryBottomSheet
import com.example.ui.components.PainPointGrid
import com.example.ui.components.ProgramsSection
import com.example.ui.components.ReferralAndFaqSection
import com.example.ui.components.StickyHeader
import com.example.ui.components.StoryPreviewDialog
import com.example.ui.components.StoryReelsStrip
import com.example.ui.components.TestimonialsAndGallerySection
import com.example.ui.components.TrainersSection
import com.example.ui.components.TransformationsSection
import com.example.ui.components.WhyUsAndProcessSection
import com.example.ui.components.WorkoutSplitPreviewSection
import com.example.ui.theme.DarkBackground
import com.example.ui.theme.DeepBlueCard
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.PowerZoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PowerZoneTheme(darkTheme = true) {
                PowerZoneAppScreen()
            }
        }
    }
}

@Composable
fun PowerZoneAppScreen(viewModel: PowerZoneViewModel = viewModel()) {
    val context = LocalContext.current
    val activeSection by viewModel.activeSection.collectAsState()
    val showBookingModal by viewModel.showBookingModal.collectAsState()
    val showHistorySheet by viewModel.showHistorySheet.collectAsState()
    val trialBookings by viewModel.trialBookings.collectAsState()
    val savedEstimates by viewModel.savedEstimates.collectAsState()
    val selectedTimetableDay by viewModel.selectedTimetableDay.collectAsState()
    val activeArticle by viewModel.activeArticle.collectAsState()
    val activeVideo by viewModel.activeVideo.collectAsState()
    val activeStory by viewModel.activeStory.collectAsState()

    val totalSavedRecords = trialBookings.size + savedEstimates.size
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = DarkBackground,
        topBar = {
            StickyHeader(
                activeSection = activeSection,
                onNavigate = { section -> viewModel.navigateTo(section) },
                onBookTrialClick = { viewModel.openBookingModal() },
                onOpenHistoryClick = { viewModel.toggleHistorySheet(true) },
                onCallClick = { viewModel.openPhoneDialer(context) },
                savedCount = totalSavedRecords
            )
        },
        floatingActionButton = {
            FloatingWhatsAppBubble(
                onSendWhatsAppMessage = { ctx, phone, msg ->
                    viewModel.sendWhatsAppMessage(ctx, phone, msg)
                }
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = DarkBackground
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                when (activeSection) {
                    "home" -> {
                        HeroSection(
                            onBookTrialClick = { viewModel.openBookingModal() },
                            onEstimateCostClick = { viewModel.navigateTo("estimator") }
                        )
                        StoryReelsStrip(
                            onOpenStory = { story -> viewModel.openStory(story) }
                        )
                        GoogleReviewsWidget()
                        PainPointGrid()
                        ClassTimetableSection(
                            selectedDay = selectedTimetableDay,
                            onSelectDay = { day -> viewModel.setSelectedTimetableDay(day) },
                            onBookSlot = { prefill -> viewModel.openBookingModal(preselectedProgram = prefill) }
                        )
                        TrainersSection(
                            onBookTrainer = { prefill -> viewModel.openBookingModal(preselectedProgram = prefill) }
                        )
                        TransformationsSection(
                            onStartTransformation = { viewModel.openBookingModal("90-Day Body Transformation Challenge") }
                        )
                        BmiMacroCalculatorSection(
                            onSendMacroLead = { ctx, phone, msg ->
                                viewModel.sendWhatsAppMessage(ctx, phone, msg)
                            }
                        )
                        WorkoutSplitPreviewSection(
                            onBookSplitConsultation = { prefill -> viewModel.openBookingModal(preselectedProgram = prefill) }
                        )
                        AmenitiesShowcase(
                            onBookTourClick = { viewModel.openBookingModal("Facility Tour Request") }
                        )
                        ProgramsSection(
                            viewModel = viewModel,
                            onBookProgramClick = { progName ->
                                viewModel.openBookingModal(preselectedProgram = progName)
                            }
                        )
                        CostEstimatorSection(viewModel = viewModel)
                        FitnessHubSection(
                            activeArticle = activeArticle,
                            onOpenArticle = { art -> viewModel.openArticle(art) },
                            onCloseArticle = { viewModel.closeArticle() }
                        )
                        WhyUsAndProcessSection(
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                        ReferralAndFaqSection(
                            onShareReferralWhatsApp = { ctx, msg ->
                                viewModel.sendWhatsAppMessage(ctx, GymConstants.WHATSAPP_LEAD_ROUTING, msg)
                            },
                            onOpenCorporateModal = {
                                viewModel.openBookingModal("Corporate Membership Plan")
                            },
                            onOpenVideo = { vid -> viewModel.openVideo(vid) }
                        )
                        TestimonialsAndGallerySection(viewModel = viewModel)
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "reels" -> {
                        StoryReelsStrip(
                            onOpenStory = { story -> viewModel.openStory(story) }
                        )
                        TestimonialsAndGallerySection(viewModel = viewModel)
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "macros" -> {
                        BmiMacroCalculatorSection(
                            onSendMacroLead = { ctx, phone, msg ->
                                viewModel.sendWhatsAppMessage(ctx, phone, msg)
                            }
                        )
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "splits" -> {
                        WorkoutSplitPreviewSection(
                            onBookSplitConsultation = { prefill -> viewModel.openBookingModal(preselectedProgram = prefill) }
                        )
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "amenities" -> {
                        AmenitiesShowcase(
                            onBookTourClick = { viewModel.openBookingModal("Facility Tour Request") }
                        )
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "timetable" -> {
                        ClassTimetableSection(
                            selectedDay = selectedTimetableDay,
                            onSelectDay = { day -> viewModel.setSelectedTimetableDay(day) },
                            onBookSlot = { prefill -> viewModel.openBookingModal(preselectedProgram = prefill) }
                        )
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "trainers" -> {
                        TrainersSection(
                            onBookTrainer = { prefill -> viewModel.openBookingModal(preselectedProgram = prefill) }
                        )
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "transformations" -> {
                        TransformationsSection(
                            onStartTransformation = { viewModel.openBookingModal("90-Day Body Transformation Challenge") }
                        )
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "programs" -> {
                        ProgramsSection(
                            viewModel = viewModel,
                            onBookProgramClick = { progName ->
                                viewModel.openBookingModal(preselectedProgram = progName)
                            }
                        )
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "estimator" -> {
                        CostEstimatorSection(viewModel = viewModel)
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "reviews" -> {
                        GoogleReviewsWidget()
                        TestimonialsAndGallerySection(viewModel = viewModel)
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "blog" -> {
                        FitnessHubSection(
                            activeArticle = activeArticle,
                            onOpenArticle = { art -> viewModel.openArticle(art) },
                            onCloseArticle = { viewModel.closeArticle() }
                        )
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "why_us" -> {
                        WhyUsAndProcessSection(
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "faq" -> {
                        ReferralAndFaqSection(
                            onShareReferralWhatsApp = { ctx, msg ->
                                viewModel.sendWhatsAppMessage(ctx, GymConstants.WHATSAPP_LEAD_ROUTING, msg)
                            },
                            onOpenCorporateModal = {
                                viewModel.openBookingModal("Corporate Membership Plan")
                            },
                            onOpenVideo = { vid -> viewModel.openVideo(vid) }
                        )
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    "contact" -> {
                        ContactFooterSection(
                            viewModel = viewModel,
                            onBookTrialClick = { viewModel.openBookingModal() }
                        )
                    }

                    else -> {
                        HeroSection(
                            onBookTrialClick = { viewModel.openBookingModal() },
                            onEstimateCostClick = { viewModel.navigateTo("estimator") }
                        )
                    }
                }
            }
        }

        // Dialogs & Sheets
        if (showBookingModal) {
            BookingModal(
                viewModel = viewModel,
                onDismiss = { viewModel.closeBookingModal() }
            )
        }

        if (showHistorySheet) {
            HistoryBottomSheet(
                viewModel = viewModel,
                onDismiss = { viewModel.toggleHistorySheet(false) }
            )
        }

        // Instagram-style Story Reel Modal
        if (activeStory != null) {
            StoryPreviewDialog(
                story = activeStory!!,
                onDismiss = { viewModel.closeStory() },
                onBookTrialFromStory = { prefill -> viewModel.openBookingModal(preselectedProgram = prefill) }
            )
        }

        // Video Player Preview Modal
        if (activeVideo != null) {
            val vid = activeVideo!!
            Dialog(onDismissRequest = { viewModel.closeVideo() }) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth(0.95f)
                        .clip(RoundedCornerShape(16.dp))
                        .testTag("video_player_dialog"),
                    color = DeepBlueCard
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = vid.title,
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            IconButton(onClick = { viewModel.closeVideo() }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close",
                                    tint = Color.White
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.Black),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(
                                    imageVector = Icons.Default.PlayCircle,
                                    contentDescription = null,
                                    tint = NeonGreen,
                                    modifier = Modifier.size(56.dp)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Previewing: ${vid.title} (${vid.duration})",
                                    color = Color.LightGray,
                                    fontSize = 12.sp
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {
                                viewModel.closeVideo()
                                viewModel.openBookingModal("Video Tour Inquiry: ${vid.title}")
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = NeonGreen, contentColor = Color.Black),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(text = "Book Gym Visit in Baner", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

