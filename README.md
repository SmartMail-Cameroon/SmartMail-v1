# 🌍 SmartMail EcoManager  
Une application écologique pour gérer vos e-mails et contribuer à la réduction des émissions de CO₂.  

---

## 📌 Concept de l'Application  

SmartMail EcoManager aide les utilisateurs à :  
- Supprimer les e-mails inutiles.  
- Organiser les boîtes aux lettres efficacement grâce à l'IA.  
- Réduire leur empreinte carbone numérique en économisant de l'espace de stockage.  

---

## 🎯 Objectifs  
- **Organisation** : Maintenir les boîtes aux lettres propres et bien classées.  
- **Durabilité** : Sensibiliser à l'impact écologique de la communication numérique.  
- **Économie** : Réduire les émissions de CO₂ en optimisant l'espace de stockage.  

---

## 🚀 Fonctionnalités Principales  

### 1. **Inscription et Création de Compte**  
- Les utilisateurs créent un compte en fournissant :  
  - Nom  
  - Adresse e-mail  
  - Mot de passe (crypté avec Argon2).  
- 🔒 Données sécurisées avec cryptage moderne.  

**Objectif** : Une expérience personnalisée pour chaque utilisateur.  

### 2. **Connexion avec des Comptes de Messagerie**  
- Connexion sécurisée via des protocoles comme OAuth 2.0.  
- Prise en charge des services : Gmail, Outlook, Yahoo, etc.  

**Objectif** : Analyser et organiser les e-mails de plusieurs comptes.  

### 3. **Analyse et Organisation Automatiques**  
- L'IA trie les e-mails en catégories :  
  - **Important**  
  - **Spam**  
  - **Publicité**  
  - **Newsletter**  
- Règles personnalisées configurables :  
  - Supprimer les e-mails d'un expéditeur spécifique.  
  - Déplacer automatiquement certains e-mails.  

**Objectif** : Supprimer les e-mails non essentiels tout en préservant ceux importants.  

### 4. **Statistiques et Rapports**  
- Données affichées :  
  - Nombre d'e-mails supprimés.  
  - Espace de stockage économisé.  
  - Réduction des émissions de CO₂ (comparée à l'équivalent en kilomètres de voiture).  
- Rapports mensuels pour illustrer l'impact environnemental.  

**Objectif** : Offrir une visibilité sur l'impact écologique de l'application.  

### 5. **Filtres Personnalisables**  
- Créez vos propres règles :  
  - Supprimer automatiquement les e-mails provenant de certains domaines.  
  - Trier les e-mails selon des mots-clés dans l'objet.  

**Objectif** : Un contrôle maximal sur l'organisation des e-mails.  

### 6. **Durabilité et Conscience Écologique**  
- Calcul automatique des économies de CO₂.  
- Comparaisons environnementales : énergie économisée ou kilomètres de voiture évités.  

**Objectif** : Sensibiliser les utilisateurs à leur impact écologique numérique.  

---

## 🖥️ Interface Utilisateur  

### 1. **Tableau de Bord**  
- Catégories d'e-mails : Important, Publicité, Spam.  
- Statistiques et diagrammes :  
  - Économies de CO₂.  
  - Nombre et types d'e-mails supprimés.  
- Options rapides :  
  - Analyse des e-mails.  
  - Modification des filtres.  
  - Consultation des rapports.  

### 2. **Rapports et Statistiques**  
- Graphiques détaillés :  
  - Nombre d'e-mails supprimés.  
  - Économies mensuelles de stockage et de CO₂.  

### 3. **Paramètres**  
- Gestion des comptes de messagerie connectés.  
- Personnalisation des filtres et des règles.  
- Activation/désactivation de certaines fonctions (ex. suppression automatique).  

### 4. **Notifications**  
- Alertes sur les actions effectuées :  
  - « 50 spams ont été supprimés. »  
  - « Vous avez économisé 10 Mo d'espace de stockage et 0,02 kg de CO₂ aujourd'hui. »  

---

## 🧠 Intégration de l'Intelligence Artificielle  

- Utilisation de modèles NLP (Natural Language Processing) pour l'analyse des e-mails :  
  - Basés sur le cloud (Google AI, AWS Comprehend).  
  - Possibilité de modèles personnalisés (TensorFlow, PyTorch).  

---

## 🔒 Sécurité  

- **Transmission des données** : Protocole de cryptage moderne (HTTPS).  
- **Stockage des données** : Données cryptées avec Argon2.  

---

## 📂 Structure du Projet  

Voici la structure du projet **SmartMail EcoManager** :  

```bash
- SmartMail/
  - app/
    - src/
      - main/
        - kotlin/com/smartmail/
          - ui/
            - screens/
              - intro/
                - IntroScreen.kt
                - IntroViewModel.kt
              - auth/
                - LoginScreen.kt
                - SignupScreen.kt
                - AuthViewModel.kt
              - inbox/
                - InboxScreen.kt
                - EmailCard.kt
                - InboxViewModel.kt
              - spam/
                - SpamScreen.kt
                - SpamViewModel.kt
              - settings/
                - SettingsScreen.kt
                - SettingsViewModel.kt
            - components/
              - CommonButton.kt
              - CommonTextField.kt
            - theme/
              - Color.kt
              - Typography.kt
              - Shape.kt
              - Theme.kt
          - navigation/
            - AppNavGraph.kt
          - utils/
            - Constants.kt
            - Extensions.kt
        - res/
          - drawable/
          - layout/
          - values/
    - test/ (Tests unitaires avec JUnit)
    - androidTest/ (Tests UI avec Espresso)
```
## 🛠️ Technologies Utilisées  

- **Langage** : Kotlin  
- **Framework UI** : Jetpack Compose  
- **Architecture** : MVVM  
- **IA** : NLP via Google AI / AWS Comprehend  
- **Sécurité** : OAuth 2.0, Argon2, HTTPS  
- **Tests** : JUnit (unitaires), Espresso (UI)  

---

## 🌟 Objectif Global  

Créer une application simple, efficace et durable qui aide les utilisateurs à gérer leurs e-mails tout en contribuant activement à la réduction de l'empreinte carbone numérique.  



