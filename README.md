# Gestiondescontacts
#projetcontactejava
# projetcontactejava
VOICI LES LIEN DE DEUX VIDEO QUI EXPLIQUE BIEN NOTRE PROJET
PREMIERE PARTIE ; https://youtu.be/B-psNgy-aD8?si=I8AbT522QtAcmJY0
DEUXIEME PARTIE ; https://youtu.be/sol5B6CrhNw?si=FUnaMIAdRluYOto7

#Brève description de l’application
#L’application Gestion des Contacts est une interface graphique permettant de gérer une liste de contacts. Elle permet #d’ajouter, supprimer, modifier, rechercher et actualiser les contacts stockés dans une base de données MySQL.

#Présentation détaillée des différentes fonctionnalités de l’application
#Ajouter Contact : Ce bouton permet d’ouvrir un formulaire pour ajouter un nouveau contact à la base de données. #L’utilisateur peut entrer le nom, le numéro de téléphone et l’adresse email du contact.
#Supprimer Contact : Ce bouton permet de supprimer le contact sélectionné dans le tableau. L’utilisateur doit sélectionner #un contact dans la liste, puis cliquer sur ce bouton pour le supprimer de la base de données.
#Modifier Contact : Ce bouton permet de modifier les informations du contact sélectionné. L’utilisateur peut mettre à jour #le nom, le numéro de téléphone et l’adresse email du contact sélectionné.
#Rechercher Contact : Ce bouton permet de rechercher un contact spécifique dans la base de données. L’utilisateur peut #entrer un critère de recherche (par exemple, le nom) et le tableau affichera les résultats correspondants.
#Actualiser : Ce bouton permet de recharger les données du tableau pour afficher les informations les plus récentes des #contacts depuis la base de données.
#Instructions pour compiler et exécuter le projet
#Pré-requis :
#Java Development Kit (JDK) installé.
#Serveur MySQL en cours d’exécution.
#Base de données MySQL nommée contacts avec une table appropriée pour stocker les informations des contacts.
#Étapes pour compiler et exécuter :
#Étape 1 : Ouvrir un terminal ou une invite de commandes.
#Étape 2 : Naviguer vers le répertoire contenant le fichier GestionContacts.java.
#Étape 3 : Compiler le fichier Java en utilisant la commande :
#javac GestionContacts.java

#Étape 4 : Exécuter le fichier compilé en utilisant la commande :
#java GestionContacts

#Ces étapes te permettront de compiler et d’exécuter l’application de gestion des contacts.

GESTION DE CONTACTS 
    Pour notre projet nous avons:

#1 Importation des bibliothèques :
      Le code commence par importer les bibliothèques nécessaires pour créer une interface graphique (Swing) et pour se connecter à une base de données MySQL.
Connexion à la base de données : Les informations de connexion à la base de données (URL, utilisateur, mot de passe) sont définies.
#2 Création de la fenêtre principale :
      Une fenêtre principale (JFrame) est créée avec le titre “Gestion des Contacts”. La fenêtre se ferme lorsqu’on clique sur le bouton de fermeture, et sa taille est définie à 800x600 pixels.
#3 Création du panneau principal :
    Un panneau principal (JPanel) est créé pour contenir tous les autres composants.
#4 Boutons d’action : 
    Un panneau de boutons (JPanel) est créé avec cinq boutons : Ajouter, Supprimer, Modifier, Rechercher, et Actualiser. Ces boutons permettent de gérer les contacts.
#5 Tableau des contacts : 
    Un tableau (JTable) est créé pour afficher les contacts. Le tableau utilise un modèle de table (DefaultTableModel) avec des colonnes pour l’ID, le nom, le numéro et l’email (Gmail).
#Disposition des composants : Les boutons sont ajoutés en haut du panneau principal et le tableau des contacts est ajouté au centre avec une barre de défilement (JScrollPane).
#Écouteurs d’événements : Des écouteurs d’événements sont ajoutés aux boutons pour définir ce qui se passe lorsqu’on clique dessus (par exemple, ajouter un contact).
Ce code met en place une interface graphique simple pour gérer une liste de contacts, avec des fonctionnalités pour ajouter, supprimer, modifier, rechercher et actualiser les contacts dans une base de données MySQL. 
