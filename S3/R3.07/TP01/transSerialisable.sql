-- 3.
-- user1
CREATE TABLE compte(numc serial primary key, client varchar(20), solde integer);
INSERT INTO compte(client, solde) VALUES ('Alice', 1000), ('Bob', 1000);

BEGIN;
UPDATE compte SET solde = solde - 100 WHERE client = 'Bob';
-- user2
SELECT * FROM compte;
-- user1
UPDATE compte SET solde = solde + 100 WHERE client = 'Alice';
-- user2
SELECT * FROM compte;
-- user1
COMMIT;
-- user2
SELECT * FROM compte;

-- Les modifications ne sont pas visibles par user2 tant que user1 n'a pas commit en mode READ COMMITTED

-- user1
BEGIN;
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
UPDATE compte SET solde = solde - 100 WHERE client = 'Bob';
-- user2
SELECT * FROM compte;
-- user1
UPDATE compte SET solde = solde + 100 WHERE client = 'Alice';
-- user2
SELECT * FROM compte;
-- user1
COMMIT;
-- user2
SELECT * FROM compte;

-- Les modifications ne sont pas visibles par user2 tant que user1 n'a pas commit en mode REPEATABLE READ

-- user1
BEGIN;
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
UPDATE compte SET solde = solde - 100 WHERE client = 'Bob';
-- user2
SELECT * FROM compte;
-- user1
UPDATE compte SET solde = solde + 100 WHERE client = 'Alice';
-- user2
SELECT * FROM compte;
-- user1
COMMIT;
-- user2
SELECT * FROM compte;

-- Les modifications ne sont pas visibles par user2 tant que user1 n'a pas commit en mode SERIALIZABLE

-- 4.
-- user1
BEGIN;
-- user2
BEGIN;
-- user1
UPDATE compte SET solde = 4000 WHERE client = 'Alice';
-- user2
UPDATE compte SET solde = 5000 WHERE client = 'Alice';
-- user1
COMMIT;
-- user2
COMMIT;

-- En mode READ COMMITTED, les modifications de user1 sont écrasées par celles de user2 puisqu'apres le commit de user1, la table est deverrouillée

-- user1
BEGIN;
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
-- user2
BEGIN;
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
-- user1
UPDATE compte SET solde = 4000 WHERE client = 'Alice';
-- user2
UPDATE compte SET solde = 5000 WHERE client = 'Alice';
-- user1
COMMIT;
-- user2
COMMIT;

-- En mode REPEATABLE READ, les modifications de user2 ne peuvent pas être appliquées à cause de l'accès concurrent à la table

-- user1
BEGIN;
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
-- user2
BEGIN;
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
-- user1
UPDATE compte SET solde = 4000 WHERE client = 'Alice';
-- user2
UPDATE compte SET solde = 5000 WHERE client = 'Alice';
-- user1
COMMIT;
-- user2
COMMIT;

-- En mode SERIALIZABLE, les modifications de user2 ne peuvent pas être appliquées à cause de l'accès concurrent à la table

-- 5.
-- Il semble que le problème de deadlock ne soit résolu par le mode SERIALISABLE :
-- user1
BEGIN;
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
-- user2
BEGIN;
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
-- user1
UPDATE compte SET solde = 4000 WHERE client = 'Alice';
-- user2
UPDATE compte SET solde = 5000 WHERE client = 'Bob';
-- user1
UPDATE compte SET solde = 4000 WHERE client = 'Bob';
-- user2
UPDATE compte SET solde = 5000 WHERE client = 'Alice';
-- user1
COMMIT;
-- user2
COMMIT;

-- 6.
-- user1
BEGIN;
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
-- user2
BEGIN;
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
-- user1
UPDATE compte SET solde = solde + (SELECT solde FROM compte WHERE client = 'Bob') WHERE client = 'Alice';
-- user2
UPDATE compte SET solde = 100 WHERE client = 'Bob';
UPDATE compte SET solde = solde + (SELECT solde FROM compte WHERE client = 'Alice') WHERE client = 'Bob';
-- user1
COMMIT;
-- user2
COMMIT;

-- On constate que les commit successifs de user1 et user2 ne sont pas bloqués par le mode REPEATABLE READ; les modifications des utilisateurs ne sont pas visibles par les autres avant le commit et les modifications appliquees sont donc incorrectes

-- user1
BEGIN;
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
-- user2
BEGIN;
SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
-- user1
UPDATE compte SET solde = solde + (SELECT solde FROM compte WHERE client = 'Bob') WHERE client = 'Alice';
-- user2
UPDATE compte SET solde = 100 WHERE client = 'Bob';
UPDATE compte SET solde = solde + (SELECT solde FROM compte WHERE client = 'Alice') WHERE client = 'Bob';
-- user1
COMMIT;
-- user2
COMMIT;

-- En mode serialisable, les modifications ne sont pas acceptees et les donnees restent coherentes en cas d'acces concurrents

