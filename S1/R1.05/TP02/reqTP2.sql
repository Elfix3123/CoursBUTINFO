--- Felix Martins
--- Groupe B2

/*
_________________________________________________________
--
--          Requêtes TP2 (fichier à compléter)
--
_________________________________________________________
*/

/*------------------------------------------------------------------------------
(a) Nom et numéro des 3 premiers gardiens selon l'ordre alphabétique
------------------------------------------------------------------------------*/

SELECT nomGard, numGard FROM gardien ORDER BY nomGard LIMIT 3;

/*------------------------------------------------------------------------------
(b)	Nom, espèce et numéro de cage des animaux dont s'occupent Tintin ou Milou
    (résultat ordonné sur le nom d'animal)
------------------------------------------------------------------------------*/

SELECT a.nomani, a.espece, a.numcage FROM animal a, gardien g, soccupe so WHERE a.numCage = so.numCage AND g.numGard = so.numGard AND g.nomGard IN ('Tintin', 'Milou') ORDER BY a.nomAni;

/*------------------------------------------------------------------------------
(c)	Nom, espèce et numéro de cage des animaux dont s'occupent Tintin et Milou
------------------------------------------------------------------------------*/

SELECT a.nomani, a.espece, a.numcage FROM animal a, gardien g, soccupe so WHERE a.numCage = so.numCage AND g.numGard = so.numGard AND g.nomGard = 'Milou' INTERSECT
SELECT a.nomani, a.espece, a.numcage FROM animal a, gardien g, soccupe so WHERE a.numCage = so.numCage AND g.numGard = so.numGard AND g.nomGard = 'Tintin';

/*------------------------------------------------------------------------------
(d)	Nom des gardiens qui ne s'occupent d'aucune cage
Une version avec opérateur ensembliste + une version avec sous-requête(s)
------------------------------------------------------------------------------*/

--- Version avec opérateur ensembliste
SELECT g.nomGard FROM gardien g EXCEPT SELECT g.nomGard FROM gardien g, soccupe so WHERE g.numGard = so.numGard;

--- Version avec sous-requête
SELECT g.nomGard FROM gardien g WHERE g.numGard NOT IN (SELECT so.numGard FROM soccupe so);

/*------------------------------------------------------------------------------
(e)	Nom des gardiens qui s'occupent d'éléphants
------------------------------------------------------------------------------*/

SELECT DISTINCT g.nomGard FROM gardien g WHERE g.nomGard IN (SELECT g2.nomGard FROM gardien g2, soccupe so, animal a WHERE g.numGard = so.numGard AND a.numCage = so.numCage AND a.espece = 'éléphant');

/*------------------------------------------------------------------------------
(f)	Nom des gardiens qui ne s'occupent pas d'éléphants
		(mais qui s'occupent d'au moins une cage)
------------------------------------------------------------------------------*/

SELECT DISTINCT g.nomGard FROM gardien g, soccupe so WHERE so.numGard = g.numGard AND g.nomGard NOT IN (SELECT g2.nomGard FROM gardien g2, soccupe so, animal a WHERE g.numGard = so.numGard AND a.numCage = so.numCage AND a.espece = 'éléphant');

/*------------------------------------------------------------------------------
(g)	Nombre d'animaux qui cohabitent avec l'éléphant dumbo
------------------------------------------------------------------------------*/

SELECT count(DISTINCT a.nomAni) AS colloc_dumbo FROM animal a WHERE a.numCage = (SELECT a2.numCage FROM animal a2 WHERE a2.nomAni = 'dumbo') AND a.nomAni != 'dumbo';

--- Autre solution

SELECT count(DISTINCT a.nomAni) - 1 AS colloc_dumbo FROM animal a WHERE EXISTS (SELECT a2.numCage FROM animal a2 WHERE a.numCage = a2.numCage AND a2.nomAni = 'dumbo');

/*------------------------------------------------------------------------------
(h)	Nom et espèce des animaux qui cohabitent avec l'éléphant dumbo
------------------------------------------------------------------------------*/

SELECT a.nomAni, a.espece AS colloc_dumbo FROM animal a WHERE a.numCage = (SELECT a2.numCage FROM animal a2 WHERE a2.nomAni = 'dumbo') AND a.nomAni != 'dumbo';

/*------------------------------------------------------------------------------
(i) Nom et adresse des gardiens nés en 1980
------------------------------------------------------------------------------*/

