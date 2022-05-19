
DROP TABLE IF EXISTS Joueur;
CREATE TABLE Joueur (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nom VARCHAR not null,
  marque CHAR
);

DROP TABLE IF EXISTS Partie;
CREATE TABLE Partie (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  joueur_id INT foreign key References Joueur(id),
  jeu_id INT,
  debut timestamp not null,
  fin timestamp,
  Unique (joueur_id, jeu_id)
);

DROP TABLE IF EXISTS Marque;
CREATE TABLE Marque (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  partie_id foreign key References partie(id),
  x INT not null,
  y INT not null,
  creation timestamp
);