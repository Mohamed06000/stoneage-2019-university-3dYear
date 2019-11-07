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
        Main listJoueur[] = {j1,j2};
        int tour = 1;

        System.out.println("Nb de joueur : " + Joueur.getNbJoueur());
        

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
        }
        
        

        System.out.println("_____RESULTAT_____");
       if (j1.inventaireJoueur.getNbRessource() == j2.inventaireJoueur.getNbRessource()) {
           System.out.println("Egalité !");
        } else if (j1.inventaireJoueur.getNbRessource() > j2.inventaireJoueur.getNbRessource()){
           System.out.println("Le joueur 1 gagne !");
        }else {
           System.out.println("Le joueur 2 gagne !");
        }
    }

    /**
     * Creation d'un joueur possedant des inforamtions, des actions et un inventaire
     */
    public Main(){
        joueur = new Joueur();
        inventaireJoueur = new Inventaire();
    }

    /**
     * Lancement de la phase de jeu de placement
     * @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
    public void phasePlacement(Joueur j, Zone z){
        j.placement(inventaireJoueur, z);
        System.out.println("Joueur " + j.getNum() + " :");
        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
        System.out.println("Nb de ressource dans la zone : "+ z.getNbRessourceZone());
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + inventaireJoueur.getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + inventaireJoueur.getNbRessource());
    }

    /**
     * Lancement de la phase de jeu de recuperation
     * @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
    public void phaseRecuperation(Joueur j, Zone z){
        System.out.println("Joueur " + j.getNum() + " :");
        j.action() ;
        j.recupere(inventaireJoueur,z);
        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
        System.out.println("Nb de ressource dans la zone : "+ z.getNbRessourceZone());
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + inventaireJoueur.getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + inventaireJoueur.getNbRessource());
    }
    
    
   //public void VerifRessources ()

}
