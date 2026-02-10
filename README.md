Gestion des Absences – GsAbsence
<p align="center"> <img src="src/GsAbsence-logo.png" alt="Logo de l'application" width="600"> </p>

GsAbsence est une application de gestion des absences des employés.
Elle permet de gérer les employés, les types d’absences et le suivi des absences, avec des statistiques graphiques.
L’application est développée en Java (Swing) avec une base de données MySQL.

🎯 Objectif du Projet
L’objectif de ce projet est de faciliter la gestion des absences au sein d’une entreprise en automatisant :
L’enregistrement des absences,
Le suivi des employés,
La gestion des types d’absences,
La visualisation des statistiques.

✅ Fonctionnalités Principales</br></br>
  Authentification</br>
  Connexion utilisateur</br>
Inscription</br>
Gestion des Employés</br>
Ajout, modification et suppression</br>
Affectation par département et poste</br>
Gestion des Types d’Absence</br>
Maladie, congé, autorisation, etc.</br>
Justification obligatoire ou non</br>
Gestion des Absences</br>
Enregistrement des absences avec dates</br>
Association employé / type d’absence</br>
Filtrage par employé</br>
Statistiques</br>
Nombre d’absences par employé </br>
Nombre d’absences par type</br>
Visualisation graphique (JFreeChart)</br>

📄 Structure de la Base de Données

Table	Description</br>
employe	Informations des employés</br>
type_absence	Types d’absences</br>
absence	Absences enregistrées</br>
user	Utilisateurs de l’application</br>

🖥️ Technologies et Bibliothèques Utilisées

Java Swing : Interface graphique</br>
MySQL : Base de données relationnelle</br>
JDBC (MySQL Connector/J) : Connexion Java ↔ MySQL</br>
JCalendar : Gestion des dates</br>
JFreeChart : Statistiques graphiques</br>
Inno Setup : Génération de l’installateur Windows</br>

📊 Schéma SQL de la Base de Données

</br></br>
CREATE TABLE employe (</br>
  id INT AUTO_INCREMENT PRIMARY KEY,</br>
  nom VARCHAR(100) NOT NULL,</br>
  departement VARCHAR(100) NOT NULL,</br>
  poste VARCHAR(100) NOT NULL</br>
);</br>
</br></br>
CREATE TABLE type_absence (</br>
  id INT AUTO_INCREMENT PRIMARY KEY,</br>
  libelle VARCHAR(100) NOT NULL,</br>
  justification VARCHAR(50)</br>
);</br>
</br></br>
CREATE TABLE absence (</br>
  id INT AUTO_INCREMENT PRIMARY KEY,</br>
  employe_id INT NOT NULL,</br>
  type_absence_id INT NOT NULL,</br>
  date_debut DATE NOT NULL,</br>
  date_fin DATE NOT NULL,</br>
  FOREIGN KEY (employe_id) REFERENCES employe(id),</br>
  FOREIGN KEY (type_absence_id) REFERENCES type_absence(id)</br>
);</br>
</br></br>
CREATE TABLE user (</br>
  id INT AUTO_INCREMENT PRIMARY KEY,</br>
  username VARCHAR(50) UNIQUE NOT NULL,</br>
  email VARCHAR(100) UNIQUE NOT NULL,</br>
  passeword VARCHAR(255) NOT NULL,</br>
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP</br>
);</br>
</br>
🏢 Architecture du Projet

 GsAbsence/
 
          ├── gsabsence/
          │   ├── GsAbsence.java        # Point d’entrée
          │   ├── Home.java             # Fenêtre principale
          │   ├── Login.java            # Authentification
          │   ├── Registre.java         # Inscription
          │   └── ResetPassword.java
          │
          ├── gsabsence.UI/
          │   ├── AbsenceUI.java
          │   ├── EmployeUI.java
          │   ├── TypeAbsenceUI.java
          │   ├── ChartsAbsenceEmploye.java
          │   └── ChartsAbsenceParType.java
          │
          ├── gsabsence.entities/
          │   ├── Employe.java
          │   ├── Absence.java
          │   ├── TypeAbsence.java
          │   └── User.java
          │
          ├── gsabsence.service/
          │   ├── EmployeService.java
          │   ├── AbsenceService.java
          │   ├── typeAbsenceService.java
          │   └── userService.java
          │
          ├── gsabsence.dao/
          │   └── IDao.java
          │
          ├── gsabsence.connexion/
          │   └── Connexion.java
          │
          ├── gsabsence.util/
          │   └── UiUtils.java
          │
          ├── images/
          │   ├── logo.png
          │   ├── class_diagram.png
          │   └── use_case.png
          │
          └── README.md

🗂️ Diagrammes UML

📌 Diagramme de Cas d’Utilisation
<p align="center"> <img src="Diagramme_Use_Case.png" alt="Diagramme de cas d'utilisation" width="700"> </p>
📌 Diagramme de Classes
<p align="center"> <img src="diagrameClass.png" alt="Diagramme de classes" width="700"> </p>
📽️ Démonstration Vidéo
<a href="https://drive.google.com/file/d/1PvvS6bx7giSMEzhsb9BKjFIdn9k3nCy1/view?usp=sharing">ici</a>
 

https://github.com/user-attachments/assets/1bf83cb3-e1f4-46fd-8c0a-2f9a1c13b9f6


🔒 Gestion des Utilisateurs
L’application gère des utilisateurs authentifiés permettant :
L’accès sécurisé à l’application
La gestion complète des données
La séparation entre interface et logique métier

⚙️ Architecture MVC
Modèle : entities, dao
Vue : gsabsence.UI (Swing)
Contrôleur / Services : service
Connexion DB : connexion

## 🤝 Contributeurs
BOUAICHI bADR

Encadrant: <a href="https://www.linkedin.com/in/mohamed-lachgar-33394b15/" target="_blank">**LACHGAR Mohamed**</a>
