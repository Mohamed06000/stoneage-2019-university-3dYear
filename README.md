# projetinfo-2019-stoneage-sak
projetinfo-2019-stoneage-sak created by GitHub Classroom
PROJET :

Iteration 1 : 

    Initialisation des données et création de deux joueurs .
    1 seul ouvrier par joueur.
    Création d'une seule zone. (Qui nous donne une "ressource")
    un Compteur de point par joueur
    1 ressource = 1 point
    1 Seul Tour, le joueur gagnant est celui qui possède un max de point (ie un max de ressource)
    1 tour = 2 phase uniquement : Placement, Récupération (des ressources).
   
Le jeu s'arrête au bout d'un tour. Le gagnant est celui qui a le plus de ressources.


Iteration2 : 

   On ajoute la nourriture dans la réserve des joueurs, un multiplicateur d'obtention de nourriture.
		
   On distingue 2 zones : 
       - 1 zone ressource fait gagner une "ressource", 
       - 1 zone village fait gagner un ouvrier,

   On ajoute la Phase Nourrir dans le tour, 1 Nourriture par ouvrier
		
   Le jeu s'arrête quand il n'y a plus de ressource. Le gagnant est celui qui a le plus de ressources.

Iteration 3 :

  Spécifications des Zones : 
      - Chasse; fait gagner X Nourriture,
      - Fôret -----> X bois
      - Champ ----> incrémente le multiplicateur de nourriture
    
  X est donnée par le(s) lancé de dé et les formule données par les règles du jeu.

  Mise à jour du contenu de la réserve (par l'ajout des différentes ressources)

  Le jeu s'arrête dès qu'un joueur arrive à au moins 30 points à la fin d'un tour.
  Gagnant ---> max de points

  Mise en place d'une IA Basique.




Iteration4 : 

	Ajout des zones Glacière et Hutte (+ leur règle de placements)
	Ajout de Carte, uniquement les civilisations (10 même carte, +3 pts au compteur / 2 nbr nourriture)
	Mise à jour du système de comptage des points, élements de la réserve du joueur.
	Le jeu s'arrête quand il n'y a plus de carte ou un joueur dépasse 30 pts



Iteration5 : 

	Ajout des zones Carrière, rivière, champs (+ leur règle de placements)
	Augmentation du nbre d'ouvrier à l'initialisation.
	Possibilité d'ajouter des joueurs, Maximum 4.
	Spécifications des cartes Civilisations (bon nbr de carte) (Haut de carte : Différents bonus; Bas de carte : différents multiplicateur (selon les règles) )
	Mise à jour du système de comptage des points
	Le jeu s'arrête quand il n'y a plus de carte ou un joueur dépasse 30 pts


Iteration6 : 

	Ajout de la zone Fabrique d'outils (+ règles de placements)
	Ajout du 2ème type de carte, carte Batiment (10 fois la même)
	Amélioration de l'IA
	Mise à jour du système de comptage des points, des inventaires à l'initialisations.
	Le jeu s'arrête quand il n'y a plus de carte Civilisations (le tour s'arrête) ou Batiments


Iteration7 :


	Spécifications des cartes Civilisations et Batiments (bon nbr de carte selon les règles, au moins 10 cartes différentes de chaques)
	Améliorations de l'IA.
	Mise à jour du système de comptage des points
	Simulation sur 10 partri
	Le jeu s'arrête quand il n'y a plus de carte Civilisations (le tour s'arrête) ou Batiments

Iteration 8 : 


	Compléter les cartes.
	Simulations 500 partie
	Traitement Statistiques
	



