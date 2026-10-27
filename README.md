# RetroGame v0.1

Application Android native (Kotlin + Jetpack Compose) proposant un catalogue de jeux d'arcade rétro.

## État v0.1

- Moteur Tetris complet et jouable (7 pièces, rotation, collisions, score, niveaux).
- Écran de jeu avec contrôles tactiles.
- Compilation et installation sur téléphone Realme RMX3710 (Android 15 / API 35) réussies.
- APK debug généré : `app/build/outputs/apk/debug/app-debug.apk` (8,3 Mo).

## Stack technique

- Kotlin 2.0.0 / Android Gradle Plugin 8.7.3
- Jetpack Compose (Material 3)
- Android SDK 35 / Build-tools 34-37
- JUnit (tests unitaires préparés)

## Prérequis

- JDK 17
- Android SDK (platforms android-35, build-tools 35.0.0)
- ADB (téléphone connecté et autorisé)

## Instructions

```bash
export ANDROID_HOME=/home/niko/Android/Sdk
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
./gradlew :app:installDebug
```

## Fonctionnalités restantes

- Persistance du meilleur score (SharedPreferences).
- Monétisation (AdMob de test, Google Play Billing non configuré).
- Tests instrumentés sur le téléphone.
- Publication Play Store (keystore, politique de confidentialité, consentement publicitaire).
