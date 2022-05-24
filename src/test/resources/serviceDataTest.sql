Insert into joueur( nom, pwd) VALUES
('Julien', 'pozerf'),
('Sophie', 'smdlfk'),
('Christophe', 'sdklfjoizfjeskl');


INSERT INTO partie(nbx, nby, nbjoueur, debut, fin) VALUES
(3,3,2, {ts '2012-09-17 18:47:52.69'}, {ts '2012-09-17 19:47:52.69'}),
(5,2,3, {ts '2012-09-17 18:27:52.69'}, {ts '2012-09-17 20:47:52.69'}),
(6,8,2, {ts '2012-09-17 18:37:52.69'}, {ts '2012-09-17 19:47:52.69'}),
(7,7,4, {ts '2012-09-17 18:57:52.69'}, {ts '2012-09-17 19:47:52.69'});

INSERT INTO jouer(joueur_id, partie_id, symbole, couleur) VALUES
((SELECT id from joueur where rownum=1),(SELECT id From partie where rownum=1), 'X', 'red'),
((SELECT id from joueur where rownum=2),(SELECT id From partie where rownum=1), 'O', 'blue'),
((SELECT id from joueur where rownum=1),(SELECT id From partie where rownum=2), 'X', 'red');

INSERT INTO marque(x, y, creation, jouer_id) VALUES
(1, 2, {ts '2012-09-17 18:47:52.69'}, (SELECT id from jouer where rownum=1)),
(1, 1, {ts '2012-09-17 18:47:53.69'}, (SELECT id from jouer where rownum=2)),
(0, 2, {ts '2012-09-17 18:47:54.69'}, (SELECT id from jouer where rownum=1));
