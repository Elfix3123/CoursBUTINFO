# Pourquoi le réseau ?
Le réseau a plusieurs avantages : il permet la centralisation, par exemple du stockage, des applications, des sauvegardes ou des ressources, mais surtout l'accès à Internet.
# Adresses IP
L'adresse IP est un des moyens d'identifier une machine sur Internet; elles servent au routage. Cependant, leur format habituel, l'IPv4, est en train de s'épuiser, d'où l'invention de plusieurs solutions pour y parer :
- Les adresses privées sont des adresses IP réservées que chacun peut utiliser : elles peuvent être utilisées dans des réseaux privés par chacun. Ainsi, on peut utiliser plus d'adresses qu'il en existe réellement. Elles sont routées dans le réseau privé, mais pas en dehors.
- L'IPv6 est un format qui code les adresses IP sur plus de bits, afin de libérer des slots.
Afin de configurer les adresses IP sur un réseau, il est possible de les configurer manuellement ou automatiquement avec le protocole DHCP ou DHCPv6.
Lors que plusieurs logiciels tournent sur la même machine, on fait intervenir le numéro de port, qui permet d'adresser un message à un logiciel précis. Il existe plusieurs ports prédéfinis à certains usages, comme le port 80 pour le web, le port 25 pour les mails SMTP…
# Travail à distance
Il existe 2 formes de travail à distance : l'utilisation de machines à distance et le transfert de fichiers.
Voici quelques protocoles de travail à distance textuels :
- Le protocole **telnet**, ancien et plus utilisé, sans aucune sécurité.
- Le protocole **SSH**, plus sécurisé car les communications sont chiffrées.

Et quelques protocoles graphiques :
- Le protocole **X11**, avec lequel le serveur graphique tourne sur la machine locale et les applications sur la machine cliente. 
- Le protocole **VNC** permet moins de latence et gagne en simplicité en faisant tourner le serveur graphique sur le serveur.
- Le protocole **X2Go** est plus simple à utiliser.
# Partage et transfert de fichiers