# aea_tp3
# Jean-Serge Monbailly
# Thibaud Verbaere

TP3 d'AeA, premier TP de la 2e partie du cours sur les graphes.


#Jeu de la lettre qui saute : 
sujet : http://www.lifl.fr/~derbel/ueAeA/partieII/LettreQuiSaute/

Fichiers présents :
===================
src/graphe
----------
+ Liste.java 		: permet de manipuler des listes d'entiers sous la forme d'un tableau
+ Graphe.java 		: classe centrale de l'exercice, représente le graphe sur lequel effectuer les calculs

src/tools
---------
+ ToolsString.java 	: classe contenant des fonctions statiques de manipulation de chaines de caractères
+ Dicos.java 		: classe contenant des dictionnaires de mots de taille 3, 4 et 5		

src/main 
--------
+ Main.java 		: classe permettant de vérifier le bon fonctionnement de la fonction lettreQuiSaute(). Cette classe répond également à la série de question du TP (ex. 1 à 4)


Travail Réalisé :
=================
+ Écriture d'un programme utilisant la fonction lettreQuiSaute(), permet de définir la liste des successeurs 
de chaque mot du dictionnaire utilisé.
+ Les exercices 1 à 4 ont été traités intégralement (cf Main).


Notes : 
=======

Liste.java 
----------
+ Cette classe manipule un tableau d'entiers
+ Ce tableau est initialisé en fonction d'une constante définie dans
la classe
+ Il est possible d'ajouter un élément dans ce tableau
+ Si le tableau est plein, il est automatiquement remplacé par un tableau
2 fois plus grand

Graphe.java 
----------
+ Permet d'initialiser un graphe grâce au dictionnaire de mots (lettreQuiSaute)
+ Propose un parcours en largeur depuis un sommet de départ (DFS)
+ Propose un parcours en profondeur depuis un sommet de départ (BFSIteratif)
+ Propose une méthode visitant et affichant tout le graphe (visit)
+ Propose une méthode calculant le chemin entre deux mots (chemin)



