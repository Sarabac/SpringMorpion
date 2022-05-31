Insert into joueur(id, nom, pwd) VALUES
(1,'Julien', 'pozerf'),
(2, 'Sophie', 'smdlfk'),
(3,'Christophe', 'sdklfjoizfjeskl');


INSERT INTO partie(id, nbx, nby, nbjoueur, debut, fin) VALUES
(1,3,3,2, {ts '2012-09-17 18:47:52.69'}, {ts '2012-09-17 19:47:52.69'}),
(2,5,2,3, {ts '2012-09-17 18:27:52.69'}, {ts '2012-09-17 20:47:52.69'}),
(3,6,8,2, {ts '2012-09-17 18:37:52.69'}, {ts '2012-09-17 19:47:52.69'}),
(4,7,7,4, {ts '2012-09-17 18:57:52.69'}, {ts '2012-09-17 19:47:52.69'});

INSERT INTO jouer(id, joueur_id, partie_id, symbole, couleur) VALUES
(1,1,1, 'X', 'red'),
(2,2,1, 'O', 'blue'),
(3,3,2, 'X', 'red');

INSERT INTO marque(x, y, creation, jouer_id) VALUES
(1, 2, {ts '2012-09-17 18:47:52.69'}, 1),
(1, 1, {ts '2012-09-17 18:47:53.69'}, 2),
(0, 2, {ts '2012-09-17 18:47:54.69'}, 1);
