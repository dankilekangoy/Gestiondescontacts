﻿# Gestiondescontacts
#projetcontactejava
# projetcontactejava
VOICI LES LIEN DE DEUX VIDEO QUI EXPLIQUE BIEN NOTRE PROJET
PREMIERE PARTIE ; https://youtu.be/B-psNgy-aD8?si=I8AbT522QtAcmJY0
DEUXIEME PARTIE ; https://youtu.be/sol5B6CrhNw?si=FUnaMIAdRluYOto7

GESTION DE CONTACTS 
    Pour notre projet nous avons:

1 Importation des bibliothèques :
      Le code commence par importer les bibliothèques nécessaires pour créer une interface graphique (Swing) et pour se connecter à une base de données MySQL.
Connexion à la base de données : Les informations de connexion à la base de données (URL, utilisateur, mot de passe) sont définies.
2 Création de la fenêtre principale :
      Une fenêtre principale (JFrame) est créée avec le titre “Gestion des Contacts”. La fenêtre se ferme lorsqu’on clique sur le bouton de fermeture, et sa taille est définie à 800x600 pixels.
3 Création du panneau principal :
    Un panneau principal (JPanel) est créé pour contenir tous les autres composants.
4 Boutons d’action : 
    Un panneau de boutons (JPanel) est créé avec cinq boutons : Ajouter, Supprimer, Modifier, Rechercher, et Actualiser. Ces boutons permettent de gérer les contacts.
5 Tableau des contacts : 
    Un tableau (JTable) est créé pour afficher les contacts. Le tableau utilise un modèle de table (DefaultTableModel) avec des colonnes pour l’ID, le nom, le numéro et l’email (Gmail).
Disposition des composants : Les boutons sont ajoutés en haut du panneau principal et le tableau des contacts est ajouté au centre avec une barre de défilement (JScrollPane).
Écouteurs d’événements : Des écouteurs d’événements sont ajoutés aux boutons pour définir ce qui se passe lorsqu’on clique dessus (par exemple, ajouter un contact).
Ce code met en place une interface graphique simple pour gérer une liste de contacts, avec des fonctionnalités pour ajouter, supprimer, modifier, rechercher et actualiser les contacts dans une base de données MySQL. 
