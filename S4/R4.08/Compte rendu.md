# La virtualisation en 1 minute
## Virtualisation
La virtualisation représente l'ensemble des techniques permettant d'émuler une architecture donnée sur un système informatique. 
La virtualisation permet d'alléger considérablement tout installation : au lieu de devoir déployer plusieurs machines, serveurs et réseaux, la virtualisation permet d'attribuer des ressources présentes sur une ou plusieurs machines entre des hôtes virtuels. On augmente la facilité d'installation et la modularité tout en diminuant le coût, on facilite la duplication de machines similaires grâce aux images et on améliore l'interopérabilité avec le support de plusieurs OS. 
## Hyperviseur
On appelle hyperviseur l'hôte des machines virtuelles. L'hyperviseur peut être :
- **Type 1**, c'est-à-dire qu'il est installé directement sur le matériel
- **Type 2**, c'est-à-dire qu'il est installé dans un OS
## Réseau
Les réseaux virtuels peuvent fonctionner selon deux modes :
- Le **mode bridge**, qui lie une interface de l'hyperviseur à une interface de la VM
	- Nécessité de gérer le réseau depuis la machine hôte si VLAN  
	- Connexion automatique et naturelle vers l'extérieur via une interface
- Le **mode NAT**, où les VMs sont dans un VLAN géré par l'hyperviseur avec le NAT
	- Possibilité de relier avec l'extérieur avec de la redirection de port
	- Connexion manuelle vers l'extérieur
## Outils de virtualisation
### Qemu/KVM
KVM est un module du kernel Linux qui lui permet de fonctionner comme un hyperviseur.
Qemu est un émulateur dont le but principal est de faire tourner un executable fait pour une architecture X sur une architecture Y. Si X et Y sont similaires, Qemu peut utiliser des librairies de Y pour alléger son fonctionnement : on dit que Qemu fait de la **paravirtualisation**. 
Concrètement, Qemu émule plusieurs composants matériels classiques - comme des cartes réseau, de la mémoire où du stockage - afin de faire naître des machines virtuelles dans une machine.
Qemu permet de faire des **snapshots** de ses VMs ; une snapshot est une image d'une VM à un instant précis, qui peut être restauré plus facilement qu'une machine physique.
### Libvirt
Libvirt est un middleware entre une machine et un hyperviseur/container. Il permet d'accéder aux VMs et de les paramétrer. 
Selon le besoin, il peut tourner en privilégié ou non (User-session).
Libvirt peut lui-même utiliser d'autres surcouches :
- **virt-manager**, interface graphique de Libvirt, permet une gestion facilitée des composants de la VM et des unités d'émulation (CPU, RAM, réseau...)
- **virsh**, interface CLI de Libvirt, permet d'automatiser la gestion des VMs avec des scripts
### Proxmox
Proxmox est un hyperviseur qui permet de gérer depuis une interface web le déploiement de VM avec des réseaux, volumes, ressources...
Proxmox peut fonctionner avec plusieurs modules afin de créer des réseaux complexes ; il propose des modules afin d'émuler des composants comme des switch, pare-feux ou routeurs.
Proxmox peut utiliser un agent Qemu pour interagir avec les VMs.
## Containérisation
La virtualisation diffère de la containérisation dans le sens où une machine virtuelle émule l'ensemble de l'OS pour chaque machine virtuelle alors qu'un container s'execute sur l'OS hôte en s'isolant avec des **user spaces** ; un container est plus léger puis qu'il utilise l'OS hôte et ses librairies.