--- QUESTION 1.1

SELECT relname, relpages, reltuples
FROM pg_class
WHERE relname IN ('departments', 'departments_capital_key', 'departments_code_key', 'departments_id_key', 'departments_id_seq', 'departments_name_key', 'towns', 'towns_id_key', 'towns_id_seq', 'towns_code_department_key', 'regions', 'regions_code_key', 'regions_id_key', 'regions_id_seq', 'regions_name_key')
ORDER BY relname;

-- La table pg_class contient une ligne pour chaque relation (table, toast, vue, sequence...) 
-- L'attribut relname est le nom de la relation
-- L'attribut relpages est la taille de la relation en BLCKSZ
-- L'attribut reltuples est le nombre de lignes de la table

/*
          relname          | relpages | reltuples 
---------------------------+----------+-----------
 departments               |        1 |       100
 departments_capital_key   |        2 |       100
 departments_code_key      |        2 |       100
 departments_id_key        |        2 |       100
 departments_id_seq        |        1 |         1
 departments_name_key      |        2 |       100
 regions                   |        0 |        -1
 regions_code_key          |        1 |         0
 regions_id_key            |        1 |         0
 regions_id_seq            |        1 |         1
 regions_name_key          |        1 |         0
 towns                     |      251 |     36684
 towns_code_department_key |      135 |     36684
 towns_id_key              |      103 |     36684
 towns_id_seq              |        1 |         1
(15 rows)
*/

--- QUESTION 1.2

-- La commande ANALYZE collecte des statistiques sur la base de données courante et stocke le résultat dans pg_statistic.

--- QUESTION 2.1

EXPLAIN SELECT * FROM TOWNS;

/*
                         QUERY PLAN                         
------------------------------------------------------------
 Seq Scan on towns  (cost=0.00..617.84 rows=36684 width=54)
(1 row)
*/

-- La commande EXPLAIN indique que la seule opération efféctuée sera un Seq Scan (une séléction séquentielle des lignes nécessaires, représentée par une projection en arithmetique), et que cette opération aura aura un coût entre 0 et 617.84, retournera 36684 lignes et la largeur moyenne des lignes, en octets. Cette commande n'effectue pas actuellement la commande et ne donne que des estimations (ajouter ANALYZE pour effectuer les opérations).

EXPLAIN ANALYZE SELECT * FROM TOWNS;

/*
                                                QUERY PLAN                                                
----------------------------------------------------------------------------------------------------------
 Seq Scan on towns  (cost=0.00..617.84 rows=36684 width=54) (actual time=0.019..5.381 rows=36684 loops=1)
 Planning Time: 0.108 ms
 Execution Time: 8.301 ms
(3 rows)
*/

--- QUESTION 2.2 

EXPLAIN SELECT code, name FROM towns;

/*
                         QUERY PLAN                         
------------------------------------------------------------
 Seq Scan on towns  (cost=0.00..617.84 rows=36684 width=15)
(1 row)
*/

-- Seulement une projection est efféctuée, ce qui est coherent sachant qu'aucune clause WHERE n'est présente.

felix=> EXPLAIN SELECT t.name, d.name, r.name FROM towns t JOIN departments d ON (t.department = d.code) JOIN regions r ON (d.region = r.code);

/*
                                    QUERY PLAN                                    
----------------------------------------------------------------------------------
 Hash Join  (cost=4.83..835.05 rows=36684 width=34)
   Hash Cond: ((d.region)::text = (r.code)::text)
   ->  Hash Join  (cost=3.25..721.47 rows=36684 width=25)
         Hash Cond: ((t.department)::text = (d.code)::text)
         ->  Seq Scan on towns t  (cost=0.00..617.84 rows=36684 width=15)
         ->  Hash  (cost=2.00..2.00 rows=100 width=16)
               ->  Seq Scan on departments d  (cost=0.00..2.00 rows=100 width=16)
   ->  Hash  (cost=1.26..1.26 rows=26 width=15)
         ->  Seq Scan on regions r  (cost=0.00..1.26 rows=26 width=15)
(9 rows)
*/

-- Hash join est une methode de produit cartésien qui permet de rendre le produit cartésien en O(n) plutot que O(n²), et hash cond correspond aux clefs qui seront hashées

EXPLAIN SELECT count(*) FROM towns;

/*
                           QUERY PLAN                            
-----------------------------------------------------------------
 Aggregate  (cost=709.55..709.56 rows=1 width=8)
   ->  Seq Scan on towns  (cost=0.00..617.84 rows=36684 width=0)
(2 rows)
*/

