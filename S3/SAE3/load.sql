\COPY commerces FROM 'commerces.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8'
\COPY hebergements FROM 'hebergements.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8'
\COPY bornes_electriques FROM 'bornes_electriques.csv' DELIMITER ',' CSV HEADER ENCODING 'UTF8'