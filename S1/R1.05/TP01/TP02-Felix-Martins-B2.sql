-- Felix (Theo) Martins
-- Groupe B2

/*______________________________________________________________________________

            Requêtes TP1 - PArtie B (FICHIER À COMPLÉTER)

     Étapes à suivre pour chaque question :
     (1)  Écrire le code de la requête
     (2)  Copier la requête (ctrl C), puis le coller (ctrl + Shift + V)
          dans le terminal où vous êtes connectés à PostGreSQL
     (3)  Vérifier le résultat obtenu par comparaison à celui attendu
          (cf. TP1B_Résultats sur Chamilo)
     (4)  Si le résultat attendu n'est pas le bon, reprendre à l'étape 1

______________________________________________________________________________*/


/*------------------------------------------------------------------------------
(a) Réécrivez en utilisant une ou plusieurs sous-requêtes, les requêtes
    répondant aux questions (h) et (i) de la partie A
------------------------------------------------------------------------------*/

-- 1. Réécriture requête (h)
--    Nom des acteurs qui jouent dans Eternal Sunshine of the Spotless Mind
--    et aussi dans The Virgin Suicides

SELECT a1.nomAct FROM acteur a1 WHERE a1.titre = 'Eternal Sunshine of the Spotless Mind' AND a1.nomAct IN (SELECT a3.nomAct FROM acteur a3 WHERE a3.titre = 'The Virgin Suicides');

-- 2. Réécriture requête (i)
--    Nom des acteurs qui jouent dans Eternal Sunshine of the Spotless Mind
--    mais pas dans The Virgin Suicides

SELECT a1.nomAct FROM acteur a1 WHERE a1.titre = 'Eternal Sunshine of the Spotless Mind' AND a1.nomAct NOT IN (SELECT a3.nomAct FROM acteur a3 WHERE a3.titre = 'The Virgin Suicides');

/*------------------------------------------------------------------------------
(b)	Nombre d'acteurs par films
    (1 version avec GROUP BY + 1 version avec sous-requêtes)
    résultat ordonné par nombre d'acteurs décroissant, puis par titre
------------------------------------------------------------------------------*/

-- 1. Version avec GROUP BY

SELECT titre, count(*) as nb_acteurs FROM acteur GROUP BY titre ORDER BY nb_acteurs DESC, titre;

-- 2. Version avec sous-requête

SELECT DISTINCT a1.titre, (SELECT count(*) FROM acteur a2 WHERE a1.titre = a2.titre) AS nb_acteurs FROM acteur a1 ORDER BY nb_acteurs DESC, a1.titre;

/*------------------------------------------------------------------------------
(c) Programmation en cours : pour chaque cinéma, sachant que chaque cinéma
    projetette au moins un film
    résultat ordonné par par nombre de films décroissant, puis par nom de cinéma
------------------------------------------------------------------------------*/

SELECT DISTINCT sa1.nomCine, (SELECT count(DISTINCT sa2.titre) FROM salle sa2 WHERE sa1.nomCine = sa2.nomCine) AS nb_films_projetés FROM salle sa1 ORDER BY nb_films_projetés DESC, sa1.nomCine;

/*------------------------------------------------------------------------------
(d) Nom des cinémas projetant au moins 2 films Star Wars différents
    mis en scène par George Lucas (leur titre commence par Star Wars)
------------------------------------------------------------------------------*/

SELECT sa.nomCine, count(DISTINCT sa.titre) FROM salle sa, film f WHERE sa.titre LIKE 'Star Wars%' AND sa.titre = f.titre AND f.metteurScene = 'George Lucas' GROUP BY sa.nomCine HAVING count(DISTINCT sa.titre) >= 2;

/*------------------------------------------------------------------------------
(e) Prix maximum, prix minimum et prix moyen arrondi à 2 décimales,
    des projections programmées par chaque cinéma
    résultat ordonné par nom de cinéma
------------------------------------------------------------------------------*/

SELECT c.nomCine, (SELECT min(sa.prix) AS prix_min FROM salle sa WHERE sa.nomCine = c.nomCine), (SELECT max(sa.prix) AS prix_max FROM salle sa WHERE sa.nomCine = c.nomCine), (SELECT round(avg(sa.prix), 2) AS prix_moy FROM salle sa WHERE sa.nomCine = c.nomCine) FROM cine c ORDER BY c.nomCine;

/*------------------------------------------------------------------------------
(f) Titre et nom du metteur en scène des films qui ne sont pas programmés
    pour la journée en cours
    une version sans sous-requête et une version avec sous-requête
------------------------------------------------------------------------------*/
-- 1. version sans sous-requête

SELECT * FROM film EXCEPT SELECT DISTINCT f.titre, f.metteurScene FROM film f, salle sa, seance se WHERE f.titre = sa.titre AND (sa.nomCine, sa.numSalle)=(se.nomCine, se.numSalle);

-- 2. version avec sous-requête

SELECT * FROM film f WHERE f.titre NOT IN(SELECT DISTINCT sa.titre FROM salle sa, seance se WHERE (sa.nomCine, sa.numSalle)=(se.nomCine, se.numSalle));

/*------------------------------------------------------------------------------
(g) Pour afficher le nombre de séances débutant après 20h dans chaque cinéma,
    la requête suivante a été proposée...
------------------------------------------------------------------------------*/
SELECT NomCine, count(*) AS Nb_Seances_Soir
FROM SEANCE
WHERE Heure > 20
GROUP BY NomCine
ORDER BY NomCine;

-- 1. Exécutez-la
-- 2. Justifiez pourquoi son résultat n'est pas satisfaisant

