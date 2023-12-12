--------------------------------------------------------------------------------
        -- INFORMATIONS SUR LES DONNÉES DE L'INSTANCE DE LA BD --
--------------------------------------------------------------------------------

/*______________________________________________________________________________
  INFO N°1
  Nombre de numéros dont Bozzo est responsable.
______________________________________________________________________________*/

SELECT count(*) AS resp_bozzo FROM NUMERO WHERE Responsable = 'Bozzo';

/*______________________________________________________________________________
  INFO N°2
  Pour chaque numéro proposé au public, son titre et le nombre d'artistes qui
  l'interprètent.
  NOTE : un numéro proposé au public a au moins un interprète...
______________________________________________________________________________*/

SELECT Titre, count(surnom) AS nb_artistes FROM INTERPRETE GROUP BY Titre;

/*______________________________________________________________________________
  INFO N°3
  Pour chaque numéro proposé au public, son titre et le nombre d'accessoires
  différents utilisés (la différence portant sur le code des accessoires).
  NOTE : dans certains numéros proposés au public, aucun accessoire n'est utilisé
______________________________________________________________________________*/

SELECT DISTINCT i.Titre, (SELECT count(DISTINCT CodeAcc) FROM UTILISATION u WHERE u.Titre = i.Titre) AS nb_accessoires FROM INTERPRETE i;

/*______________________________________________________________________________
  INFO N°4
  Immatriculation des camions où sont rangés au moins 6 accessoires.
______________________________________________________________________________*/

SELECT ImmatCamion FROM ACCESSOIRE GROUP BY ImmatCamion HAVING count(CodeAcc) >= 6;

/*______________________________________________________________________________
  INFO N°5
  INFO N°5.	Surnom et spécialité des artistes qui n'interprètent aucun numéro
  (2 solutions).
______________________________________________________________________________*/

SELECT Surnom, Specialite FROM ARTISTE EXCEPT SELECT ar.Surnom, ar.Specialite FROM ARTISTE ar, INTERPRETE i WHERE ar.Surnom = i.Surnom;
SELECT ar1.Surnom, ar1.Specialite FROM ARTISTE ar1 WHERE NOT EXISTS(SELECT * FROM INTERPRETE i2 WHERE i2.Surnom = ar1.Surnom);

/*______________________________________________________________________________
  INFO N°6
  Nombre d'accessoires qui ne sont jamais utilisés.
  (essayer de trouver 2 solutions)
______________________________________________________________________________*/

SELECT count(CodeAcc) AS acc_pas_utilises FROM (SELECT CodeAcc FROM ACCESSOIRE EXCEPT SELECT CodeAcc FROM UTILISATION) AS TEMPACCESSOIRES;
SELECT count(CodeAcc) AS acc_pas_utilises FROM (SELECT ac1.CodeAcc FROM ACCESSOIRE ac1 WHERE NOT EXISTS(SELECT * FROM UTILISATION u2 WHERE u2.CodeAcc = ac1.CodeAcc)) AS TEMPACCESSOIRES;

/*______________________________________________________________________________
  INFO N°7
  Plus grand nombre de ballons différents utilisés dans un numéro
  (la différence portant sur leur code).
______________________________________________________________________________*/

SELECT max(nb_ballons) as nb_ballons_dif FROM (SELECT u.Titre, count(DISTINCT u.CodeAcc) AS nb_ballons FROM UTILISATION u, ACCESSOIRE ac WHERE u.CodeAcc = ac.CodeAcc AND ac.Type = 'ballon' GROUP BY u.Titre) AS NBBALLONS;

/*______________________________________________________________________________
  INFO N°8
  Pour chaque numéro, nombre de ballons différents et nombre d'autres
  accessoires de code différents qui sont utilisés.
______________________________________________________________________________*/

SELECT n1.Titre, 
(SELECT count(DISTINCT u2.CodeAcc) FROM UTILISATION u2, ACCESSOIRE ac2 WHERE n1.Titre = u2.Titre AND u2.CodeAcc = ac2.CodeAcc AND ac2.Type = 'ballon') AS nb_ballons,
(SELECT count(DISTINCT u2.CodeAcc) FROM UTILISATION u2, ACCESSOIRE ac2 WHERE n1.Titre = u2.Titre AND u2.CodeAcc = ac2.CodeAcc AND ac2.Type != 'ballon') AS nb_autres_acc
FROM NUMERO n1;

/*______________________________________________________________________________
  INFO N°9
  Pour chaque numéro : titre, surnom de l'artiste et nombre d'accessoires
  différents qu'il utilise (résultat ordonné sur le titre puis sur le surnom)
  ATTENTION :  certains artistes n'utilisent pas d'accessoire
______________________________________________________________________________*/

SELECT i1.Titre, i1.Surnom,
(SELECT count(DISTINCT u2.CodeAcc) FROM UTILISATION u2 WHERE (i1.Titre, i1.Surnom) = (u2.Titre, u2.Surnom)) AS nb_acc
FROM INTERPRETE i1
ORDER BY i1.Titre, i1.Surnom;

