# SonixMusic (Android APK)

App de música para Android con estética inspirada en interfaces modernas tipo Metro, pero con identidad propia (`SonixMusic`). Está preparada para funcionar **offline first** con una librería local de canciones y diseño listo para escalar.

## Qué incluye ahora

- UI con Jetpack Compose en tema oscuro.
- Sección de librería con tarjetas visuales (portadas por gradientes y metadata).
- Indicadores de estado `Offline` o `Streaming`.
- Configuración de Audius (`API Key` + `Bearer Token`) centralizada en `BuildConfig`.

## Estructura rápida

- `app/src/main/java/com/sonixmusic/ui/SonixMusicApp.kt`: pantalla principal.
- `app/src/main/java/com/sonixmusic/data/Track.kt`: modelo y librería offline inicial.
- `app/src/main/java/com/sonixmusic/data/AudiusConfig.kt`: configuración de acceso a Audius.

## Compilar APK debug

```bash
./gradlew assembleDebug
```

APK esperada:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Próximos pasos recomendados

1. Integrar reproductor real (ExoPlayer / Media3).
2. Sincronizar catálogo de Audius y cachear para uso offline.
3. Persistir descargas y playlists en Room.
4. Añadir búsqueda, favoritos y pantalla de reproducción completa.