-- Apres le seq scan, une aggregation est faite afin de compter le nombre d'entrées du seq scan

EXPLAIN SELECT department, count(*) FROM towns GROUP BY departments;

/*
                           QUERY PLAN                            
-----------------------------------------------------------------
 HashAggregate  (cost=801.26..802.26 rows=100 width=11)
   Group Key: department
   ->  Seq Scan on towns  (cost=0.00..617.84 rows=36684 width=3)
(3 rows)
*/

-- HashAggregate est une méthode de groupement qui permet de rendre le groupement en O(n) plutot que O(n²)

EXPLAIN SELECT region, count(*) FROM departments GROUP BY region;

/*
                            QUERY PLAN                             
-------------------------------------------------------------------
 HashAggregate  (cost=2.50..2.76 rows=26 width=11)
   Group Key: region
   ->  Seq Scan on departments  (cost=0.00..2.00 rows=100 width=3)
(3 rows)
*/

EXPLAIN SELECT region, count(*) FROM departments GROUP BY region HAVING count(*) > 5;

/*
                            QUERY PLAN                             
-------------------------------------------------------------------
 HashAggregate  (cost=2.50..2.82 rows=9 width=11)
   Group Key: region
   Filter: (count(*) > 5)
   ->  Seq Scan on departments  (cost=0.00..2.00 rows=100 width=3)
(4 rows)
*/

-- Un filtre a ete rajoute sur le HashAggregate, qui correspond au having

--- QUESTION 3.1

SELECT * FROM TOWNS WHERE name = 'Grenoble' ;

/*
  id   | code | article |   name   | department 
-------+------+---------+----------+------------
 14859 | 185  |         | Grenoble | 38
(1 row)
*/

EXPLAIN SELECT * FROM TOWNS WHERE name = 'Grenoble' ;

/*
                       QUERY PLAN                       
--------------------------------------------------------
 Seq Scan on towns  (cost=0.00..709.55 rows=1 width=54)
   Filter: (name = 'Grenoble'::text)
(2 rows)
*/

-- Aucun index n'a ete cree car name n'est pas pkey

CREATE INDEX towns_name_index ON towns(name);

/*
                                  QUERY PLAN                                   
-------------------------------------------------------------------------------
 Index Scan using towns_name_index on towns  (cost=0.29..8.31 rows=1 width=54)
   Index Cond: (name = 'Grenoble'::text)
(2 rows)
*/

-- Le plan d'execution utilise desormais l'index pour aller plus vite

-- QUESTION 3.2

EXPLAIN SELECT towns.code, towns.name
FROM towns, departments
WHERE towns.department = departments.code
AND departments.name = 'Isère' ;

/* Index par défaut
                              QUERY PLAN                               
-----------------------------------------------------------------------
 Hash Join  (cost=2.26..720.48 rows=367 width=15)
   Hash Cond: ((towns.department)::text = (departments.code)::text)
   ->  Seq Scan on towns  (cost=0.00..617.84 rows=36684 width=18)
   ->  Hash  (cost=2.25..2.25 rows=1 width=3)
         ->  Seq Scan on departments  (cost=0.00..2.25 rows=1 width=3)
               Filter: (name = 'Isère'::text)
(6 rows)
*/

/* Aucun index
                              QUERY PLAN                               
-----------------------------------------------------------------------
 Hash Join  (cost=2.26..761.34 rows=367 width=15)
   Hash Cond: ((towns.department)::text = (departments.code)::text)
   ->  Seq Scan on towns  (cost=0.00..617.84 rows=36684 width=18)
   ->  Hash  (cost=2.25..2.25 rows=1 width=3)
         ->  Seq Scan on departments  (cost=0.00..2.25 rows=1 width=3)
               Filter: (name = 'Isère'::text)
(6 rows)
*/

/* Index sur departments(name)
                              QUERY PLAN                               
-----------------------------------------------------------------------
 Hash Join  (cost=2.26..761.34 rows=367 width=15)
   Hash Cond: ((towns.department)::text = (departments.code)::text)
   ->  Seq Scan on towns  (cost=0.00..617.84 rows=36684 width=18)
   ->  Hash  (cost=2.25..2.25 rows=1 width=3)
         ->  Seq Scan on departments  (cost=0.00..2.25 rows=1 width=3)
               Filter: (name = 'Isère'::text)
(6 rows)
*/

