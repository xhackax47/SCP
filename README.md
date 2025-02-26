# SCP Foundation

![SCP Foundation](https://us.v-cdn.net/6036147/uploads/I96REDZEDBSX/l-03-5-1-1200x675.jpg)

Application Java 23 + Spring Boot 3.4.2

## Configuration BDD
- Installer PostgreSQL et lancer pgAdmin
- Creer un groupe "scp" ainsi qu'un role user "scp_administrator" et l'assigner au groupe
- Creer une BDD "scp" avec comme propriétaire le groupe "scp"
- Faire un maven clean install pour vérifier que toute la configuration BDD fonctionne
- Penser à créer un fichier .env à la racine du projet contenant les infos nécessaires à application.properties