-- Car les cinemas sans sceances apres 20h ne sont pas affiches.

--3. Proposez une solution recevable

SELECT DISTINCT se1.nomCine, (SELECT count(*) FROM seance se2 WHERE se1.nomCine = se2.nomCine AND se2.heure > 20) AS Nb_Seances_Soir FROM seance se1;

/*------------------------------------------------------------------------------
(h) Pour chaque cinéma, Nombre de salles qui projettent un film interprété par
    Gérard Depardieu ou par Catherine Deneuve
------------------------------------------------------------------------------*/

SELECT DISTINCT se1.nomCine, (SELECT count(DISTINCT nomAct) FROM salle sa, seance se2, acteur a WHERE (sa.nomCine, sa.numSalle)=(se2.nomCine, se2.numSalle) AND se1.nomCine = se2.nomCine AND sa.titre = a.titre AND a.nomAct IN ('Gérard Depardieu', 'Catherine Deneuve')) AS Nb_Seances_Soir FROM seance se1;

/*------------------------------------------------------------------------------
(i)	Des usagers ont fait part de leur besoin de connaître les détails
    des séances de projection proposées après 18h à un prix inférieur
    à la moyenne des prix pratiqués : heure de séance, prix à payer, titre
    du film projeté, nom du cinéma et numéro de la salle
------------------------------------------------------------------------------*/

-- 1. Écrire une requête affichant la moyenne des prix pratiqués
--   (moyenne arrondie à 2 décimales)

SELECT round(avg(sa.prix), 2) AS prix_moy FROM salle sa;

-- 2. En utilisant la requête précédente, affichez les informations désirées
--    résultat ordonné par heure, prix, puis par nom de cinéma

SELECT se.heure, sa.prix, sa.titre, sa.nomCine, sa.numSalle FROM salle sa, seance se WHERE (sa.nomCine, sa.numSalle) = (se.nomCine, se.numSalle) AND sa.prix < (SELECT round(avg(sa.prix), 2) AS prix_moy FROM salle sa) AND se.heure > '18.00' ORDER BY se.heure, sa.prix, sa.nomCine;

/*------------------------------------------------------------------------------
(j)	On s'intéresse aux films inteprétés par Fabrice Luchini.
	  Écrivez les requêtes affichant les informations suivantes :
------------------------------------------------------------------------------*/

-- 1. Nombre de séances où est projeté un film inteprété par Fabrice Luchini

SELECT count(*) AS nb_seances_luchini FROM salle sa, seance se, acteur a WHERE (sa.nomCine, sa.numSalle) = (se.nomCine, se.numSalle) AND sa.titre = a.titre AND a.nomAct = 'Fabrice Luchini';

-- 2. Répartition de ces séances par cinéma
--    Résultat ordonné sur le nom des cinémas

SELECT c.nomCine, (SELECT count(*) AS nb_seances_luchini FROM salle sa, seance se, acteur a WHERE (sa.nomCine, sa.numSalle) = (se.nomCine, se.numSalle) AND sa.titre = a.titre AND a.nomAct = 'Fabrice Luchini' AND sa.nomCine = c.nomCine) FROM cine c ORDER BY c.nomCine;

-- 3. Pour chaque cinéma où est projeté un film inteprété par Fabrice Luchini,
--    son nom,le nombre de salles qui proposent ce film et la fourchette de
--    prix pratiquée par ces salles (prix minimum, prix maximum)

SELECT sa.nomCine, count(*) AS nb_salles_luchini, min(sa.prix) AS prix_min, max(sa.prix) AS prix_max FROM salle sa, acteur a WHERE sa.titre = a.titre AND a.nomAct = 'Fabrice Luchini' GROUP BY sa.nomCine;

--4.  Nombre de projections pour chaque film inteprété par Fabrice Luchini

SELECT DISTINCT a.titre, (SELECT count(*) AS nb_projections FROM salle sa, seance se WHERE (sa.nomCine, sa.numSalle) = (se.nomCine, se.numSalle) AND sa.titre = a.titre) FROM acteur a WHERE a.nomAct = 'Fabrice Luchini';

--5.  Pour chaque film inteprété par Fabrice Luchini, nombre de projections
--    par cinéma passant ce film
--    Résultat ordonné par nombre de projections décroissant puis par titre

SELECT DISTINCT a.titre, sa.nomCine, count(*) AS nb_projections FROM salle sa, seance se, acteur a WHERE (sa.nomCine, sa.numSalle) = (se.nomCine, se.numSalle) AND sa.titre = a.titre AND a.nomAct = 'Fabrice Luchini' GROUP BY a.titre, sa.nomCine ORDER BY nb_projections DESC, a.titre;

/*------------------------------------------------------------------------------
(k) Nom et adresse des cinémas qui projettent plus de 6 films différents
------------------------------------------------------------------------------*/

SELECT c.nomCine, c.adresse FROM cine c WHERE (SELECT count(DISTINCT sa.titre) FROM salle sa WHERE c.nomCine = sa.nomCine) > 6;

/*------------------------------------------------------------------------------
(l) Nom et adresse des cinémas qui projettent le plus de films différents
------------------------------------------------------------------------------*/

SELECT c.nomCine, c.adresse FROM cine c WHERE (SELECT count(DISTINCT sa.titre) FROM salle sa WHERE c.nomCine = sa.nomCine) = (SELECT count(DISTINCT sa.titre) FROM salle sa GROUP BY sa.nomCine ORDER BY count(DISTINCT sa.titre) DESC LIMIT 1);

--------------------------------------------------------------------------------
-- FIN PARTIE B
--------------------------------------------------------------------------------

