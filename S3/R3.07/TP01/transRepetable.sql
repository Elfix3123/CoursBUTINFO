--REMARQUE : En cas d'erreur dans une transaction, on ne peut plus rien y faire:
--on a toujours le message d'erreur suivant :
--	ERROR:  current transaction is aborted, commands ignored until end of transaction block
--Il faut donc finir par un ROLLBACK et recommencer

-- Les requetes sont a executer une par une
-- donc par des copier/coller et pas avec \i ....
-- dans l'ordre dans lequel elles sont indiquees
-- par l'utilisateur indique en commentaire

-- QUESTION 1-------------------------------------------------------------------
-- user1 fait des modifications validees, user2 des select
-- user1
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
-- user2
select * from COURS;
-- user1
insert into COURS values(12,'Le Centre',20,'26/12/2014','01/01/2015','14:30','16:30');
-- user2
select * from COURS;
-- user1
commit;
-- user2
select * from COURS;
-- RESULTAT : Rien ne change

-- QUESTION 2-------------------------------------------------------------------
-- user1 fait des modifications annulees, user2 des select
-- user1
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
-- user2
select * from COURS;
-- user1
insert into COURS values(13,'Le Centre',20,'01/01/2015','07/01/2015','14:30','16:30');
select * from COURS;
-- user2
select * from COURS;
-- user1
rollback;
-- user2
select * from COURS;
-- RESULTAT : rien ne change
-- QUESTION 3-------------------------------------------------------------------
-- user1 et user2 insèrent des moniteurs différents (intercaler les requetes)
--user 1
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
--user 2
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
--user 1
insert into MONITEUR values(5,'Lafont','Jean','Val d''Isère','0123456789');
--user 2
insert into MONITEUR values(6,'Lafont','Jean','Val d''Isère','0123456789');
--user 1
commit;
--user 2
commit;

-- QU'OBSERVEZ-VOUS : rien ne change

-- QUESTION 4-------------------------------------------------------------------
-- user1 et user2 insèrent le meme moniteur (intercaler les requetes) Cas ou user1 valide sa transaction
--user 1
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
--user 2
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
--user 1
insert into MONITEUR values(7,'Lafont','Jean','Val d''Isère','0123456789');
--user 2
insert into MONITEUR values(7,'Lafont','Jean','Val d''Isère','0123456789');
--user 1
commit;
--user 2
commit;

-- QU'OBSERVEZ-VOUS : rien ne change

-- user1 et user2 insèrent le meme moniteur (intercaler les requetes) Cas ou user1 annule sa transaction
--user 1
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
--user 2
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
--user 1
insert into MONITEUR values(8,'Lafont','Jean','Val d''Isère','0123456789');
--user 2
insert into MONITEUR values(8,'Lafont','Jean','Val d''Isère','0123456789');
--user 1
rollback;
--user 2
commit;
-- QU'OBSERVEZ-VOUS : rien ne change


-- QUESTION 5-------------------------------------------------------------------
-- user1 affecte les cours de JC Killy à Luc Alphand
--user2 les affecte a Marielle Goitschel 
--user1
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
--user2
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
--user1
update ENSEIGNE set nummono='2' where numcours=1;
--user2
update ENSEIGNE set nummono='4' where numcours = 11;
--user1
update ENSEIGNE set nummono='2' where numcours = 11;
--user2
update ENSEIGNE set nummono='4' where numcours=1 ;
--user1
commit;
--user2
commit; 
-- QU'OBSERVEZ-VOUS : rien ne change

-- QUESTION 6-------------------------------------------------------------------
-- user1 lit les informations sur les cours du Centre, user2 les retarde
--user1
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
select * from COURS where lieurv= 'Le Centre';
--user2 
begin; 
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
update COURS set heurefin = heurefin + interval '1 hours', heuredeb = heuredeb + interval '1 hours' where lieurv = 'Le Centre';
--user1
select * from COURS where lieurv = 'Le Centre';
--user2 
commit;
--user1
select * from COURS where lieurv = 'Le Centre';
commit;
-- QU'OBSERVEZ-VOUS : contrairement au mode READ COMMITED, le mode REPEATABLE READ permet de lire les données sans être perturbé par les modifications de user2 : les données sont coherentes au sein de la meme transaction

