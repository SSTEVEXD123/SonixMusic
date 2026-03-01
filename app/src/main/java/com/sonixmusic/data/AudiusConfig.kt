package com.sonixmusic.data

import com.sonixmusic.BuildConfig

object AudiusConfig {
    const val baseUrl: String = "https://discoveryprovider.audius.co/v1/"
    val apiKey: String = BuildConfig.AUDIUS_API_KEY
    val bearerToken: String = BuildConfig.AUDIUS_BEARER_TOKEN
}
