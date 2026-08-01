package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.GalleryItem
import com.example.model.GymConstants
import com.example.model.Testimonial
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
fun TestimonialsAndGallerySection(viewModel: PowerZoneViewModel) {
    val activeGalleryFilter by viewModel.galleryCategoryFilter.collectAsState()
    val galleryCategories = listOf("All", "Gym Floor", "Cardio Zone", "Personal Training", "Group Studio", "Transformations", "Steam Room", "Ladies Batch")

    val filteredGallery = if (activeGalleryFilter == "All") {
        GymConstants.GALLERY_ITEMS
    } else {
        GymConstants.GALLERY_ITEMS.filter { it.category.contains(activeGalleryFilter, ignoreCase = true) || it.tag.contains(activeGalleryFilter, ignoreCase = true) }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkBackground)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        // TESTIMONIALS SECTION
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(DeepBlueCard)
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                text = "MEMBER STORIES & RESULTS",
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
            text = "Loved by Baner, Balewadi & Pashan",
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp
            ),
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        GymConstants.TESTIMONIALS.forEach { item ->
            TestimonialCard(item)
            Spacer(modifier = Modifier.height(12.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))

        // GALLERY SECTION
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(DeepBlueCard)
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                text = "STUDIO TOUR & AMENITIES",
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
            text = "4,000 Sq.Ft World-Class Studio Gallery",
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp
            ),
            color = Color.White
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Gallery Filter Chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            galleryCategories.forEach { cat ->
                val isSel = activeGalleryFilter == cat
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(if (isSel) NeonGreen else DarkSurfaceVariant)
                        .border(1.dp, if (isSel) NeonGreen else DeepBlueCard, RoundedCornerShape(16.dp))
                        .clickable { viewModel.setGalleryCategoryFilter(cat) }
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = cat,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 11.sp,
                            fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal
                        ),
                        color = if (isSel) DeepBlueDark else Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Gallery Grid Cards
        filteredGallery.forEach { gItem ->
            GalleryCard(gItem)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun TestimonialCard(item: Testimonial) {
    Card(
        colors = CardDefaults.cardColors(containerColor = DarkSurface),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, DeepBlueCard, RoundedCornerShape(16.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(NeonGreen),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = item.name.first().toString(),
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Black,
                                color = DeepBlueDark
                            )
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(
                            text = item.name,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            ),
                            color = Color.White
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "Locality",
                                tint = NeonGreen,
                                modifier = Modifier.size(12.dp)
                            )
                            Spacer(modifier = Modifier.width(2.dp))
                            Text(
                                text = item.locality,
                                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 11.sp),
                                color = TextMuted
                            )
                        }
                    }
                }

                // Result Badge
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(DeepBlueCard)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = item.result,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        color = NeonGreen
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Rating Stars
            Row {
                repeat(item.rating) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "\"${item.review}\"",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 13.sp,
                    lineHeight = 19.sp
                ),
                color = Color.White
            )
        }
    }
}

@Composable
fun GalleryCard(item: GalleryItem) {
    Card(
        colors = CardDefaults.cardColors(containerColor = DarkSurfaceVariant),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, DeepBlueCard, RoundedCornerShape(14.dp))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    ),
                    color = Color.White
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(NeonGreen.copy(alpha = 0.2f))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = item.tag,
                        style = MaterialTheme.typography.labelLarge.copy(fontSize = 10.sp),
                        color = NeonGreen
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp, lineHeight = 17.sp),
                color = TextMuted
            )
        }
    }
}
