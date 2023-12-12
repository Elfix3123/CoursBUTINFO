# C'est quoi l'archivage ?
L'archivage désigne le fait de stocker un répertoire dans un unique fichier, qui conserve la hiérarchie. Il est indépendant et sans perte, c'est-à-dire que si on archive un répertoire puis qu'on le supprime, il est possible de le restaurer de manière indiscernable. Il permet la compression et la préservation des attributs des fichiers. Il permet la manipulation plus aisée de répertoires, par exemple. 
Il existe plusieurs formats d'archive :
- Les **formats libres** et documentés, comme `.zip`, `.7zip`, `.tar.gz`, qui sont multi-OS et ont une pérennité des données garantie.
- Les **formats propriétaires** ou non documentés, comme `.rar`, souvent mono-OS et qui ne garantissent pas la pérennité des données.

Ces formats sont manipulables grâce aux [[Commandes Stockage et Archivage]].
Selon les formats, il existe plusieurs fonctionnements internes :
- Avec **zip**, chaque fichier est traité indépendamment. En outre, il n'archive pas les fichiers spéciaux ainsi que certains attributs.
- **tar** assure uniquement l'archivage, y compris des fichiers spéciaux et des attributs, et il est nécessaire de le compresser avec un autre logiciel.

La compression peut permettre de réduire les données d'un facteur entre 1 et 4, selon la répétition des données.