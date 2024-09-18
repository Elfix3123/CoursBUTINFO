-- Lecture impropre
-- user1
BEGIN;
INSERT INTO film VALUES (1000, 'Avengers: Endgame', 2019);
-- user2
SELECT * FROM film;
-- user1
ROLLBACK;
-- Ce problème peut être résolu en utilisant le mode REPEATABLE READ

-- Perte de mise à jour 
-- user1
BEGIN;
INSERT INTO film VALUES (1000, 'Avengers: Endgame', 2017);
-- user2
BEGIN;
INSERT INTO film VALUES (1000, 'Avengers: Endgame', 2018);
-- user1
COMMIT;
-- user2
COMMIT;
-- Ce problème peut être résolu en utilisant le mode SERIALIZABLE

-- Lecture non reproductible
-- user1
BEGIN;
-- user2
SELECT * FROM film;
-- user1
INSERT INTO film VALUES (1000, 'Avengers: Endgame', 2019);
-- user2
SELECT * FROM film;
-- user1
COMMIT;
-- Ce problème peut être résolu en utilisant le mode SERIALIZABLE

-- Interblocage
-- user1
BEGIN;
-- user2
BEGIN;
-- user1
UPDATE film SET annee = 2018 WHERE id = 1000;
-- user2
UPDATE film SET annee = 2019 WHERE id = 1001;
-- user1
UPDATE film SET annee = 2019 WHERE id = 1001;
-- user2
UPDATE film SET annee = 2018 WHERE id = 1000;
-- user1
COMMIT;
-- user2
COMMIT;
-- Ce problème peut être résolu en mettant à jour les lignes dans le même ordre