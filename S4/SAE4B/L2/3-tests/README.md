# Introduction
Cet utilitaire permet de tester plusieurs aspects (connectivité, DNS, DHCP...) de l'infrastructure mise en place durant la SAE4.B. Il est à exécuter sur l'hyperviseur et utilise Python. Il utilise des fichiers de configuration en CSV. L'utilitaire est lancable avec le fichier `main.py` pour lancer toute la suite de tests, ou bien avec `PROGRAMME.py hosts.csv tests.csv` pour lancer un test en particulier.
Afin de réaliser des tests distants, les programmes peuvent créer une connexion SSH vers un hôte distant. Le fichier `hosts.csv`, dont un exemple est donné, décrit ces hôtes.  

## hosts.csv
| ip                          | user                                           | displayName               |
| --------------------------- | ---------------------------------------------- | ------------------------- |
| IP/Nom de domaine de l'hôte | Nom de l'utilisateur utilisé pour la connexion | Nom d'affichage de l'hôte |

Afin de réaliser les tests, une connexion SSH peut être réalisée avec des hôtes distants. Le SSH agent (ou équivalent) de l'hyperviseur est utilisé pour réaliser les connexions sans mot de passe avec Paramiko. 

---

## Connectivité
Utilisation : `python3 connectivite/connectivite.py hosts.csv tests.csv`. 
Permet de tester l'envoi d'une requête ICMP entre deux hôtes afin de réaliser des tests de connectivité ou de securité.

### tests.csv
| sip                            | dip                                 | expected               |
| ------------------------------ | ----------------------------------- | ---------------------- |
| IP/Nom de domaine de la source | IP/Nom de domaine de la destination | Résultat attendu (t/f) |

## DNS
Utilisation : `python3 dns/dns.py hosts.csv tests.csv`. 
Permet de tester la réponse d'un serveur DNS à une requète.

### tests.csv
| sip                            | dns                              | dn                      | expected               |
| ------------------------------ | -------------------------------- | ----------------------- | ---------------------- |
| IP/Nom de domaine de la source | IP/Nom de domaine du serveur DNS | Nom de domaine à tester | Résultat attendu (t/f) |

## HTTP
Utilisation : `python3 webhttp/http.py hosts.csv tests.csv`. 
Permet de tester la réponse d'un serveur HTTP à une requète.

### tests.csv
| hostaddress                    | domainName                       | expected               |
| ------------------------------ | -------------------------------- | ---------------------- |
| IP/Nom de domaine de la source | IP/Nom de domaine du serveur web | Résultat attendu (t/f) |

## DHCP
Utilisation : `python3 dhcp/dhcp.py hosts.csv tests.csv`. 
Permet de tester la réponse d'un serveur DHCP à une requète.

### tests.csv
| hostaddress                    | expected               |
| ------------------------------ | ---------------------- |
| IP/Nom de domaine de la source | Résultat attendu (t/f) |

## LDAP
Utilisation : `python3 ldap/ldap.py hosts.csv tests.csv`. 
Permet de tester la connexion à un poste utilisateur avec un compte de l'annuaire LDAP.

### tests.csv
| hostaddress                    | user        | expected               |
| ------------------------------ | ----------- | ---------------------- |
| IP/Nom de domaine de la source | Utilisateur | Résultat attendu (t/f) |

