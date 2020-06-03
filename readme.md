Cette application à pour but de controler des lampes à l'aide d'une application WEB.
Ces lampes se présente sous la forme d'un chenillard qui allume et eteint les lampes alternement.
Nous avons utilisé la librairie KNX sur JAVA pour gérer la connection avec les lampes et REACT pour l'interface WEB.
Le serveur est un serveur REST qui fonctionne sous JAVA.

Pour lancer l'application, il faut tout d'abord lancer le server, pour cela il faut executer le fichier MinimalServerRest qui est dans src/main/java/server/MinimalServerRest.java

Ensuite il faut lancer le client en allant dans le dossier src/main/client et lancer la commande npm start.
La page va s'ouvrir automatiquement dans le navigateur.


Dans le dossier client, vous allez retrouver tout le code REACT de l'interface web. Pour rajouter des élements à l'interface, il faut aller dans le fichier src/App.js

Dans le dossier java/server vous allez retrouver tout ce qui concerne le server REST.
Pour rajouter des requêtes, il suffit d'aller dans le dossier rest et de rajouter les requêtes nécessaires.
Si vous voulez également rajouter des élements au chenillard, vous devez les mettres dans dto/ChenillardJson.java


Pour acceder à la partie KNX, il faut aller dans le dossier src/main/java/fr/esir/projet. 
Dans le fichier knx, vous pouvez rajouter des actions lors d'un clique d'un bouton de la maquette.
Si vous souhaiter modifier des fonctionnalités du chenillard ou en rajouter, il faut aller dans le fichier Chenillard.java.

