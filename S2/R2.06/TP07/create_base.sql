drop table if exists resultat;
drop table if exists regate;
drop table if exists equipier;
drop table if exists chefdebord;
drop table if exists course;
drop table if exists bateau;
drop table if exists cotisation;
drop table if exists tarif;
drop table if exists adherent;

create table adherent(
numadh serial primary key,
nom varchar,
prenom varchar,
fonction varchar not null default 'autre'
	constraint c_fonction check (fonction in
	('président','vice-président','trésorier','secrétaire','membre actif','autre')),
adresse varchar,
telephone varchar(14),
skipper bool not null default FALSE);

create table tarif(
annee int primary key,
montant real not null constraint c_montant check (montant >=0));

create table cotisation (
numadh int references adherent(numadh),
annee int references tarif(annee),
montant real default 0 constraint c_montant check (montant >=0),
payé bool,
primary key (numadh,annee));

create table bateau(
numbat serial primary key,
nombat varchar,
taille numeric(4,2),
nbplaces int check (nbplaces>=5));

create table course(
numcourse serial primary key,
port varchar,
datedebut date,
datefin date,
constraint c_dates check (datedebut<=datefin),
unique(datedebut));

create table chefdebord(
numcourse int references course(numcourse),
numadh int references adherent(numadh),
numbat int references bateau(numbat),
unique (numbat, numcourse),
primary key (numcourse, numadh));

create table equipier(
numcourse int,
numadh int references adherent(numadh),
numbat int,
foreign key (numbat, numcourse) references chefdebord (numbat, numcourse),
primary key (numcourse, numadh));

create table regate(
numcourse int references course(numcourse),
numregate int,
dateregate date,
primary key (numcourse,numregate));

create table resultat(
numbat int,
numcourse int,
numregate int,
classement int constraint c_classement check (classement >0),
foreign key (numcourse,numregate) references regate (numcourse, numregate),
foreign key (numcourse,numbat) references chefdebord(numcourse, numbat),
primary key (numbat, numcourse, numregate)); -- exaequos possibles...


\copy adherent (nom,prenom,fonction,adresse,telephone,skipper) from 'adherent.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy tarif from 'tarif.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy cotisation from 'cotisation.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy bateau (nombat, taille, nbplaces) from 'bateau.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy course (port,datedebut,datefin) from 'course.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
insert into course(port,datedebut,datefin) values ('Vannes',(current_date+interval '3 months')::date,(current_date+interval '3 months 5 days')::date);
\copy chefdebord from 'chefdebord.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy equipier from 'equipier.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy regate from 'regate.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy resultat from 'resultat.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
