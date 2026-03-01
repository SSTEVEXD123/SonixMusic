# SonixMusic (Android APK)

App de música para Android con estética inspirada en interfaces modernas tipo Metro, pero con identidad propia (`SonixMusic`). Está preparada para funcionar **offline first** y ahora incluye **portadas visuales reemplazables** para que luego pongas tus imágenes.

## Qué incluye ahora

- UI con Jetpack Compose en tema oscuro.
- Sección de librería con tarjetas visuales y portada por canción.
- Indicadores de estado `Offline` o `Streaming`.
- Configuración de Audius (`API Key` + `Bearer Token`) centralizada en `BuildConfig`.
- Script para generar y copiar el APK debug a una carpeta de entrega.

## Dónde cambiar imágenes rápido

Reemplaza estos drawables por tus imágenes (con el mismo nombre o ajustando el código):

- `app/src/main/res/drawable/cover_midnight.xml`
- `app/src/main/res/drawable/cover_ocean.xml`
- `app/src/main/res/drawable/cover_neon.xml`
- `app/src/main/res/drawable/cover_solstice.xml`
- `app/src/main/res/drawable/cover_tape.xml`

## Compilar APK debug

```bash
./scripts/build_apk.sh
```

APK esperada al final:

```text
release/SonixMusic-debug.apk
```

## Estructura rápida

- `app/src/main/java/com/sonixmusic/ui/SonixMusicApp.kt`: pantalla principal.
- `app/src/main/java/com/sonixmusic/data/Track.kt`: modelo y librería offline inicial.
- `app/src/main/java/com/sonixmusic/data/AudiusConfig.kt`: configuración de acceso a Audius.
- `scripts/build_apk.sh`: build y copia del APK.
