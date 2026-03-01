package com.sonixmusic.data

import com.sonixmusic.R

data class Track(
    val title: String,
    val artist: String,
    val duration: String,
    val coverRes: Int,
    val isDownloaded: Boolean
)

object OfflineLibrary {
    val tracks = listOf(
        Track("Midnight Flow", "Kairo Beats", "3:22", R.drawable.cover_midnight, true),
        Track("Ocean Echoes", "Ari Nova", "4:11", R.drawable.cover_ocean, true),
        Track("Neon Skyline", "Viktor Lane", "2:58", R.drawable.cover_neon, false),
        Track("Solstice", "Luna Arp", "3:45", R.drawable.cover_solstice, true),
        Track("Summer Tape", "The Drift", "3:05", R.drawable.cover_tape, false)
    )
}
