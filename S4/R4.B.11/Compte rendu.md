# nftables
Script de réinitialisation
```
#supprimer toutes les règles
flush ruleset

#accepter toutes les connexions entrantes et sortantes
table ip filter {
	chain input {
		type filter hook input priority 0; policy accept;
	}

	chain output{
		type filter hook output priority 0; policy accept;
	}
}
```
- Ajouter une règle : `add rule TABLE CHAIN RULE`
- Logs dans `journalctl`

 [Référence](https://wiki.nftables.org/wiki-nftables/index.php/Quick_reference-nftables_in_10_minutes)