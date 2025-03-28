# SCP Foundation

![SCP Foundation](https://us.v-cdn.net/6036147/uploads/I96REDZEDBSX/l-03-5-1-1200x675.jpg)

La Fondation SCP est une œuvre de fiction tirée du site d'écriture collaborative du même nom et en cours de rédaction depuis 2007. 
Elle est centrée sur l'univers de la Fondation SCP, une organisation secrète chargée de cacher l'existence des phénomènes surnaturels.

## Contexte de l'application

Cette application plutôt roleplay permettra de se connecter et d'accéder aux données SCP selon votre niveau de sécurité (Classe D, CLasse C, Classe B, Classe A et 05) comme le ferait une vraie application présente dans la Fondation SCP.

![Exemple Page Register](https://i.ibb.co/DP1zfSKG/Capture-d-cran-2025-03-21-230638.png)
![Exemple Page Login](https://i.ibb.co/kk41dzm/Capture-d-cran-2025-03-21-230606.png)

## Stack technique

 - [Java 23](https://www.oracle.com/fr/java/technologies/downloads/#java23)
 - [Spring Boot 3.4.2](https://spring.io/blog/2025/01/23/spring-boot-3-4-2-available-now)
 - [Angular 19](https://v19.angular.dev/)
 - [PostgreSQL](https://www.postgresql.org/)
 - [GitGuardian](https://www.gitguardian.com/)

## Configuration Serveurs en Local
### Serveur BackEnd (Spring Boot 3.4.2)
- Concernant le back, il suffit de lancer l'application Spring Boot SCP_Back par exemple via Eclipse afin de pouvoir lancer le serveur 
Apache Tomcat et consommer les API Rest puis aller sur http://localhost:8080/ pour se connecter et voir les endpoints.
- NE PAS OUBLIER DE FAIRE UN MAVEN CLEAN ET MAVEN INSTALL POUR QUE TOUTES LES DEPENDANCES BACK SOIENT BIEN INSTALLEES.

### Serveur FrontEnd (Angular 19)
- Concernant le front, il suffit de se mettre en mode terminal dans la racine de SCP_Front puis de lancer la commande "ng serve" afin de lancer
le serveur Angular et aller ensuite sur http://localhost:4200/.
- - NE PAS OUBLIER DE FAIRE UN NPM INSTALL POUR QUE TOUTES LES DEPENDANCES FRONT SOIENT BIEN INSTALLEES.

### Configuration BDD
- Installer PostgreSQL et lancer pgAdmin
- Creer un groupe "scp" ainsi qu'un role user "scp_administrator" et l'assigner au groupe
- Creer une BDD "scp" avec comme propriétaire le groupe "scp"
- Faire un maven clean install pour vérifier que toute la configuration BDD fonctionne
- Penser à créer un fichier .env à la racine du projet contenant les infos nécessaires à application.properties