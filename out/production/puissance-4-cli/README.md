# Puissance 4 en CLI

Ce projet consiste à créer une version en ligne de commande du jeu Puissance 4 en Java.

Vous devez créer un nouveau package appelé puissance4 pour ce projet.

## Instructions

Vous devez créer un programme Puissance 4 qui permettra à deux joueurs de s'affronter au jeu Puissance 4.

Le jeu se joue sur une grille de 6 lignes et 7 colonnes. Chaque joueur possède un jeton de couleur différente : l'un joue avec les jetons rouges et l'autre avec les jetons jaunes.

Voici les spécifications du programme :

- Afficher le plateau de jeu initial, représenté par des espaces vides (par exemple, des tirets) pour chaque case.
- Demander tour à tour aux joueurs de choisir la colonne dans laquelle ils veulent placer leur jeton.
- Vérifier si la colonne choisie est valide (c'est-à-dire qu'elle n'est pas déjà pleine). Si la colonne est invalide, demander au joueur de choisir une autre colonne.
- Placer le jeton du joueur dans la colonne choisie, en le faisant tomber jusqu'à la position disponible la plus basse.
- Vérifier si le joueur a gagné en alignant 4 jetons horizontalement, verticalement ou en diagonale. Si c'est le cas, afficher un message de victoire et terminer le jeu.
- Si aucun joueur n'a gagné et que la grille est pleine, afficher un message de match nul et terminer le jeu.
- Sinon, passer au joueur suivant et répéter les étapes 2 à 6 jusqu'à ce qu'un joueur gagne ou que la grille soit pleine.

Le jeu devrait afficher le plateau de jeu après chaque coup joué, en utilisant des caractères spécifiques pour représenter les jetons de chaque joueur (par exemple, 'R' pour les jetons rouges et 'Y' pour les jetons jaunes).

## Exemple d'utilisation

```
Bienvenue dans le jeu Puissance 4 !

- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
1 2 3 4 5 6 7

Joueur 1 (rouge), choisissez une colonne : 4

- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
- - - R - - -
1 2 3 4 5 6 7

Joueur 2 (jaune), choisissez une colonne : 3

- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
- - Y R - - -
1 2 3 4 5 6 7

Joueur 1 (rouge), choisissez une colonne : 4

- - - - - - -
- - - - - - -
- - - - - - -
- - - - - - -
- - - R - - -
- - Y R - - -
1 2 3 4 5 6 7

...

Joueur 2 (jaune), choisissez une colonne : 2

- - - - - - -
- - - - - - -
- - - - - - -
- - R Y - - -
- Y Y R - - -
- Y Y R R R -
1 2 3 4 5 6 7

Joueur 1 (rouge), choisissez une colonne : 7

- - - - - - -
- - - - - - -
- - - - - - -
- - R Y - - -
- Y Y R - - -
- Y Y R R R R
1 2 3 4 5 6 7

Joueur 1 (rouge) a gagné ! Félicitations !

```