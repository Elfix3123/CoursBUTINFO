drop table if exists meurt_dans;
drop table if exists apparait_dans;
drop table if exists etat_civil;
drop table if exists personnage;
drop table if exists realise;
drop table if exists film;

create table film (
  numero int primary key,
  titre text unique not null,
  annee int
);

create table realise (
  numero int references film(numero),
  realisateur text,
  primary key (numero,realisateur)
);

create table personnage (
  nom text primary key,
  alias text unique
);

create table etat_civil (
  nom text primary key references personnage(alias),
  annee int,
  etat text
);

create table apparait_dans (
  numero int references film(numero),
  nom text references personnage(nom),
  post_generique boolean default 'false',
  primary key (numero, nom)
);

create table meurt_dans (
  numero int,
  nom text primary key,
  foreign key (numero,nom) references apparait_dans(numero, nom)
);

\copy film from '/users/info/pub/1a/R2.06/bases/avengers/film.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy realise from '/users/info/pub/1a/R2.06/bases/avengers/realise.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy personnage from '/users/info/pub/1a/R2.06/bases/avengers/personnage.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy etat_civil from '/users/info/pub/1a/R2.06/bases/avengers/etat_civil.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy apparait_dans from '/users/info/pub/1a/R2.06/bases/avengers/apparait_dans.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
\copy meurt_dans from '/users/info/pub/1a/R2.06/bases/avengers/meurt_dans.csv' with (delimiter ';', format CSV, HEADER, ENCODING 'UTF8');
