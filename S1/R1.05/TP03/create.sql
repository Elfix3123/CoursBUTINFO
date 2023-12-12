CREATE TABLE ARTISTE(
	Surnom varchar(20) primary key,
	Specialite varchar NOT NULL,
	CONSTRAINT c_Specialite CHECK (Specialite IN ('jongleur', 'clown', 'acrobate', 'équilibriste'))
);

CREATE TABLE NUMERO(
	Titre varchar primary key,
	Responsable varchar(20) NOT NULL REFERENCES ARTISTE(Surnom)
);

CREATE TABLE INTERPRETE(
	Surnom varchar(20) REFERENCES ARTISTE(Surnom),
	Titre varchar REFERENCES NUMERO(Titre),
	primary key (Surnom, Titre)
);

CREATE TABLE ACCESSOIRE(
	CodeAcc numeric(3) primary key,
	Type varchar(20) DEFAULT 'autre',
	Couleur varchar,
	ImmatCamion char(9) NOT NULL,
	CONSTRAINT c_Couleur CHECK (Couleur IN (NULL, 'blanc', 'noir', 'rouge', 'bleu', 'vert', 'jaune', 'orange', 'violet')),
	CONSTRAINT c_ImmatCamion CHECK (ImmatCamion LIKE '__-___-__'),
	CONSTRAINT c_Type CHECK (Type IN ('ballon', 'cerceau', 'foulard', 'quilles', 'trapèze', 'corde', 'autre'))
);

CREATE TABLE UTILISATION(
	CodeAcc numeric(3) REFERENCES ACCESSOIRE(CodeAcc),
	Surnom varchar(20),
	Titre varchar,
	primary key (CodeAcc, Surnom, Titre),
	foreign key (Surnom, Titre) REFERENCES INTERPRETE (Surnom, Titre)
);

