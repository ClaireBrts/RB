Cette application a pour but de contrôler des lampes à l'aide d'une interface WEB.

Ces lampes se présentent sous la forme d'une interface KNX virtuelle. L'ensemble des lampes constitue un chenillard qui allume et eteint les lampes alternativement.

Nous avons donc utilisé la librairie KNX sur JAVA pour gérer la connection avec les lampes et REACT pour l'interface WEB.
Le serveur est un serveur REST qui fonctionne sous JAVA.

Pour lancer l'application, il faut tout d'abord lancer le server, pour cela il faut executer le fichier MinimalServerRest qui se situe dans src/main/java/server/MinimalServerRest.java. 

Ensuite il faut lancer le client en allant dans le dossier src/main/client et lancer la commande npm start.
La page va s'ouvrir automatiquement dans le navigateur.


Dans le dossier client, vous allez retrouver tout le code REACT de l'interface web. Pour rajouter des élements à l'interface, il faut aller dans le fichier src/App.js. Il est donc envisageable d'ajouter plus de fonctionnalités, d'autres boutons par exemple. 

Dans le dossier java/server vous allez retrouver tout ce qui concerne le server REST.
Pour ajouter des requêtes, il suffit d'aller dans le dossier java/server/rest. Au sein du fichier, il existe à la fois des requêtes POST et GET. 
Si vous voulez également rajouter des élements au chenillard, vous devez les mettres dans dto/ChenillardJson.java. 


Pour acceder à la partie KNX, il faut aller dans le dossier src/main/java/fr/esir/projet. 
Dans le fichier KNX, vous pouvez rajouter des actions lors d'un clic sur un bouton de la maquette.
Si vous souhaiter modifier des fonctionnalités du chenillard ou en rajouter, il faut aller dans le fichier Chenillard.java.

En résumé, si vous souhaitez ajouter des fonctionnalités au chenillard, il faut dans un premier temps compléter le document Chenillard.java, puis dans le fichier KNX. Ensuite dans le package server, il faut également completer le fichier ChenillardJson. Et pour terminer, il faut ajouter votre requête dans le fichier ChenillardSvc. 

