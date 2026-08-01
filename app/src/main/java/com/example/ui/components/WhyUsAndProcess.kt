package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.GymConstants
import com.example.ui.theme.DarkBackground
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.DeepBlueCard
import com.example.ui.theme.DeepBlueDark
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.TextMuted

@Composable
fun WhyUsAndProcessSection(onBookTrialClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkBackground)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        // Section Badge
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(DeepBlueCard)
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                text = "WHY POWERZONE",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                ),
                color = NeonGreen
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Proven Track Record in Pune",
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp
            ),
            color = Color.White
        )

        Text(
            text = "Numbers don't lie. Here is why fitness enthusiasts across Baner, Balewadi, Aundh, and Pashan trust PowerZone.",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp),
            color = TextMuted
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Stats Grid
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatBox(
                value = GymConstants.MEMBERS_TRAINED,
                label = "Members Trained",
                subtext = "Baner & Balewadi",
                modifier = Modifier.weight(1f)
            )
            StatBox(
                value = GymConstants.YEARS_IN_BUSINESS,
                label = "Years Operating",
                subtext = "Sai Complex, Baner",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatBox(
                value = GymConstants.TRAINERS_COUNT,
                label = "ACE & K11 Certified",
                subtext = "Active Floor Coaches",
                modifier = Modifier.weight(1f)
            )
            StatBox(
                value = "98%",
                label = "Success Rate",
                subtext = "Goal Achievement",
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // 4-STEP TRANSFORMATION PROCESS
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(DeepBlueCard)
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                text = "YOUR TRANSFORMATION ROADMAP",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                ),
                color = NeonGreen
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "4 Steps to Total Transformation",
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp
            ),
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        GymConstants.PROCESS_STEPS.forEachIndexed { index, step ->
            ProcessStepCard(
                stepNumber = index + 1,
                title = step.first,
                description = step.second,
                isLast = index == GymConstants.PROCESS_STEPS.size - 1
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onBookTrialClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = NeonGreen,
                contentColor = DeepBlueDark
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "START STEP 1: BOOK FREE TRIAL",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp
                )
            )
        }
    }
}

@Composable
fun StatBox(
    value: String,
    label: String,
    subtext: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = DarkSurface),
        shape = RoundedCornerShape(14.dp),
        modifier = modifier.border(1.dp, DeepBlueCard, RoundedCornerShape(14.dp))
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.Black,
                    fontSize = 24.sp
                ),
                color = NeonGreen
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                ),
                color = Color.White
            )
            Text(
                text = subtext,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 10.sp),
                color = TextMuted
            )
        }
    }
}

@Composable
fun ProcessStepCard(
    stepNumber: Int,
    title: String,
    description: String,
    isLast: Boolean
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(DarkSurfaceVariant)
                .border(1.dp, DeepBlueCard, RoundedCornerShape(14.dp))
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(NeonGreen),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "0$stepNumber",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Black,
                        fontSize = 16.sp
                    ),
                    color = DeepBlueDark
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    ),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 12.sp,
                        lineHeight = 17.sp
                    ),
                    color = TextMuted
                )
            }
        }

        if (!isLast) {
            Box(
                modifier = Modifier
                    .padding(start = 32.dp, top = 4.dp, bottom = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowDownward,
                    contentDescription = "Next step",
                    tint = NeonGreen,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}
