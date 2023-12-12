--------------------------------------------------------------------------------
        -- INFORMATIONS SUR LES DONNÉES DE L'INSTANCE DE LA BD --
--------------------------------------------------------------------------------
--SET DATESTYLE TO EUROPEAN;

/*______________________________________________________________________________
BESOIN N°1.
Affichage de toutes les représentations futures
______________________________________________________________________________*/

SELECT * FROM REPRESENTATION WHERE Date > current_date AND HeureDebut > current_time;

/*______________________________________________________________________________
BESOIN N°2.
Affichage du jour, de l'heure de début, du lieu et du nombre de numéros
présentés, pour chacune des représentations futures.
Résultat ordonné sur la date, puis l'heure des représentations
______________________________________________________________________________*/

SELECT r.CodeRep, r.Date, r.HeureDebut, r.IDLieu, count(DISTINCT(p.Titre)) 
FROM REPRESENTATION r, PRESENTE p 
WHERE Date > current_date AND HeureDebut > current_time
AND p.CodeRep = r.CodeRep
GROUP BY r.CodeRep
ORDER BY r.Date, r.HeureDebut;

/*______________________________________________________________________________
BESOIN N°3.
Nombre de représentations  passées ou à venir où est présenté un numéro sous la
responsabilité de Etoile, mais aucun numéro sous la responsabilité de Bozzo
CONTRAINTE : utiliser EXISTS / NOT EXISTS pour coder ce BESOIN
______________________________________________________________________________*/

SELECT count(DISTINCT r1.CodeRep)
FROM REPRESENTATION r1
WHERE EXISTS(SELECT * FROM PRESENTE p2, NUMERO n2 WHERE r1.CodeRep = p2.CodeRep AND p2.Titre = n2.TItre AND n2.Responsable = 'Etoile')
AND NOT EXISTS(SELECT * FROM PRESENTE p2, NUMERO n2 WHERE r1.CodeRep = p2.CodeRep AND p2.Titre = n2.TItre AND n2.Responsable = 'Bozzo');

/*______________________________________________________________________________
BESOIN N°4.
Date, heure de début et adresse des représentations dans lesquelles
au moins 5 numéros sont présentés - Résultat ordonné par date, puis heure début
______________________________________________________________________________*/

SELECT r1.Date, r1.HeureDebut, l1.Adresse 
FROM REPRESENTATION r1, LIEU l1
WHERE r1.IDLieu = l1.IDLieu
AND (SELECT count(Titre) FROM PRESENTE P2 WHERE p2.CodeRep = r1.CodeRep) >= 5
ORDER BY r1.Date, R1.HeureDebut;

/*______________________________________________________________________________
BESOIN N°5.
Date, heure de début et adresse des représentations dans lesquelles
tous les numéros sont présentés
______________________________________________________________________________*/

SELECT r1.Date, r1.HeureDebut, l1.Adresse 
FROM REPRESENTATION r1, LIEU l1
WHERE r1.IDLieu = l1.IDLieu
AND (SELECT count(Titre) FROM PRESENTE P2 WHERE p2.CodeRep = r1.CodeRep)
= (SELECT count(Titre) FROM NUMERO);

/*______________________________________________________________________________
BESOIN N°6.
Un entracte de 30 à 45 minutes doit être respecté lors de chaque représentation
(valeur par défaut 30 mn).
______________________________________________________________________________*/
-- (1) Faites le nécessaire sans modifier le fichier create.sql

ALTER TABLE REPRESENTATION ADD Entracte time DEFAULT '00:30:00';
ALTER TABLE REPRESENTATION ADD CONSTRAINT c_Entracte CHECK ('00:30:00' <= Entracte AND Entracte <= '00:45:00');

-- (2) Afichez les n-uplets de REPRESENTATION

SELECT * FROM REPRESENTATION;

-- Que remarquez-vous ?

-- La valeur par défaut de chaque entracte est désormais de 30 mn.

