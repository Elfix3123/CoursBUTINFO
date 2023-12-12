-- Felix (Theo) Martins
-- Groupe B2

/*______________________________________________________________________________

            Requêtes TP1 - PArtie A (FICHIER À COMPLÉTER)

     Étapes à suivre pour chaque question :
     (1)  Écrire le code de la requête
     (2)  Copier la requête (ctrl C), puis le coller (ctrl + Shift + V)
          dans le terminal où vous êtes connectés à PostGreSQL
     (3)  Vérifier le résultat obtenu par comparaison à celui attendu
          (cf. TP1B_Résultats sur Chamilo)
     (4)  Si le résultat attendu n'est pas le bon, reprendre à l'étape 1

______________________________________________________________________________*/

/*------------------------------------------------------------------------------
(a)	Numéro des salles et heure des séances du cinéma La Nef
------------------------------------------------------------------------------*/

SELECT numsalle, heure FROM seance WHERE nomcine = 'La Nef';

/*------------------------------------------------------------------------------
(b)	Pour chaque salle du cinéma Pathé : numéro de la salle, titre du film
    projeté et prix à payer
------------------------------------------------------------------------------*/

SELECT numSalle, titre, prix FROM salle WHERE nomCine = 'Pathé';

/*------------------------------------------------------------------------------
(c)	Nom des acteurs qui jouent dans des films mis en scène par Peter Jackson
------------------------------------------------------------------------------*/

SELECT DISTINCT a.nomAct FROM acteur a, film f WHERE a.titre = f.titre AND f.metteurScene = 'Peter Jackson';

/*------------------------------------------------------------------------------
(d)	Nom et adresse des cinémas qui passent des films mis en scène
    par George Lucas
------------------------------------------------------------------------------*/

SELECT DISTINCT c.nomCine, c.adresse FROM cine c, film f, salle sa WHERE c.nomCine = sa.nomCine AND sa.titre = f.titre AND f.metteurScene = 'George Lucas';

/*------------------------------------------------------------------------------
(e) Par ordre alphabétique, nom des acteurs qui jouent dans
    au moins un des films Star Wars (le titre de ces films doit commencer
    par Star Wars)
------------------------------------------------------------------------------*/

SELECT DISTINCT nomAct FROM acteur WHERE titre LIKE 'Star Wars%' ORDER BY nomAct;

/*------------------------------------------------------------------------------
(f) Nom des cinémas où passe un film mis en scène par un réalisateur
    dont le nom contient Porum
------------------------------------------------------------------------------*/

SELECT sa.nomCine FROM salle sa, film f WHERE sa.titre = f.titre AND f.metteurScene LIKE '%Porum%';

/*------------------------------------------------------------------------------
(g)	Heure, numéro de la salle et prix à payer pour chaque salle du cinéma La Nef
    où est projeté le film Molière - résultat ordonné chronologiquement
------------------------------------------------------------------------------*/

SELECT se.heure, se.numsalle, sa.prix FROM salle sa, seance se WHERE (se.nomCine, se.numSalle) = (sa.nomCine, sa.numSalle) AND se.nomCine = 'La Nef' AND sa.titre = 'Molière' ORDER BY se.heure;

/*------------------------------------------------------------------------------
(h)	Nom des acteurs qui jouent dans Eternal Sunshine of the Spotless Mind
    et aussi dans The Virgin Suicides
    Une version avec opérateur ensembliste et une version sans opérateur
    ensembliste
------------------------------------------------------------------------------*/

-- version avec opérateur ensembliste

SELECT a1.nomAct FROM acteur a1 WHERE a1.titre = 'Eternal Sunshine of the Spotless Mind' INTERSECT SELECT a2.nomAct FROM acteur a2 WHERE a2.titre = 'The Virgin Suicides';

-- version sans opérateur ensembliste

SELECT a1.nomAct FROM acteur a1, acteur a2 WHERE a1.nomAct = a2.nomAct AND a1.titre = 'Eternal Sunshine of the Spotless Mind' AND a2.titre = 'The Virgin Suicides';

/*------------------------------------------------------------------------------
(i)	Nom des acteurs qui jouent dans Eternal Sunshine of the Spotless Mind
    mais pas dans The Virgin Suicides
------------------------------------------------------------------------------*/

SELECT a1.nomAct FROM acteur a1 WHERE a1.titre = 'Eternal Sunshine of the Spotless Mind' EXCEPT SELECT a2.nomAct FROM acteur a2 WHERE a2.titre = 'The Virgin Suicides';

/*------------------------------------------------------------------------------
(j) Nom des acteurs qui jouent dans The Virgin Suicides mais pas
    dans Eternal Sunshine of the Spotless Mind
------------------------------------------------------------------------------*/

