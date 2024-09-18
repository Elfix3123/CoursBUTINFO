BEGIN;	-- Demarrage de la transaction
INSERT INTO MONITEUR VALUES
(10,'lacroix','franck','courchevel','0490584525');	-- On insere un moniteur
SELECT * FROM MONITEUR WHERE nummono = 10;	-- L'insertion a bien ete faite
ROLLBACK;	-- On annule la transaction
SELECT * FROM MONITEUR WHERE nummono = 10;	-- L'inserion n'est plus visible

BEGIN;	-- Demarrage de la transaction
insert into MONITEUR
values(10,'lacroix','franck','courchevel','0490584525');	-- On insere un moniteur
select * from MONITEUR where nummono = 10;	-- L'insertion a bien ete faite
COMMIT;	-- On valide la transaction
select * from MONITEUR where nummono = 10;	-- L'insertion est toujours visible

BEGIN;
insert into MONITEUR values
(null,'lapierre','éric','chamrousse','0490584525');
select * from MONITEUR;
COMMIT;
select * from MONITEUR;
-- L'utilisation des transactions permet de gerer l'erreur

BEGIN;
insert into ELEVE(nom, prenom, datenaissance, adressestation, mobile)
values('gigi','lebronze','05/12/1971','surletélésiège','0789889988');
select * from ELEVE;
insert into INSCRIT values ('gigi',1);
COMMIT;
select * from ELEVE;
select * from INSCRIT
-- La condition d'atomicite est respectee grace a l'utilisation des transactions
x