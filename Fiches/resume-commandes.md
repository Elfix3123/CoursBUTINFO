# Commandes de base\
\
`pwd` : renvoie le repertoire courant\
`ls [-l] [-s] [-a] [-h]` : liste le contenu du repertoire courant\
	`[-l]` : liste les details de chaque entree\
	`[-s]` : affiche la taille de chaque entree en blocs\
	`[-a]` : affiche les entrees commencant par .\
	`[-h]` : affiche la taille des blocs\
`cd ADRESSE` : change le repertoire coutant vers ADRESSE\
`mv [-f] [-i] [-r] SOURCE... DESTINATION` : deplace les entrees SOURCE dans le repertoire DESTINATION\
	`[-f]` : force le deplacement\
	`[-i]` : demande une confirmation avant chaque deplacement\
`cp [-f] [-i] [-r] SOURCE... DESTINATION` : copie les entrees SOURCE dans le repertoire DESTINATION\
	`[-f]` : force la copie\
	`[-i]` : demande une confirmation avant chaque copie\
`mkdir REPERTOIRE` : cree un repertoire vide\
`rmdir REPERTOIRE` : supprime un repertoire vide\
`rm [-f] [-i] [-r]` : supprime une entree\
	`[-f]` : force la suppression\sss
	`[-i]` : demande une confirmation avant chaque supression\
	`[-r]` : supprime un répertoire et son contenu\
`history` : renvoie les commandes tapees precedemment\
`man LOGICIEL` : affiche le manuel de LOGICIEL\
`echo ENTREE` : renvoie ENTREE\
`alias COMMANDE=CHAINE` : rajoute au shell actif un alias\
`chmod [u|g|o][+|-][r|w|x] ENTREE` : donne ou retire des permissions sur ENTREE\
\
# Scripts\
\
#!/bin/bash au début de chaque script bash	\
`shellcheck SCRIPT` : verifie que SCRIPT est ecrit correctement \
\
# Recherche\
\
`find ENTREE` : recherche ENTREE dans l'arborescence du repertoire courant\
`locate ENTREE` : recherche ENTREE dans l'index du systeme\
\
# Gestion de texte\
\
`cat FICHIER...` : concatene les fichiers FICHIER et les renvoie\
`more FICHIER` : affiche FICHIER\
`less FICHIER` : amelioraiton de more\
\
# Processus\
\
`ps [-e] [-f] [-u]` : affiche les processus lies au shell courant\
	`[-e]` : affiche tous les processus du systeme\
	`[-f]` : affiche des information supplementaires comme le PID\
	`[-u]` : affiche des information supplementaires comme l'utilisation de la RAM\
`pstree -u` : affiche l'arbre des processus du systeme\
`top` : affiche interactivement les processus du systeme\
`kill [-SIGNAL] PID` : tue le processus PID\
	`[-SIGNAL]` : precise le signal a envoyer au processus\
`killall NOM` : tue tous les processus ayant pour nom NOM\
`free` : affiche des informations sur les ressources de la machine\
\
# Filtres\
\
`grep MOT` : renvoie les lignes qui contiennent MOT - . remplace tous les caracteres - * repete le caractere precedent\
`wc` : affiche le nombre de bytes, de mots, de lignes de l'entree\
`head` : affiche seulement les premieres lignes\
`tail` : affiche seulement les dernieres lignes\
`uniq` : omet les lignes repetees\
`sort` : trie\
`cut -c SELECTION_COLONNES [FICHIER...] ` : enlève certaines partie de l'entrée\
`diff [-r] ENTREE1 ENTREE2` : compare ENTREE1 et ENTREE2 ligne par ligne\
	`[-r]` : execute le logiciel recursivement\
\
# Gestion de l'éspace de stockage\
\
`du [-h]` : renvoie l'espace occupe par un repertoire\
`lsblk` : liste les peripheriques de stockage et les partitions\
`df [-h]` : affiche des informations sur les partitions montees de la machine\
	`[-h]` : affiche la taille des blocs\
`duf` : df en mieux\
`ncdu` : du en mieux\
`qdirstat` : logiciel graphique d'analyse de l'espace occupe\
\
# Archivage et compression\
\
`zip -r9 DESTINATION SOURCE` : zippe le fichier SOURCE dans DESTINATION\
`unzip SOURCE` : dezippe le fichier SOURCE dans le repertoire courant\
`zip -T ZIP` : verifie l'integrite de ZIP\
`tar --[gzip|bzip2|xz|zstd] -cvf DESTINATION SOURCE` : cree une archive de SOURCE au format `tar+[gzip|bzip2|xz|zstd]` dans DESTINATION\
`tar --[gzip|bzip2|xz|zstd] -xvf SOURCE` : desarchive SOURCE au format `tar+[gzip|bzip2|xz|zstd] `dans le repertoire courant\
`[gzip|bzip2|xz|zstd] -t ARCHIVE` : verifie l'integrite de ARCHIVE\
`7z a DESTINATION SOURCE` : cree une archive de SOURCE au format 7zip dans DESTINATION\
`7z x SOURCE` : desarchive SOURCE au format 7zip dans DESTINATION\
`7z t ARCHIVE` : verifie l'integrite de ARCHIVE\
\
# Gestion des packages\
\
`dpkg -l` : liste les packages installes\
`apt search MOT` : cherche un package par mot clef\
`dpkg -S FICHIER` : cherche a quel package appartient FICHIER\
`dpkg -s PACKAGE` : affiche les metadonnees de PACKAGE\
`dpkg -L PACKAGE` : affiche le contenu de PACKAGE\
\
# Gestion des utilisateurs\
\
`su -` : se connecte en tant que root\
`sudo -i` : donne au shell les permissions root\
`getent` : affiche la liste des utilisateurs connus par le systeme\
\
\
`ln [-s] CIBLE NOM` : créé un lien vers CIBLE appele NOM\
	`[-s]` : rend le lien symbolique\
`whereis COMMANDE` : renvoie l'adresse de la source de COMMANDE\
\
`rwho` : affic	he les noms de login des personnes en train de travailler sur l'une des stations du réseau\
`who` : affiche les logins des autres utilisateurs actifs de la machine\
`ruptime` : affiche des informations sur les machines du réseau\
`ssh [-X] DESTINATION` : créé un tunnel SSH vers DESTINATION\
	`[-X]` : lance un client X11 à distance\
\
`scp [-r] [-p]` : SOURCE DESTINATION: copie des fichiers et répertoires entre utilisateurs ou machines\
	`[-r]` : copie recursivement les entrees\
	`[-p]` : garde certaines métadonnées\
