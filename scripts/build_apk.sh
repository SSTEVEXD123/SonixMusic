#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT_DIR"

if ! command -v gradle >/dev/null 2>&1; then
  echo "Gradle no encontrado en PATH."
  exit 1
fi

if command -v mise >/dev/null 2>&1; then
  export JAVA_HOME="$(mise where java@17.0.2)"
fi

APK_PATH="app/build/outputs/apk/debug/app-debug.apk"
OUT_DIR="release"
OUT_APK="$OUT_DIR/SonixMusic-debug.apk"

mkdir -p "$OUT_DIR"

if [ -x ./gradlew ]; then
  ./gradlew assembleDebug
else
  gradle assembleDebug
fi

cp "$APK_PATH" "$OUT_APK"
echo "APK lista en: $OUT_APK"
