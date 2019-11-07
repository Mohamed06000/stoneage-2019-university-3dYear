package stoneage;

/**
 * Classe du lancement du jeu
 */
public class Main {

    private final Inventaire inventaireJoueur;
    private final Joueur joueur;


    public static final void main(String[] args) {
        Main j1 = new Main();
        Main j2 = new Main();
        Zone zone = new Zone();
<<<<<<< HEAD
        Main listJoueur[] = {j1,j2};
        int tour = 1;
=======
        Main listJoueur[] = {j1, j2};
>>>>>>> a4a31b3d5474cc4212f69bcf89341d32ec59b409

        System.out.println("Nb de joueur : " + Joueur.getNbJoueur());
        

<<<<<<< HEAD
        while(zone.getNbRessourceZone()>0) {
        	System.out.println("Tour :" + tour);
        	System.out.println("_____PHASE DE PLACEMENT_____");
            for (int i=0; i < Joueur.getNbJoueur(); i++){
                listJoueur[i].phasePlacement(listJoueur[i].joueur, zone);
            }

            System.out.println("_____PHASE DE RECUPERATION_____");
            for (int i=0; i < Joueur.getNbJoueur(); i++){
                listJoueur[i].phaseRecuperation(listJoueur[i].joueur, zone);
            }
            tour++;
=======
        System.out.println("_____PHASE DE PLACEMENT_____");
        for (int i = 0; i < Joueur.getNbJoueur(); i++) {
            listJoueur[i].phasePlacement(listJoueur[i].joueur, zone);
        }

        System.out.println("_____PHASE DE RECUPERATION_____");
        for (int i = 0; i < Joueur.getNbJoueur(); i++) {
            listJoueur[i].phaseRecuperation(listJoueur[i].joueur, zone);
>>>>>>> a4a31b3d5474cc4212f69bcf89341d32ec59b409
        }
        
        

        System.out.println("_____PHASE NOURRIR____");
        for (int i = 0; i < Joueur.getNbJoueur(); i++) {
            listJoueur[i].phaseNourrir(listJoueur[i].joueur);
        }

        System.out.println("_____RESULTAT_____");
        if (j1.inventaireJoueur.getNbRessource() == j2.inventaireJoueur.getNbRessource()) {
            System.out.println("Egalité !");
        } else if (j1.inventaireJoueur.getNbRessource() > j2.inventaireJoueur.getNbRessource()) {
            System.out.println("Le joueur 1 gagne !");
        } else {
            System.out.println("Le joueur 2 gagne !");
        }
    }

    /**
     * Creation d'un joueur possedant des inforamtions, des actions et un inventaire
     */
    public Main() {
        joueur = new Joueur();
        inventaireJoueur = new Inventaire();
    }

    /**
     * Lancement de la phase de jeu de placement
     *
     * @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
    public void phasePlacement(Joueur j, Zone z) {
        j.placement(inventaireJoueur, z);
        System.out.println("Joueur " + j.getNum() + " :");
<<<<<<< HEAD
        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
        System.out.println("Nb de ressource dans la zone : "+ z.getNbRessourceZone());
=======
        System.out.println("Nb d'ouvrier dans la zone : " + z.getNbOuvrierSurZone());
>>>>>>> a4a31b3d5474cc4212f69bcf89341d32ec59b409
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + inventaireJoueur.getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + inventaireJoueur.getNbRessource());
    }

    /**
     * Lancement de la phase de jeu de recuperation
     *
     * @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
    public void phaseRecuperation(Joueur j, Zone z) {
        System.out.println("Joueur " + j.getNum() + " :");
<<<<<<< HEAD
        j.action() ;
        j.recupere(inventaireJoueur,z);
        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
        System.out.println("Nb de ressource dans la zone : "+ z.getNbRessourceZone());
=======
        j.action();
        j.recupere(inventaireJoueur, z);
        System.out.println("Nb d'ouvrier dans la zone : " + z.getNbOuvrierSurZone());
>>>>>>> a4a31b3d5474cc4212f69bcf89341d32ec59b409
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + inventaireJoueur.getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + inventaireJoueur.getNbRessource());
    }
    
    
   //public void VerifRessources ()

    /**
     * Lancement de la phase de jeu "nourrir"
     *
     * @param j L'objet de la classe Joueur
     */
    public void phaseNourrir(Joueur j) {
        j.nourrir(inventaireJoueur);
        System.out.println(" Quantitée de nouriture pour le joueur " + j.getNum() + " : " + inventaireJoueur.getNbNourriture());

    }
}