package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.GymConstants
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DeepBlueCard
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.TextMuted

@Composable
fun BmiMacroCalculatorSection(
    onSendMacroLead: (context: android.content.Context, phone: String, message: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    var weightInput by remember { mutableStateOf("70") }
    var heightInput by remember { mutableStateOf("175") }
    var ageInput by remember { mutableStateOf("26") }
    var genderSelection by remember { mutableStateOf("Male") } // "Male" or "Female"
    var goalSelection by remember { mutableStateOf("Fat Loss") } // "Fat Loss", "Muscle Gain", "Body Recomp"

    // Calculation computations
    val weightKg = weightInput.toFloatOrNull() ?: 70f
    val heightCm = heightInput.toFloatOrNull() ?: 175f
    val ageYears = ageInput.toIntOrNull() ?: 26

    val heightMeters = heightCm / 100f
    val bmi = if (heightMeters > 0) weightKg / (heightMeters * heightMeters) else 22f

    // BMR using Mifflin-St Jeor Equation
    val bmr = if (genderSelection == "Male") {
        (10 * weightKg) + (6.25 * heightCm) - (5 * ageYears) + 5
    } else {
        (10 * weightKg) + (6.25 * heightCm) - (5 * ageYears) - 161
    }

    val tdee = (bmr * 1.375f).toInt() // Lightly/Moderately Active

    val targetCalories = when (goalSelection) {
        "Fat Loss" -> (tdee * 0.82f).toInt()
        "Muscle Gain" -> (tdee * 1.15f).toInt()
        else -> tdee
    }

    val proteinGrams = (weightKg * 1.8f).toInt()
    val fatsGrams = ((targetCalories * 0.25f) / 9f).toInt()
    val carbsGrams = ((targetCalories - (proteinGrams * 4) - (fatsGrams * 9)) / 4f).toInt().coerceAtLeast(50)

    val bmiCategory = when {
        bmi < 18.5 -> "Underweight" to Color(0xFFFFD54F)
        bmi in 18.5..24.9 -> "Normal / Fit" to NeonGreen
        bmi in 25.0..29.9 -> "Overweight" to Color(0xFFFF9800)
        else -> "Obese / Needs Action" to Color(0xFFFF5252)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(DarkSurface)
            .padding(vertical = 32.dp, horizontal = 16.dp)
            .testTag("bmi_macro_calculator_section")
    ) {
        // Section Header
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(NeonGreen.copy(alpha = 0.2f))
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Calculate,
                    contentDescription = null,
                    tint = NeonGreen,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "BANER FITNESS GOAL PLANNER",
                    color = NeonGreen,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "Calculate Your BMI, Calories & Macros",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Enter your current stats to get customized calorie & macro breakdown formulated for PowerZone Pune members:",
            color = TextMuted,
            fontSize = 13.sp,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Input Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = DeepBlueCard),
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.1f))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Gender & Goal Toggles
                Text(
                    text = "Select Gender & Target Goal",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("Male", "Female").forEach { gen ->
                        val isSelected = genderSelection == gen
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isSelected) NeonGreen else Color.White.copy(alpha = 0.08f))
                                .clickable { genderSelection = gen }
                                .padding(vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = gen,
                                color = if (isSelected) Color.Black else Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    listOf("Fat Loss", "Body Recomp", "Muscle Gain").forEach { goal ->
                        val isSelected = goalSelection == goal
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isSelected) NeonGreen else Color.White.copy(alpha = 0.08f))
                                .clickable { goalSelection = goal }
                                .padding(vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = goal,
                                color = if (isSelected) Color.Black else Color.White,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Numerical Fields
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedTextField(
                        value = weightInput,
                        onValueChange = { weightInput = it },
                        label = { Text("Weight (kg)", color = Color.Gray, fontSize = 11.sp) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = NeonGreen,
                            unfocusedBorderColor = Color.Gray
                        ),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = heightInput,
                        onValueChange = { heightInput = it },
                        label = { Text("Height (cm)", color = Color.Gray, fontSize = 11.sp) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = NeonGreen,
                            unfocusedBorderColor = Color.Gray
                        ),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = ageInput,
                        onValueChange = { ageInput = it },
                        label = { Text("Age (yrs)", color = Color.Gray, fontSize = 11.sp) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = NeonGreen,
                            unfocusedBorderColor = Color.Gray
                        ),
                        singleLine = true
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Calculated Output Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = DeepBlueCard),
            shape = RoundedCornerShape(16.dp),
            border = androidx.compose.foundation.BorderStroke(1.5.dp, NeonGreen)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "CALCULATED BMI METRIC",
                            color = Color.Gray,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = String.format("%.1f", bmi),
                                color = Color.White,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Black
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "(${bmiCategory.first})",
                                color = bmiCategory.second,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(NeonGreen.copy(alpha = 0.15f))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "Target: $goalSelection",
                            color = NeonGreen,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Macros Breakdown Grid
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MacroMetricBox("Calories", "$targetCalories kcal", "Daily Target", Modifier.weight(1f))
                    MacroMetricBox("Protein", "${proteinGrams}g", "Muscle Repair", Modifier.weight(1f))
                    MacroMetricBox("Carbs", "${carbsGrams}g", "Energy Fuel", Modifier.weight(1f))
                    MacroMetricBox("Fats", "${fatsGrams}g", "Hormones", Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val message = """
                            *MY POWERZONE FITNESS & MACRO GOAL PLAN*
                            
                            👤 *Gender:* $genderSelection | *Age:* $ageYears
                            ⚖️ *Current Weight:* ${weightKg}kg | *Height:* ${heightCm}cm
                            📊 *Calculated BMI:* ${String.format("%.1f", bmi)} (${bmiCategory.first})
                            🎯 *Primary Goal:* $goalSelection
                            🔥 *Daily Target:* $targetCalories kcal
                            🍗 *Protein:* ${proteinGrams}g | 🍞 *Carbs:* ${carbsGrams}g | 🥑 *Fats:* ${fatsGrams}g
                            
                            Hi Sameer sir! I generated my macro plan on the PowerZone App. Please guide me with personal training and diet chart!
                        """.trimIndent()

                        onSendMacroLead(context, GymConstants.WHATSAPP_LEAD_ROUTING, message)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = NeonGreen, contentColor = Color.Black),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Send Goal to Sameer Sir on WhatsApp",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MacroMetricBox(
    title: String,
    value: String,
    sub: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White.copy(alpha = 0.06f))
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = title, color = Color.Gray, fontSize = 9.sp)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = value, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Black)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = sub, color = NeonGreen, fontSize = 8.sp)
        }
    }
}
