package com.sonixmusic.ui

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonixmusic.data.OfflineLibrary
import com.sonixmusic.data.Track

@Composable
fun SonixMusicApp() {
    var selectedTab by remember { mutableStateOf(0) }

    MaterialTheme {
        Scaffold(
            containerColor = Color(0xFF090D14),
            bottomBar = {
                NavigationBar(containerColor = Color(0xFF111827)) {
                    listOf("Inicio", "Biblioteca", "Offline").forEachIndexed { index, label ->
                        NavigationBarItem(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            icon = {},
                            label = { Text(label) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedTextColor = Color(0xFF8AA7FF),
                                unselectedTextColor = Color(0xFF9CA3AF),
                                indicatorColor = Color(0xFF1F2937)
                            )
                        )
                    }
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(18.dp))
                Text("SonixMusic", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Text(
                    "Diseño inspirado en apps modernas, con enfoque 100% offline",
                    color = Color(0xFF9CA3AF)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    AssistChip(
                        onClick = {},
                        label = { Text("Descargadas") },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = Color(0xFF1B2440),
                            labelColor = Color(0xFFC8D5FF)
                        )
                    )
                    AssistChip(
                        onClick = {},
                        label = { Text("Para viaje") },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = Color(0xFF18212B),
                            labelColor = Color(0xFFA7EBD8)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))

                LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(OfflineLibrary.tracks) { track ->
                        TrackCard(track)
                    }
                }
            }
        }
    }
}

@Composable
private fun TrackCard(track: Track) {
    Surface(
        tonalElevation = 2.dp,
        shadowElevation = 4.dp,
        color = Color(0xFF131A27),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(56.dp)
                    .height(56.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Brush.linearGradient(listOf(track.gradientStart, track.gradientEnd)))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(track.title, color = Color.White, fontWeight = FontWeight.SemiBold)
                Text(track.artist, color = Color(0xFF9CA3AF), fontSize = 13.sp)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(track.duration, color = Color(0xFFCBD5E1), fontSize = 12.sp)
                Text(
                    if (track.isDownloaded) "Offline" else "Streaming",
                    color = if (track.isDownloaded) Color(0xFF7EE787) else Color(0xFFFBBF24),
                    fontSize = 12.sp
                )
            }
        }
    }
}
