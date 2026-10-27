# Environnement RetroGame v0.1

Date: 27 oct. 2026

## OS
Linux Mint 22.3 (Zena), Ubuntu noble base.

## Java
OpenJDK 17.0.20.1 (compatible Android).
JAVA_HOME non défini par défaut.

## Android SDK
Emplacement: ~/Android/Sdk
ANDROID_HOME: doit être exporté (non défini par défaut).
Platform-tools: 35.0.3
Build-tools: 34.0.0, 35.0.0, 37.0.0
Plateformes: android-34, android-35

## Téléphone connecté
Modèle: Realme RMX3710 (REE2ADL1)
Android 15 (API 35)
Transport USB actif, autorisé.

## Gradle
Gradle wrapper /~/gradle-8.7/bin/gradle disponible.

## Kotlin
Non installé globalement. Utiliser le Kotlin intégré au plugin Android.

## Git
Git 2.43.0 disponible.
Dépôt distant: https://github.com/nikodindon/retrogame.git (vide, initialisation nécessaire).

## ADB
/usb/bin/adb et ~/Android/Sdk/platform-tools/adb disponibles.
Appareil autorisé et détecté.

## Limites détectées
- Kotlin non présent dans PATH global.
- Android SDK minimal mais fonctionnel.
- Pas d'Android Studio complet détecté (SDK command-line présent).
- Le dépôt GitHub est vide et doit être initialisé.
