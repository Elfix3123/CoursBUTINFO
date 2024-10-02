 Utiliser un serveur DHCP :
 - Le fichier de configuration /etc/udhcpd.conf contient des configuration propres à un serveur DHCP
    - start et end représentent les adresses de début et de fin allouables
    - option subnet représente le masque de réseau à utiliser
    - opt routeur représente l'adresse de la passerelle par défault
    - opt dns représente l'adresse du serveur DNS par défault
    - option lease représente la durée en secondes du bail
    - interface représente l'interface par laquelle accepter les requetes DHCP
- Une fois le service lancé (systemctl start udhcpd), le client peut envoyer des requetes DHCP au serveur
    - Commande ifup INTERFACE
    - La route par défault sera modifié pour ajouter la passerelle specifiée
    - Le fichier /etc/resolv.conf sera modifié pour ajouter le serveur DNS specifié

Configuration d'un serveur DNS :
- Configurations stockées dans /etc/bind9/
- Fichier de configuration principal : named.conf.default-zones
- Autres fichiers : db.site.tdl


Mettre en place des VLANs :
- Associer chaque port du switch à un VLAN
- Mettre les ports en mode 802.1Q

Configuration d'un service web :
- Pages HTML stockées dans /var/www/
- Configuration de virtual hosts :
	- Configurations stockées dans /etc/apache2/sites-available/
	- Copier le fichier 000-default.conf, le renommer et le modifier en fonction des besoins (directives ServerName et DocumentRoot)
	- Commande a2ensite pour activer le VH