/*--------------------------------------------------------------------------------
  Résultat d'une requête qui fait état de l'utilisation de certains accessoires
  par chaque artiste qui interprète un numéro dont Bozzo est responsable

      titre     |   surnom    | nb_ballons | nb_quilles | nb_autres_acc
  --------------+-------------+------------+------------+---------------
   Les Zappatas | Blanc       |          1 |          1 |             0
   Les Zappatas | Bozzo       |          4 |          2 |             0
   Les Zappatas | Jules       |          0 |          1 |             3
   Les Zappatas | Milledoigts |          1 |          1 |             0
   Millequilles | Bozzo       |          0 |          0 |             0
   Millequilles | Gary        |          0 |          1 |             1
   Millequilles | Milledoigts |          0 |          1 |             0
   Rigolo       | Blanc       |          0 |          0 |             0
   Rigolo       | Bozzo       |          0 |          0 |             0
   Rigolo       | Raoul       |          0 |          0 |             0
  (10 rows)

  Ce résultat montre qu'un artiste interprétant un numéro dont Bozzo est
  responsable peut :
  - ne pas utiliser d'accessoires
  - utiliser plusieurs accessoires parmi lesquels des quille, ou des ballons,
    ou d'autres accessoires
  - n'utiliser aucun ballon mais éventuellement d'autres accessoires
  - n'utiliser que des quilles
------------------------------------------------------------------------------*/
/*______________________________________________________________________________
  INFO N°10
  Surnom des artistes qui n'utilisent jamais de ballon dans un numéro dont Bozzo
  est responsable.
______________________________________________________________________________*/

SELECT DISTINCT i1.Surnom
FROM INTERPRETE i1, NUMERO n1
WHERE i1.Titre = n1.Titre
AND n1.Responsable = 'Bozzo'
EXCEPT
SELECT DISTINCT i1.Surnom
FROM INTERPRETE i1, NUMERO n1
WHERE i1.Titre = n1.Titre
AND n1.Responsable = 'Bozzo'
AND EXISTS(SELECT * FROM UTILISATION u2, ACCESSOIRE ac2 WHERE (u2.Surnom, u2.Titre) = (i1.Surnom, i1.Titre) AND u2.CodeAcc = ac2.CodeAcc AND ac2.Type = 'ballon');

/*______________________________________________________________________________
  INFO N°11.
  Surnom des artistes qui n'utilisent que des quilles dans au moins un numéro
  dont Bozzo est responsable.
______________________________________________________________________________*/

SELECT DISTINCT i1.Surnom
FROM INTERPRETE i1, NUMERO n1
WHERE i1.Titre = n1.Titre
AND n1.Responsable = 'Bozzo'
AND EXISTS(SELECT u2.Surnom FROM UTILISATION u2, ACCESSOIRE ac2 WHERE (u2.Surnom, u2.Titre) = (i1.Surnom, i1.Titre) AND u2.CodeAcc = ac2.CodeAcc AND ac2.Type = 'quilles'
EXCEPT 
SELECT u2.Surnom FROM UTILISATION u2, ACCESSOIRE ac2 WHERE (u2.Surnom, u2.Titre) = (i1.Surnom, i1.Titre) AND u2.CodeAcc = ac2.CodeAcc AND ac2.Type != 'quilles');

/*______________________________________________________________________________
  INFO N°12.	BONUS
  Proposez une requête dont le résultat serait identique au tableau présenté
  avant l'INFO N°10.
______________________________________________________________________________*/

SELECT i1.Titre, i1.Surnom,
(SELECT count(DISTINCT u2.CodeAcc) FROM UTILISATION u2, ACCESSOIRE ac2 WHERE (u2.Surnom, u2.Titre) = (i1.Surnom, i1.Titre) AND u2.CodeAcc = ac2.CodeAcc AND ac2.Type = 'ballon') AS nb_ballons,
(SELECT count(DISTINCT u2.CodeAcc) FROM UTILISATION u2, ACCESSOIRE ac2 WHERE (u2.Surnom, u2.Titre) = (i1.Surnom, i1.Titre) AND u2.CodeAcc = ac2.CodeAcc AND ac2.Type = 'quilles') AS nb_quilles,
(SELECT count(DISTINCT u2.CodeAcc) FROM UTILISATION u2, ACCESSOIRE ac2 WHERE (u2.Surnom, u2.Titre) = (i1.Surnom, i1.Titre) AND u2.CodeAcc = ac2.CodeAcc AND ac2.Type NOT IN('ballon', 'quilles')) AS nb_autres_acc
FROM INTERPRETE i1, NUMERO n1
WHERE i1.Titre = n1.Titre
AND n1.Responsable = 'Bozzo'
ORDER BY i1.Titre, i1.Surnom;

--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------
