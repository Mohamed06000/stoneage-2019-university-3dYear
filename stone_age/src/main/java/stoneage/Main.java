
package stoneage;

/**
 * Classe du lancement du jeu
 */
public class Main {
    
    public static final void main(String[] args) {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        ZoneRessource zoneR = new ZoneRessource();
<<<<<<< HEAD
        ZoneVillage zoneV = new ZoneVillage();
<<<<<<< HEAD
        ZoneForet zonF = new ZoneForet();
=======
        Champ champ = new Champ();
>>>>>>> origin/Elarays
        Joueur listJoueur[] = {j1,j2};
=======
        ZoneInterface zoneV = new ZoneHutte();
        Joueur [] listJoueur = {j1,j2};
>>>>>>> Baroudi
        int tour = 1;

        System.out.println("Nb de joueur : " + Joueur.getNbJoueur());
        
<<<<<<< HEAD

        while(tour<5) {
        	System.out.println("Tour :" + tour);
        	System.out.println("_____PHASE DE PLACEMENT_____");
            for (int i=0; i < Joueur.getNbJoueur(); i++){
                phasePlacement(listJoueur[i], zonF);
=======
        while(zoneR.getNbRessourceZone()>0)
            {
        	System.out.println("Tour :" + tour);
        	System.out.println("_____PHASE DE PLACEMENT_____");
            for (int i=0; i < Joueur.getNbJoueur(); i++){
                phasePlacement(listJoueur[i], champ);
>>>>>>> origin/Elarays
            }

            System.out.println("_____PHASE DE RECUPERATION_____");
            for (int i=0; i < Joueur.getNbJoueur(); i++){
<<<<<<< HEAD
                phaseRecuperation(listJoueur[i], zonF);
=======
                phaseRecuperation(listJoueur[i], champ);
>>>>>>> origin/Elarays

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
        System.out.println("Nb bois : : " + j.getInventaireJoueur().getNbRessourceBois());
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbRessource());
        System.out.println("le niveau d'agriculture pour le "+ j.getNum()+ " : "+j.getInventaireJoueur().getNiveauAgriculture() );

    }

    /**
     * Lancement de la phase de jeu de recuperation
     *  @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
    public static void phaseRecuperation(Joueur j, ZoneInterface z) {
        System.out.println("Joueur " + j.getNum() + " :");
        j.action() ;
<<<<<<< HEAD
        z.gainZone(j);
        j.recupere(j.getInventaireJoueur(),z);
        z.gainZone(j);
        System.out.println("Nb bois : : " + j.getInventaireJoueur().getNbRessourceBois());
=======
        j.recupere(z);
>>>>>>> Baroudi
        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
        //System.out.println("Nb de ressource dans la zone : "+ z.getNbRessourceZone());

        System.out.println("le le niveau d'agriculture pour le "+ j.getNum()+ " : "+j.getInventaireJoueur().getNiveauAgriculture() );
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

