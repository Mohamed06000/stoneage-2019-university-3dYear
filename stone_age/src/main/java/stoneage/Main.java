package stoneage;

/**
 * Classe du lancement du jeu
 */
public class Main {
    
    public static final void main(String[] args) {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        ZoneRessource zoneR = new ZoneRessource();
        ZoneInterface zoneV = new ZoneVillage();
        Joueur [] listJoueur = {j1,j2};
        int tour = 1;


        System.out.println("Nb de joueur : " + Joueur.getNbJoueur());
        

        while(zoneR.getNbRessourceZone()>0) {
        	System.out.println("Tour :" + tour);
        	System.out.println("_____PHASE DE PLACEMENT_____");
            for (int i=0; i < Joueur.getNbJoueur(); i++){
                phasePlacement(listJoueur[i], zoneR);
            }

            System.out.println("_____PHASE DE RECUPERATION_____");
            for (int i=0; i < Joueur.getNbJoueur(); i++){
                phaseRecuperation(listJoueur[i], zoneR);

            }
            System.out.println("_____PHASE NOURRIR____");
            for (int i = 0; i < Joueur.getNbJoueur(); i++) {
                phaseNourrir(listJoueur[i]);
            }
            tour++;
        }


        System.out.println("_____RESULTAT_____");
        if (j1.getInventaireJoueur().getNbRessource() == j2.getInventaireJoueur().getNbRessource()) {
            System.out.println("Egalité !");
        } else if (j1.getInventaireJoueur().getNbRessource() > j2.getInventaireJoueur().getNbRessource()) {
            System.out.println("Le joueur 1 gagne !");
        } else {
            System.out.println("Le joueur 2 gagne !");
        }
    }


    /**
     * Lancement de la phase de jeu de placement
     *
     * @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
    public static void phasePlacement(Joueur j, ZoneInterface z) {
        j.placement(z);
        System.out.println("Joueur " + j.getNum() + " :");
        System.out.println("Nb d'ouvrier dans la zone : " + z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbRessource());
    }

    /**
     * Lancement de la phase de jeu de recuperation
     *  @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
    public static void phaseRecuperation(Joueur j, ZoneRessource z) {
        System.out.println("Joueur " + j.getNum() + " :");
        j.action() ;
        j.recupere(z);
        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
        System.out.println("Nb de ressource dans la zone : "+ z.getNbRessourceZone());

        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbRessource());
    }
    


    /**
     * Lancement de la phase de jeu "nourrir"
     *
     * @param j L'objet de la classe Joueur
     */
    public static void phaseNourrir(Joueur j) {
        j.nourrir(j.getInventaireJoueur());
        System.out.println(" Quantitée de nouriture pour le joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbNourriture());

    }
}
