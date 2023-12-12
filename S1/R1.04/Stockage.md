# Stockage local
Un ordinateur contient généralement un ou plusieurs périphériques de stockages : des Direct Attached Storage. Il en existe plusieurs types - HDD et SSD - et plusieurs interfaces - SATA, NVMe, USB…
Un périphérique de stockage est généralement découpé en plusieurs partitions. Il y en a au général minimum 1 sur les BIOS, 2 sur les UEFI, une pour l'OS et une pour le démarrage du système sur UEFI. Chaque OS requiert une partition.
Sous Linux, il existe plusieurs conventions :
- Le répertoire `/dev/` qui contient les pseudo fichiers, appelés **block device**, représentant disques et partition.
- Les répertoires `/dev/sda/`, `/dev/sdb/`… pour les périphériques SATA et USB
- Les répertoires `/dev/nvme0n1/`, `/dev/nvme0n2/`pour les périphériques NVMe.
- Les répertoires `/dev/sdX1/`, `/dev/nvme0nXi2/` pour les partitions.

On peut observer disques et partitions avec plusieurs [[Commandes Stockage et Archivage]].
# Stockage en réseau
Le terme générique d'un système de stockage en réseau est Network Attached Stockage. Il contient un ou plusieurs serveurs de fichiers, ainsi que des protocoles réseau qui font le lien entre client et serveur. Lors de l'utilisation d'un NAS, on est soumis à des quotas, un pour l'espace disque et un pour le nombre total de fichiers. Le quota peut être temporairement dépassé avec le délai de grâce, par défaut 7 jours, mais au delà il est nécessaire de repasser en dessous de ce quota afin de pouvoir réécrire sur le serveur. Il existe également une limite, impossible à dépasser car les écritures sont immédiatement bloquées.