# Monétisation et Play Store

## AdMob (test)
Identifiant de test : `ca-app-pub-2776142788958553~6881853090` (déjà référencé dans NovaAtlas).
Pour activer : ajouter la dépendance dans `build.gradle.kts` et initialiser dans `MainActivity`.

## Google Play Billing
Produits à créer dans Play Console :
- `retrogame_premium` (achat unique) — déverrouille tout le catalogue
- `retrogame_abonnement` (abonnement mensuel) — accès premium

## Keystore et publication
Créer la keystore :
```bash
keytool -genkey -v -keystore retrogame-release.jks -keyalg RSA -keysize 2048 -validity 10000 -alias retrogame
```

Signer l'APK release :
```bash
./gradlew :app:assembleRelease
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore retrogame-release.jks app/build/outputs/apk/release/app-release-unsigned.apk retrogame
```

## Politique de confidentialité
Fichier obligatoire : `docs/privacy-policy.md`. Doit mentionner :
- Collecte minimale (aucune donnée personnelle sauf via AdMob)
- Utilisation de `SharedPreferences` local uniquement
- Pas de compte utilisateur requis
