package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.window.DialogProperties
import com.example.model.GymConstants
import com.example.ui.PowerZoneViewModel
import com.example.ui.theme.DarkBackground
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.DeepBlueCard
import com.example.ui.theme.DeepBlueDark
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.TextMuted

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BookingModal(
    viewModel: PowerZoneViewModel,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val name by viewModel.bookingName.collectAsState()
    val phone by viewModel.bookingPhone.collectAsState()
    val selectedProgram by viewModel.bookingProgram.collectAsState()
    val selectedDate by viewModel.bookingDate.collectAsState()
    val selectedSlot by viewModel.bookingTimeSlot.collectAsState()
    val notes by viewModel.bookingNotes.collectAsState()

    val dateOptions = listOf("Today", "Tomorrow", "In 2 Days", "This Weekend")
    val slotOptions = listOf(
        "Morning (6:00 AM - 10:00 AM)",
        "Ladies Batch (10:00 AM - 12:00 PM)",
        "Afternoon (12:00 PM - 5:00 PM)",
        "Evening (5:00 PM - 10:00 PM)"
    )

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .clip(RoundedCornerShape(20.dp)),
            color = DarkSurface,
            tonalElevation = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp)
            ) {
                // Modal Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "BOOK FREE 3-DAY TRIAL PASS",
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Black,
                                fontSize = 18.sp
                            ),
                            color = Color.White
                        )
                        Text(
                            text = "PowerZone Fitness Studio, Baner Road Signal",
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 11.sp),
                            color = TextMuted
                        )
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(DarkSurfaceVariant)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Name Input
                OutlinedTextField(
                    value = name,
                    onValueChange = { viewModel.bookingName.value = it },
                    label = { Text("Full Name *") },
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = "Name", tint = NeonGreen)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("input_booking_name"),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NeonGreen,
                        unfocusedBorderColor = DeepBlueCard,
                        focusedLabelColor = NeonGreen,
                        unfocusedLabelColor = TextMuted,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Phone Input
                OutlinedTextField(
                    value = phone,
                    onValueChange = { viewModel.bookingPhone.value = it },
                    label = { Text("Phone / WhatsApp Number *") },
                    leadingIcon = {
                        Icon(Icons.Default.Phone, contentDescription = "Phone", tint = NeonGreen)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("input_booking_phone"),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NeonGreen,
                        unfocusedBorderColor = DeepBlueCard,
                        focusedLabelColor = NeonGreen,
                        unfocusedLabelColor = TextMuted,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Program Selector Label
                Text(
                    text = "Preferred Program:",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 12.sp),
                    color = NeonGreen
                )

                Spacer(modifier = Modifier.height(6.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    GymConstants.PROGRAMS_OFFERED.take(6).forEach { prog ->
                        val isSel = selectedProgram == prog.name
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (isSel) NeonGreen else DarkSurfaceVariant)
                                .border(1.dp, if (isSel) NeonGreen else DeepBlueCard, RoundedCornerShape(12.dp))
                                .clickable { viewModel.bookingProgram.value = prog.name }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = prog.name,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = 11.sp,
                                    fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal
                                ),
                                color = if (isSel) DeepBlueDark else Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Date Selector
                Text(
                    text = "Preferred Date:",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 12.sp),
                    color = NeonGreen
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    dateOptions.forEach { dOpt ->
                        val isSel = selectedDate == dOpt
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (isSel) NeonGreen else DarkSurfaceVariant)
                                .clickable { viewModel.bookingDate.value = dOpt }
                                .padding(vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = dOpt,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    fontSize = 11.sp,
                                    fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal
                                ),
                                color = if (isSel) DeepBlueDark else Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Time Slot Selector
                Text(
                    text = "Preferred Time Slot:",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 12.sp),
                    color = NeonGreen
                )

                Spacer(modifier = Modifier.height(6.dp))

                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    slotOptions.forEach { slot ->
                        val isSel = selectedSlot == slot
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (isSel) DeepBlueCard else DarkSurfaceVariant)
                                .border(1.dp, if (isSel) NeonGreen else Color.Transparent, RoundedCornerShape(10.dp))
                                .clickable { viewModel.bookingTimeSlot.value = slot }
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Schedule,
                                    contentDescription = "Clock",
                                    tint = if (isSel) NeonGreen else TextMuted,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = slot,
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontSize = 12.sp,
                                        fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal
                                    ),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Notes / Goal Input
                OutlinedTextField(
                    value = notes,
                    onValueChange = { viewModel.bookingNotes.value = it },
                    label = { Text("Fitness Goals / Notes (Optional)") },
                    placeholder = { Text("e.g. Weight loss, posture fix, fat burn") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NeonGreen,
                        unfocusedBorderColor = DeepBlueCard,
                        focusedLabelColor = NeonGreen,
                        unfocusedLabelColor = TextMuted,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    ),
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Submit Button
                Button(
                    onClick = { viewModel.submitTrialBooking(context) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NeonGreen,
                        contentColor = DeepBlueDark
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("btn_modal_confirm_booking")
                ) {
                    Text(
                        text = "CONFIRM & ROUTE TO WHATSAPP",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 14.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "🔒 Direct lead routing to Sameer Kulkarni (918329931123). Your trial will be saved to local app records.",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 10.sp),
                    color = TextMuted
                )
            }
        }
    }
}
