# Rapport de livraison RetroGame v0.1

## Résumé
Projet Android natif Kotlin + Compose avec Tetris jouable. Compilé, installé et lancé sur téléphone physique (Realme RMX3710, Android 15 / API 35).

## Architecture
- Kotlin, Jetpack Compose, Material 3
- Moteur Tetris séparé (GameEngine.kt)
- Écran jeu (GameScreen.kt) + MainActivity

## Fonctionnalités Tetris opérationnelles
- 7 pièces (I, O, T, S, Z, J, L)
- Rotation, déplacements, hard drop
- Détection collisions, verrouillage, suppression lignes
- Score et niveau progressif
- Redémarrage
- Contrôles tactiles (boutons)

## Tests
- Tests unitaires du moteur non automatisés dans cette livraison (manque temps)
- Application installée et lancée sur téléphone via ADB : OK
- APK debug : /home/niko/projects/retrogame/app/build/outputs/apk/debug/app-debug.apk (8,3 Mo)

## Problèmes et corrections
- SDK Android minimal détecté et configuré
- Plugin Android récupéré depuis projet NovaAtlas existant
- Erreurs Kotlin corrigées itérativement (types, imports, accès privé)
- Le jeu fonctionne mais la persistance du score et la monétisation ne sont pas configurées.

## GitHub
- Dépôt local initialisé (master)
- Push non tenté (pas d'authentification demandée et dépôt distant vide)
- Commits logiques réalisés

## Tâches restantes avant publication
- Persister meilleur score (SharedPreferences)
- Configurer AdMob (identifiants de test)
- Créer produits Play Console pour Billing
- Ajouter politique de confidentialité
- Générer keystore et APK release signé
- Compléter tests automatisés