SELECT g.nomGard, g.adresse FROM gardien g WHERE extract(YEAR FROM g.dateNaissGard) = '1980';

/*------------------------------------------------------------------------------
(j) Âge qu'a atteint aujourd'hui le gardien Gaston Lagaffe
------------------------------------------------------------------------------*/

SELECT CURRENT_DATE AS datecalcul, age(CURRENT_DATE, g.dateNaissGard) AS age_lagaffe FROM gardien g WHERE g.nomGard = 'Gaston Lagaffe'; 

/*------------------------------------------------------------------------------
(k)	Par ordre chronologique, date du diagnostic, nom de la maladie
    et nom de l'animal malade, pour chaque cas de maladie enregistré en 2022
------------------------------------------------------------------------------*/

SELECT su.dateDebutMal, su.maladie, su.nomAni FROM suivi_mal su WHERE extract(YEAR FROM su.dateDebutMal) = '2022' ORDER BY su.dateDebutMal;

/*------------------------------------------------------------------------------
(l)	Nombre d'éléphants qui ont eu au moins une fois le typhus
------------------------------------------------------------------------------*/

SELECT count(DISTINCT su.nomAni) AS atteints_typhus FROM suivi_mal su, animal a WHERE su.nomAni = a.nomAni AND a.espece = 'éléphant' AND su.maladie = 'typhus'; 

/*------------------------------------------------------------------------------
(m)	Nom et espèce des animaux qui sont encore malades aujourd'hui
------------------------------------------------------------------------------*/

SELECT DISTINCT a.nomAni, a.espece FROM animal a, suivi_mal su WHERE a.nomAni = su.nomAni AND (su.dateDebutMal > CURRENT_DATE) AND (su.dateFinMal < CURRENT_DATE OR su.dateFinMal IS NULL);

/*------------------------------------------------------------------------------
(n)	Nom des animaux qui ont contracté au moins deux maladies différentes
------------------------------------------------------------------------------*/

SELECT a.nomAni FROM animal a WHERE (SELECT count(DISTINCT su.maladie) FROM suivi_mal su WHERE su.nomAni = a.nomAni) >= 2;

/*------------------------------------------------------------------------------
(o)	Numéro des cages où sont gardés des animaux qui ont déjà contracté
    le typhus et la gale
------------------------------------------------------------------------------*/

SELECT a.numCage FROM animal a WHERE a.nomAni IN (SELECT su.nomAni FROM suivi_mal su WHERE su.maladie = 'typhus' INTERSECT SELECT su.nomAni FROM suivi_mal su WHERE su.maladie = 'gale');

/*------------------------------------------------------------------------------
(p)	Nom et numéro de cage des animaux qui ont été ou sont malades et dont
    le gardient Gaston Lagaffe a la charge
		(résultat ordonné sur le numéro de cage puis sur le nom d'animal)
------------------------------------------------------------------------------*/

SELECT a.nomAni, a.numCage FROM animal a, suivi_mal su WHERE a.nomAni = su.nomAni INTERSECT
SELECT a.nomAni, a.numCage FROM animal a, gardien g, soccupe so WHERE a.numCage = so.numCage AND g.numGard = so.numGard AND g.nomGard = 'Gaston Lagaffe'
ORDER BY numCage, nomAni;

/*------------------------------------------------------------------------------
(q)	Nombre de jours minimum qu'un animal a mis pour guérir d'une maladie
		qu'il avait contractée
------------------------------------------------------------------------------*/

SELECT extract(DAYS FROM (SELECT min(age(su.dateFinMal, su.dateDebutMal)) FROM suivi_mal su)) AS min_nbjoursmal;

/*------------------------------------------------------------------------------
(r)	Nombre de jours minimum qu'un animal a mis pour guérir de la gale et
		Nombre de jours minimum qu'un animal a mis pour guérir du typhus
INDICATION : utliser des sous-requêtes pour déterminer chacun des nombres de
jours à afficher
------------------------------------------------------------------------------*/

SELECT
(SELECT extract(DAYS FROM (SELECT min(age(su.dateFinMal, su.dateDebutMal)) FROM suivi_mal su WHERE su.maladie = 'gale'))) AS min_nbj_gale,
(SELECT extract(DAYS FROM (SELECT min(age(su.dateFinMal, su.dateDebutMal)) FROM suivi_mal su WHERE su.maladie = 'typhus'))) AS min_nbj_typhus;

