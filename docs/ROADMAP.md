# Roadmap RetroGame

## v0.1 — Premier jeu jouable (actuel)
- Tetris complet et jouable.
- Catalogue initial.
- APK debug installable et testé sur téléphone physique.
- Tests du moteur (partiels).
- Architecture Compose + interface simple.
- Monétisation non configurée.

## v0.2 — Extension UX (terminée)
- Persistance du meilleur score (`ScoreStorage` via SharedPreferences)
- Écran d'accueil avec catalogue et bouton Paramètres
- Menu paramètres (son / vibration)
- Navigation complète : Accueil ↔ Jeu ↔ Paramètres
- Bandeau visible et boutons non masqués (`statusBarsPadding` / `navigationBarsPadding`)
- Sons de jeu (`ToneGenerator`) sur verrouillage et fin de partie
- Tests unitaires (`GameEngineTest`) passants
- Écran "PERDU !" avec score final et bouton Rejouer

## v0.3 — Space Invaders
- Nouveau jeu dans le catalogue.
- Réutilisation des composants communs.

## v0.4 — Frogger
- Jeu complet, contrôles tactiles adaptés.

## v0.5 — Asteroids (terminée)
- Collisions, projectiles, moteur complet.
- Intégration dans le catalogue.

## v0.6 — Monétisation et Play Store (en cours)
- AdMob (mode test) : documentation et identifiant de test (`docs/ADS_AND_BILLING.md`)
- Google Play Billing : produits définis (premium + abonnement)
- Keystore et procédure de signature (`docs/ADS_AND_BILLING.md`)
- Politique de confidentialité (à rédiger)
- Tests instrumentés et APK release signée (étapes restantes avant publication)
