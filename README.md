# Projet_Pigeon

Projet réalisé dans le cadre du cours de Programmation Orientée Objet en maîtrise d'informatique à l'UQAC.

Réalisé par Alix Dufour et Théo Bouguet à la session d'automne 2022

## Sujet 

Pour ce travail, on donnera à manger aux Pigeons !! Le but est d’implémenter une simulation d’alimentation de pigeon dans un espace public. Le jeu se passe dans une fenêtre où les pigeons attendent la nourriture. L’utilisateur, alors, leur donne à manger en cliquant sur un emplacement dans la fenêtre.

Les pigeons suivent les règles suivantes :
- Chaque pigeon est contrôlé par un thread
- Si rien ne se passe, les pigeons s’endorment et ne bougent pas
- En apercevant de la nourriture, un pigeon se déplace vers la nourriture la plus fraiche.
- Une nourriture fraiche touchée est mangée, donc elle doit disparaitre immédiatement de la scène.
- Nos pigeons sont gâtés ; un pigeon qui touche une nourriture pas fraiche, il l’ignore.
- Même en l’absence de la nourriture, des fois les pigeons se font effrayer et ils se dispersent à des positions aléatoires. Intégrer ce mécanisme dont la probabilité d’occurrence change d’un tour à l’autre.

Les pigeons et la nourriture doivent être représentés graphiquement. Un simple cercle ou un objet 3D, c’est à vous de choisir. Le plus important est le multithreading et la structure des classes. En ce qui Concerne le multithreading, vous serez amené à :
- S’assurer que les pigeons arrêtent de bouger le moment où il ne reste plus de nourriture.
- Aussi, s’assurer si plus qu’un pigeon touche la nourriture simultanément, uniquement un seul pourra la supprimer.
- Prendre en compte la nourriture dans le processus de dessin. Puisque les threads ne sont pas synchronisés, ceci permet d’ajouter de la nourriture même au moment du dessin de la scène. Il sera commode de parcourir une structure de nourriture et de faire un verrou pendant le processus de dessin.

Livrables :
- Votre travail (code, readme et pdf/word) en un fichier .zip
- Le fichier README qui contient vos noms (groupe) et les instructions pour jouer à votre jeu.
- Document word/pdf décrivant les différentes parties pour répondre à cette question.
- Notons que la gestion d’exceptions et de multithreading va être considérée dans cette question.

## Instructions 

Pour lancer l'exécutable, il faut utiliser un invite de commande et lancer la commande suivante dans la racine du projet :

```
  java -jar Pigeons.jar
```

Une fenêtre s'affiche ensuite. Les pigeons sont au nombre de 3 et sont représentés par des rectangles de couleurs aléatoires. Au départ, il n'y a pas de nourriture, les pigeons reste donc immobiles (tant qu'ils ne se font pas effrayés). 

Pour ajouter de la nourriture, il suffit de cliquer à l'endroit de la fenêtre ou l'on souhaite en ajouter. La fraicheur de la nourriture est indiqué par sa couleur et évolue au fil du temps. Une nourriture qui n'est plus frâiche est en noir et ne sera pas mangée. 

Les pigeons se dirigent vers la nourriture la plus frâiche.

A n'importe quel moment, les pigeons peuvent être effrayés et s'enfuiront. Dans ce cas, leur couleur sera rouge.