/*------------------------------------------------------------------------------
(s)	Pour chaque animal du zoo, nombre de maladies différentes
    qu'il a contractées (résultat ordonné par nombre de maladies décroissant)
ATTENTION, certains animaux n'ont encore jamais été malades !
------------------------------------------------------------------------------*/

SELECT a.nomAni, (SELECT count(DISTINCT su.maladie) FROM suivi_mal su WHERE su.nomAni = a.nomAni) AS nb_maladies_diff FROM animal a ORDER BY nb_maladies_diff DESC;

/*------------------------------------------------------------------------------
(t)	Nombre d'animaux par cage du zoo – le numéro et le type de chaque cage
    sera affiché (résultat ordonné par nombre d'animaux décroissant)
ATTENTION - il peut y avoir des cages vides
------------------------------------------------------------------------------*/

SELECT c.numCage, c.typeCage, (SELECT count(a.nomAni) FROM animal a WHERE a.numCage = c.numCage) AS nb_ani FROM cage c ORDER BY nb_ani DESC;

/*------------------------------------------------------------------------------
(u)	Nombre de cages affectées à chaque gardien – le nom du gardien doit être
    affiché (pas son numéro)
    (résultat ordonné par nombre de cages décroissant)
------------------------------------------------------------------------------*/

SELECT g.nomGard, (SELECT count(numCage) FROM soccupe so WHERE so.numGard = g.numGard) AS nb_cages FROM gardien g ORDER BY nb_cages DESC;

/*------------------------------------------------------------------------------
(v)	Nombre d'animaux dont s'occupe chaque gardien – le nom du gardien doit être
    affiché (pas son numéro)
    (résultat ordonné par nombre d'animaux décroissant)
------------------------------------------------------------------------------*/

SELECT g.nomGard, (SELECT count(DISTINCT a.nomAni) FROM soccupe so, animal a WHERE so.numGard = g.numGard AND a.numCage = so.numCage) AS nb_ani_en_charge FROM gardien g ORDER BY nb_ani_en_charge DESC; 

/*------------------------------------------------------------------------------
(w)	Nom, âge (en années) et adresse des gardiens qui s'occupent
    d'au moins 7 animaux
------------------------------------------------------------------------------*/

SELECT g.nomGard, extract(YEAR FROM age(CURRENT_DATE, g.dateNaissGard)) FROM gardien g, 
(SELECT g2.nomGard, (SELECT count(DISTINCT a.nomAni) FROM soccupe so, animal a WHERE so.numGard = g2.numGard AND a.numCage = so.numCage) AS nb_ani_en_charge FROM gardien g2) 
AS ani_par_gard
WHERE g.nomGard = ani_par_gard.nomGard
AND ani_par_gard.nb_ani_en_charge >= 7;

/*------------------------------------------------------------------------------
(x)	Titeuf s'occupe de beaucoup d'animaux ! On voudrait en savoir plus…
    1.	Combien de cages dont il s'occupe abritent es éléphants ?
    2.	Quel est l'âge en années du plus vieil animal (ou des plus vieux animaux)
        dont il s'occupe ?
    3.	Pour chaque espèce d'animal, combien a-t-il d'animaux en charge ?
------------------------------------------------------------------------------*/

--- 1.
SELECT count(*) AS nb_cages_éléphants FROM (SELECT a.numCage FROM animal a WHERE a.espece = 'éléphant' INTERSECT
SELECT so.numCage FROM soccupe so, gardien g WHERE g.numGard = so.numGard AND g.nomGard = 'Titeuf') AS cages_elephant_titeuf;

--- 2.
SELECT max(age(CURRENT_DATE, a.dateNaissAni)) AS age_plus_vieux_ani, min(extract(YEAR FROM a.dateNaissAni)) AS annee_nais_plus_vieux_ani FROM animal a, soccupe so, gardien g WHERE a.numCage = so.numCage AND so.numGard = g.numGard AND g.nomGard = 'Titeuf';

--- 3.
SELECT DISTINCT a.espece, (SELECT count(a2.nomAni) FROM animal a2, soccupe so, gardien g WHERE a2.numCage = so.numCage AND so.numGard = g.numGard AND g.nomGard = 'Titeuf' AND a.espece = a2.espece) FROM animal a;

--------------------------------------------------------------------------------
-- FIN !!!
--------------------------------------------------------------------------------