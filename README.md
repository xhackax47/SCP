# SCP Foundation

![SCP Foundation](https://us.v-cdn.net/6036147/uploads/I96REDZEDBSX/l-03-5-1-1200x675.jpg)

La Fondation SCP est une œuvre de fiction tirée du site d'écriture collaborative du même nom et en cours de rédaction depuis 2007. 
Elle est centrée sur l'univers de la Fondation SCP, une organisation secrète chargée de cacher l'existence des phénomènes surnaturels.

### Stack technique

 - [Java 23](https://www.oracle.com/fr/java/technologies/downloads/#java23)
 - [Spring Boot 3.4.2](https://spring.io/blog/2025/01/23/spring-boot-3-4-2-available-now)
 - [Angular 19](https://v19.angular.dev/)
 - [PostgreSQL](https://www.postgresql.org/)
 - [GitGuardian](https://www.gitguardian.com/)

### Configuration BDD
- Installer PostgreSQL et lancer pgAdmin
- Creer un groupe "scp" ainsi qu'un role user "scp_administrator" et l'assigner au groupe
- Creer une BDD "scp" avec comme propriétaire le groupe "scp"
- Faire un maven clean install pour vérifier que toute la configuration BDD fonctionne
- Penser à créer un fichier .env à la racine du projet contenant les infos nécessaires à application.properties