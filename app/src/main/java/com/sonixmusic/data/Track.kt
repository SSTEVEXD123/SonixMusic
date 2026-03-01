package com.sonixmusic.data

import androidx.compose.ui.graphics.Color

data class Track(
    val title: String,
    val artist: String,
    val duration: String,
    val gradientStart: Color,
    val gradientEnd: Color,
    val isDownloaded: Boolean
)

object OfflineLibrary {
    val tracks = listOf(
        Track("Midnight Flow", "Kairo Beats", "3:22", Color(0xFF5D8BFF), Color(0xFF1B2440), true),
        Track("Ocean Echoes", "Ari Nova", "4:11", Color(0xFF61D4B3), Color(0xFF20463D), true),
        Track("Neon Skyline", "Viktor Lane", "2:58", Color(0xFFFF8A65), Color(0xFF4F2A1F), false),
        Track("Solstice", "Luna Arp", "3:45", Color(0xFFCC8CFF), Color(0xFF342048), true),
        Track("Summer Tape", "The Drift", "3:05", Color(0xFFFFD166), Color(0xFF4A3916), false)
    )
}