/* Index sur departments(code)
                              QUERY PLAN                               
-----------------------------------------------------------------------
 Hash Join  (cost=2.26..761.34 rows=367 width=15)
   Hash Cond: ((towns.department)::text = (departments.code)::text)
   ->  Seq Scan on towns  (cost=0.00..617.84 rows=36684 width=18)
   ->  Hash  (cost=2.25..2.25 rows=1 width=3)
         ->  Seq Scan on departments  (cost=0.00..2.25 rows=1 width=3)
               Filter: (name = 'Isère'::text)
(6 rows)
*/

/* Index sur departements(code) et towns(department)
                                         QUERY PLAN                                         
--------------------------------------------------------------------------------------------
 Nested Loop  (cost=0.29..22.63 rows=367 width=15)
   ->  Seq Scan on departments  (cost=0.00..2.25 rows=1 width=3)
         Filter: (name = 'Isère'::text)
   ->  Index Scan using towns_department_key on towns  (cost=0.29..16.71 rows=367 width=18)
         Index Cond: ((department)::text = (departments.code)::text)
(5 rows)
*/

/*Index sur departements(code), towns(department) et departments(name)
                                         QUERY PLAN                                         
--------------------------------------------------------------------------------------------
 Nested Loop  (cost=0.29..22.63 rows=367 width=15)
   ->  Seq Scan on departments  (cost=0.00..2.25 rows=1 width=3)
         Filter: (name = 'Isère'::text)
   ->  Index Scan using towns_department_key on towns  (cost=0.29..16.71 rows=367 width=18)
         Index Cond: ((department)::text = (departments.code)::text)
(5 rows)
*/

--- QUESTION 4.1

EXPLAIN ANALYZE SELECT t.name, d.name
FROM towns t, departments d
WHERE t.department = d.code
AND d.region = '82';

/*
                                                                QUERY PLAN                                                                
------------------------------------------------------------------------------------------------------------------------------------------
 Nested Loop  (cost=0.29..209.31 rows=2935 width=22) (actual time=0.070..1.789 rows=2879 loops=1)
   ->  Seq Scan on departments d  (cost=0.00..2.25 rows=8 width=13) (actual time=0.025..0.051 rows=8 loops=1)
         Filter: ((region)::text = '82'::text)
         Rows Removed by Filter: 92
   ->  Index Scan using towns_department_key on towns t  (cost=0.29..22.21 rows=367 width=15) (actual time=0.014..0.120 rows=360 loops=8)
         Index Cond: ((department)::text = (d.code)::text)
 Planning Time: 0.320 ms
 Execution Time: 2.066 ms
(8 rows)
*/

EXPLAIN ANALYZE SELECT name, department
FROM towns
WHERE department IN (SELECT code FROM departments WHERE region = '82');

/*
                                                               QUERY PLAN                                                               
----------------------------------------------------------------------------------------------------------------------------------------
 Nested Loop  (cost=2.56..209.41 rows=2935 width=15) (actual time=0.098..1.711 rows=2879 loops=1)
   ->  HashAggregate  (cost=2.27..2.35 rows=8 width=3) (actual time=0.062..0.067 rows=8 loops=1)
         Group Key: (departments.code)::text
         Batches: 1  Memory Usage: 24kB
         ->  Seq Scan on departments  (cost=0.00..2.25 rows=8 width=3) (actual time=0.025..0.048 rows=8 loops=1)
               Filter: ((region)::text = '82'::text)
               Rows Removed by Filter: 92
   ->  Index Scan using towns_department_key on towns  (cost=0.29..22.21 rows=367 width=15) (actual time=0.013..0.112 rows=360 loops=8)
         Index Cond: ((department)::text = (departments.code)::text)
 Planning Time: 0.346 ms
 Execution Time: 1.991 ms
(11 rows)
*/

EXPLAIN ANALYZE SELECT t.name, d.name
FROM towns t JOIN departments d ON (t.department = d.code)
AND d.region = '82';

/*
                                                                QUERY PLAN                                                                
------------------------------------------------------------------------------------------------------------------------------------------
 Nested Loop  (cost=0.29..209.31 rows=2935 width=22) (actual time=0.069..1.670 rows=2879 loops=1)
   ->  Seq Scan on departments d  (cost=0.00..2.25 rows=8 width=13) (actual time=0.029..0.052 rows=8 loops=1)
         Filter: ((region)::text = '82'::text)
         Rows Removed by Filter: 92
   ->  Index Scan using towns_department_key on towns t  (cost=0.29..22.21 rows=367 width=15) (actual time=0.013..0.108 rows=360 loops=8)
         Index Cond: ((department)::text = (d.code)::text)
 Planning Time: 0.295 ms
 Execution Time: 1.933 ms
(8 rows)
*/