SELECT a2.nomAct FROM acteur a2 WHERE a2.titre = 'The Virgin Suicides' EXCEPT SELECT a1.nomAct FROM acteur a1 WHERE a1.titre = 'Eternal Sunshine of the Spotless Mind';

/*------------------------------------------------------------------------------
(k)	Titre des films interprétés par Romain Duris ou par Fabrice Luchini
    Une version avec opérateur ensembliste et une version sans opérateur
    ensembliste
------------------------------------------------------------------------------*/

-- version avec opérateur ensembliste

SELECT DISTINCT titre FROM acteur WHERE nomAct = 'Romain Duris' UNION SELECT DISTINCT titre FROM acteur WHERE nomAct = 'Fabrice Luchini';

-- version sans opérateur ensembliste

SELECT DISTINCT titre FROM acteur WHERE nomAct = 'Romain Duris' OR nomAct = 'Fabrice Luchini';

/*------------------------------------------------------------------------------
(l) Nombre de séances où est projeté un film interprété par Romain Duris ou
    par Fabrice Luchini
------------------------------------------------------------------------------*/

SELECT count(*) AS nb_seances_duris_ou_luchini FROM salle sa, seance se, acteur a WHERE (sa.nomCine, sa.numSalle) = (se.nomCine, se.numSalle) AND sa.titre = a.titre AND a.nomAct IN ('Romain Duris', 'Fabrice Luchini');^C

/*------------------------------------------------------------------------------
(m) Pour toutes les projections d'un film interprété par Romain Duris ou par
    Fabrice Luchini : titre du film, nom du cinéma, numéro de la salle,
    heure de la projection et prix à payer
    résultat ordonné par cinéma, puis par heure de projection
------------------------------------------------------------------------------*/

SELECT sa.titre, sa.nomCine, sa.numSalle, se.heure, sa.prix FROM salle sa, seance se, acteur a WHERE (sa.nomCine, sa.numSalle) = (se.nomCine, se.numSalle) AND sa.titre = a.titre AND a.nomAct IN ('Romain Duris', 'Fabrice Luchini') ORDER BY sa.nomCine, se.heure;

/*------------------------------------------------------------------------------
(n)	Écrivez une requête qui affiche les informations suivantes :

        titre     |      nomact       |        titre        |   metteurscene
    --------------+-------------------+---------------------+-------------------
     Les Climats  | Nuri Bilge Ceylan | Les Climats         | Nuri Bilge Ceylan
     Mystic River | Sean Penn         | Crossing Guard      | Sean Penn
     CQ           | Sofia Coppola     | The Virgin Suicides | Sofia Coppola
     CQ           | Sofia Coppola     | Lost in Translation | Sofia Coppola
    (4 rows)
------------------------------------------------------------------------------*/

SELECT a.titre, a.nomAct, f.titre, f.metteurScene FROM acteur a, film f WHERE a.nomAct = f.metteurScene;

/*------------------------------------------------------------------------------
(o)	Inspirez-vous de la requête produite en (n) pour écrire des requêtes
    affichant :                                                               */

-- 1.	le nombre de films dans lesquels joue un metteur en scène

SELECT count(DISTINCT nomAct) FROM acteur a, film f WHERE a.nomAct = f.metteurScene;

-- 2. le titre des films où le metteur en scène fait partie des interprètes

SELECT a.titre FROM acteur a, film f WHERE a.titre = f.titre AND a.nomAct = f.metteurScene;


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

SELECT DISTINCT c.nomCine, (SELECT count(DISTINCT sa.titre) FROM salle sa, film f WHERE sa.nomCine = c.nomCine AND sa.titre LIKE 'Star Wars%' AND sa.titre = f.titre AND f.metteurScene = 'George Lucas' ) AS nombre_de_films FROM cine c;

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

SELECT DISTINCT a.titre, sa.nomCine, count(*) AS nb_projections FROM salle sa, seance se, acteur a WHERE (sa.nomCine, sa.numSalle) = (se.nomCine, se.numSalle) AND sa.titre = a.titre AND a.nomAct = 'Fabrice Luchini' GROUP BY a.titre, sa.nomCine ORDER BY nb_projections, a.titre;

/*------------------------------------------------------------------------------
(k) Nom et adresse des cinémas qui projettent plus de 6 films différents
------------------------------------------------------------------------------*/



/*------------------------------------------------------------------------------
(l) Nom et adresse des cinémas qui projettent le plus de films différents
------------------------------------------------------------------------------*/






--------------------------------------------------------------------------------
-- FIN PARTIE B
--------------------------------------------------------------------------------

