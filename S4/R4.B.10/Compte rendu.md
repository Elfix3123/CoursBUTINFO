# PGP
## Fonctionnement
Clefs PGP = deux clefs :
- Une publique 
- Une privée 
### Signature
La signature permet de vérifier l’intégrité d'un document (comme un mail). L'auteur utilise une clef de signature et le hash du document pour produire la signature, généralement un `.sig`. En principe, elle associe un document à une autorité.
### Certificat
Un certificat permet de vérifier un lien entre une identité (nom complet et adresse mail) et une clef publique. 
### Chiffrement
Utiliser la clef publique de quelqu'un pour chiffrer un document assure que seul les détenteurs de la clef privée pourrons la déchiffrer.
## Commandes
- Générer une paire de clefs : `gpg --full-generate-key`
- Uploader des clefs : `gpg --send-keys --keyserver keys.openpgp.org CLEF`
- Télécharger des clefs : `gpg --recv-keys --keyserver keyserver.ubuntu.com CLEF`
- Vérifier une signature : `gpg --verify CLEF DOCUMENT_A_VERIFIER`
- Calculer une empreinte de clef : `gpg --fingerprint CLEF`
- Signer une clef : `gpg --sign-key CLEF`