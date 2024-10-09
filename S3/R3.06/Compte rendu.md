 Utiliser un serveur DHCP :
 - Le fichier de configuration `/etc/udhcpd.conf` contient des configuration propres à un serveur DHCP
    - `start` et `end` représentent les adresses de début et de fin allouables
    - `option subnet` représente le masque de réseau à utiliser
    - `opt routeur` représente l'adresse de la passerelle par default
    - `opt dns` représente l'adresse du serveur DNS par default
    - `option lease` représente la durée en secondes du bail
    - `interface` représente l'interface par laquelle accepter les requêtes DHCP
- Une fois le service lancé (`systemctl start udhcpd`), le client peut envoyer des requêtes DHCP au serveur
    - Commande `ifup INTERFACE`
    - La route par default sera modifié pour ajouter la passerelle spécifiée
    - Le fichier `/etc/resolv.conf` sera modifié pour ajouter le serveur DNS spécifié

Configuration d'un serveur DNS :
- Configurations stockées dans `/etc/bind/`
- Fichier de configuration principal : `named.conf.default-zones`
- Autres fichiers de configuration : `db.SITE.TDL`

Mettre en place des VLANs :
- Associer chaque port du switch à un VLAN
- Mettre les ports en mode 802.1Q

Configuration d'un service web Apache :
- Pages HTML stockées dans `/var/www/`
- Copier le fichier `/etc/apache2/sites-available/000-default.conf` et le renommer pour créer les fichiers de configuration des sites (par ex `SITE.conf`)
- Commande `a2ensite SITE` pour activer le fichier de configuration d'un site
- Configuration de virtual hosts :
	- Editer le fichier `/etc/apache2/sites-available/SITE.conf` : modifier la directive `DocumentRoot` pour mettre le répertoire du site (par ex `/var/www/site/`), ajouter la directive `ServerName` pour mettre l'URL du site (par ex `site.fr`)
- Configuration HTTPS
	- Faire la commande `a2enmod ssl`
	- Editer le fichier `/etc/apache2/sites-available/SITE.conf` : rajouter les directives `SSLEngine On`, `SSLCertificateFile CERTIFICATE.crt` et `SSLCertificateKeyFile KEY.key` et éditer le port d'entrée pour mettre 443 au lieu de 80