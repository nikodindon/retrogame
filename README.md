# RetroGame v0.5

Application Android native (Kotlin + Jetpack Compose) proposant un catalogue de jeux d'arcade rétro.

## État actuel (v0.5 terminée, v0.6 en cours)

- Tetris complet (v0.1)
- Catalogue avec Space Invaders (v0.3), Frogger (v0.4), Asteroids (v0.5)
- Navigation complète : Accueil ↔ Jeux ↔ Paramètres
- Persistance du meilleur score (`SharedPreferences`)
- Écran d'accueil avec catalogue et bouton Paramètres
- Écran de fin avec score et bouton Rejouer / Menu
- Sons (`ToneGenerator`) sur verrouillage et fin de partie
- Bandeau visible et boutons non masqués (`statusBarsPadding` / `navigationBarsPadding`)
- Tests unitaires (`GameEngineTest`) passants
- Documentation monétisation (`docs/ADS_AND_BILLING.md`)
- APK debug : `app/build/outputs/apk/debug/app-debug.apk`

## Stack technique

- Kotlin 2.0.0 / Android Gradle Plugin 8.7.3
- Jetpack Compose (Material 3)
- Android SDK 35 / Build-tools 35.0.0
- JUnit

## Prérequis

- JDK 17
- Android SDK (`~/Android/Sdk`)
- ADB avec téléphone connecté et autorisé

## Instructions

```bash
export ANDROID_HOME=/home/niko/Android/Sdk
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
./gradlew :app:testDebugUnitTest
./gradlew :app:installDebug
```

## Fonctionnalités restantes (avant publication Play Store)

- Intégration AdMob dans `MainActivity` (dépendance + initialisation avec identifiant de test)
- Intégration Google Play Billing dans `MainActivity` (produits `retrogame_premium` et `retrogame_abonnement` non créés dans Play Console)
- Publication Play Store (nécessite accès Play Console et paiement du compte développeur)
- Politique de confidentialité rédigée : `docs/privacy-policy.md` (OK)
- APK release signé : `app-release-signed.apk` (5,7 Mo) créé avec `retrogame-release.jks` (OK)
- Keystore : `retrogame-release.jks` générée (OK)