/*______________________________________________________________________________
BESOIN N°7.
Durée de la représenation de code 'R1ANN', entracte non comprise
______________________________________________________________________________*/

SELECT sum(n.Duree) AS duree_rep_hors_entracte
FROM NUMERO n, PRESENTE p
WHERE n.Titre = p.Titre
AND p.CodeRep = 'R1ANN';

/*______________________________________________________________________________
BESOIN N°8.
Faites en sorte que l'entracte des représentations qui présentent
plus de 5 numéros soit de 40 mn
______________________________________________________________________________*/

UPDATE REPRESENTATION r1 SET Entracte = '00:40:00'
WHERE (SELECT count(Titre) FROM PRESENTE p2
WHERE p2.CodeRep = r1.CodeRep) > 5;

/*______________________________________________________________________________
BESOIN N°9.
Code, Date, Heure début, Durée (entracte comprise) de chaque représentation
passée ou à venir
Résultat ordonné par date, puis par heure début
______________________________________________________________________________*/

SELECT r.CodeRep, r.Date, r.HeureDebut, (sum(n.Duree)+r.Entracte) AS duree
FROM REPRESENTATION r, PRESENTE p, NUMERO n
WHERE r.CodeRep = p.CodeRep
AND p.Titre = n.Titre
GROUP BY r.CodeRep
ORDER BY r.Date, r.HeureDebut;

/*______________________________________________________________________________
BESOIN N°10.
Selon la RG8. énoncée dans le TD6, il doit y avoir au moins 5h d'écart entre
l'heure de début d'une représentation et l'heure de fin de la précédente.

------------------------------
(1) À quelle heure maximale devrait commencer une représentation qui présenterait
    tous les numéros, avec une entracte de 40 mn et qui serait programmée
    avant la représentation de code R1ANN ?

    INDICATIONS
    Procédez par étape pour constuire le résultat...
    (a) Requête donnant la durée nécessaire à la présentation de tous les
        numéros à laquelle s'ajouterait un entracte de 40 mn
    (b) Requête donnant l'heure de fin maximale d'une représentation qui serait
        donnée avant la représentation de code R1ANN (cf. RG8)
    (c) Production du résultat attendu...*/
-------------------------------

-- (a) Durée totale de présentation de tous les numéros + 40mn d'entracte

SELECT (sum(n.Duree)+'00:40:00')
FROM NUMERO n;

-- (b) Heure de fin maximale d'une représentation commençant avant celle
--     de code R1ANN

SELECT r.HeureDebut - '05:00:00'
FROM REPRESENTATION r
WHERE r.CodeRep = 'R1ANN';

-- (c) Heure de début maximale d'une représentation de tous les numéros....

SELECT 
(SELECT r.HeureDebut - '05:00:00'
FROM REPRESENTATION r
WHERE r.CodeRep = 'R1ANN')
- (SELECT (sum(n.Duree)+'00:40:00') AS dureeTotale
FROM NUMERO n) AS heurefinmax;

/*-----------------------------
(2) Si l'heure trouvée est supérieure à 10h, créez une représentation
    de code R2ANN dans le même lieu et le même jour que la réservation R1ANN
    et débutant à cette heure.
	NOTE : l'insertion dans PRESENCE de tous les numéros pour cette représentation
         n'est pas demandée
-----------------------------*/

INSERT INTO REPRESENTATION
SELECT 'R2ANN', 
(SELECT r.Date
FROM REPRESENTATION r
WHERE r.CodeRep = 'R1ANN'), 
(SELECT 
(SELECT r.HeureDebut - '05:00:00'
FROM REPRESENTATION r
WHERE r.CodeRep = 'R1ANN')
- (SELECT (sum(n.Duree)+'00:40:00') AS dureeTotale
FROM NUMERO n) AS heurefinmax),
(SELECT r.IDLieu
FROM REPRESENTATION r
WHERE r.CodeRep = 'R1ANN'),
'00:40:00';

--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------