# Backend de l'application de type Kahoot

Ce service backend est conçu pour une application de type Kahoot, permettant aux utilisateurs de créer, gérer et participer à des quiz et des jeux. Il fournit des API RESTful pour interagir avec les sessions de jeu, les kahoots (quiz), les questions et les utilisateurs.

## Table des matières
- [Fonctionnalités](#fonctionnalités)
- [Technologies utilisées](#technologies-utilisées)
- [Installation](#installation)
- [Utilisation](#utilisation)
  - [Gestion des utilisateurs](#gestion-des-utilisateurs)
  - [Gestion des Kahoots](#gestion-des-kahoots)
  - [Gestion des questions](#gestion-des-questions)
  - [Gestion des sessions de jeu](#gestion-des-sessions-de-jeu)
- [Points de terminaison de l'API](#points-de-terminaison-de-lapi)
- [Contribuer](#contribuer)
- [Licence](#licence)

## Fonctionnalités
- **Gestion des utilisateurs** : Créer, mettre à jour, récupérer et supprimer des utilisateurs.
- **Gestion des Kahoots** : Créer et récupérer des quiz (Kahoots).
- **Gestion des questions** : Ajouter des questions aux Kahoots, en prenant en charge les types à choix multiple et vrai/faux.
- **Gestion des sessions de jeu** : Créer et gérer des sessions de jeu pour les quiz, permettant aux joueurs de rejoindre et de participer.

## Technologies utilisées
- Java
- Jakarta EE (JAX-RS pour les API REST)
- JPA (Java Persistence API) pour les opérations sur la base de données
- DTOs personnalisés et mappers pour le transfert de données

## Installation
1. **Cloner le dépôt** :
   ```bash
   git clone <url-du-dépôt>
   cd <répertoire-du-dépôt>


## Utilisation

### Gestion des utilisateurs

- **Créer un utilisateur**
  - **POST** `/users`
  - Corps : `{"username": "exempleUtilisateur", "email": "utilisateur@exemple.com"}`
  - Réponse : Renvoie l'utilisateur créé.

- **Obtenir un utilisateur par ID**
  - **GET** `/users/{userId}`
  - Réponse : Renvoie l'objet utilisateur.

- **Obtenir tous les utilisateurs**
  - **GET** `/users`
  - Réponse : Renvoie une liste de tous les utilisateurs.

- **Mettre à jour un utilisateur**
  - **PUT** `/users/{userId}`
  - Corps : `{"username": "nouveauNomUtilisateur", "email": "nouveauEmail@exemple.com"}`
  - Réponse : Renvoie l'utilisateur mis à jour.

- **Supprimer un utilisateur**
  - **DELETE** `/users/{userId}`
  - Réponse : Pas de contenu en cas de succès.

### Gestion des Kahoots

- **Créer un Kahoot**
  - **POST** `/kahoots/{userId}`
  - Corps : `{"title": "Titre du Kahoot", "description": "Description du Kahoot"}`
  - Réponse : Renvoie le Kahoot créé.

- **Obtenir tous les Kahoots**
  - **GET** `/kahoots`
  - Réponse : Renvoie une liste de tous les Kahoots.

- **Obtenir un Kahoot par ID**
  - **GET** `/kahoots/{id}`
  - Réponse : Renvoie le Kahoot spécifié.

### Gestion des questions

- **Créer une question**
  - **POST** `/questions/{kahootId}`
  - Corps : `{"content": "Quelle est la capitale de la France ?", "typeQuestion": "multiple_choice", "answers": [...]}` 
  - Réponse : Renvoie la question créée.

### Gestion des sessions de jeu

- **Créer une session de jeu**
  - **POST** `/gamesessions/{kahootId}`
  - Réponse : Renvoie les détails de la session de jeu créée.

## Points de terminaison de l'API

Voici un résumé des points de terminaison disponibles :

### API Utilisateur
| Méthode | Point de terminaison     | Description                         |
|---------|--------------------------|-------------------------------------|
| POST    | /users                   | Créer un nouvel utilisateur          |
| GET     | /users/{userId}         | Récupérer un utilisateur par ID      |
| GET     | /users                   | Récupérer tous les utilisateurs     |
| PUT     | /users/{userId}         | Mettre à jour les détails de l'utilisateur |
| DELETE  | /users/{userId}         | Supprimer un utilisateur            |

### API Kahoot
| Méthode | Point de terminaison        | Description                          |
|---------|-----------------------------|--------------------------------------|
| POST    | /kahoots/{userId}          | Créer un nouveau Kahoot              |
| GET     | /kahoots                   | Récupérer tous les Kahoots          |
| GET     | /kahoots/{id}              | Récupérer un Kahoot spécifique      |

### API Questions
| Méthode | Point de terminaison         | Description                       |
|---------|------------------------------|-----------------------------------|
| POST    | /questions/{kahootId}        | Créer une nouvelle question pour un Kahoot |

### API Sessions de Jeu
| Méthode | Point de terminaison            | Description                       |
|---------|----------------------------------|-----------------------------------|
| POST    | /gamesessions/{kahootId}        | Créer une nouvelle session de jeu |

## Contribuer

Si vous souhaitez contribuer à ce projet, veuillez forker le dépôt et soumettre une demande de tirage. Vos contributions sont les bienvenues !
# my-app-kahoot
