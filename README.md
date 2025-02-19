# SCP

Application
## Configuration BDD
- Installer PostgreSQL et lancer pgAdmin
- Creer un groupe "scp" ainsi qu'un role user "scp_administrator" et l'assigner au groupe
- Creer une BDD "scp" avec comme propriétaire le groupe "scp"
- Faire un maven clean install pour vérifier que toute la configuration BDD fonctionne
- Penser à créer un fichier .env à la racine du projet contenant les infos nécessaires à application.properties