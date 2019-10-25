package stoneage;


public class Main {

    private final Inventaire inventaireJoueur;
    private final Joueur joueur;
    private final Zone zone;


    public static final void main(String[] args) {
        Main j1 = new Main();
        Main j2 = new Main();

        System.out.println("Joueur 1 :");
        j1.play();
        System.out.println("Joueur 2 :");
        j2.play();

        System.out.println("_____RESULTAT_____");

       if (j1.inventaireJoueur.getNbRessource() == j2.inventaireJoueur.getNbRessource()) {
           System.out.println("Egalité !");
        } else if (j1.inventaireJoueur.getNbRessource() > j2.inventaireJoueur.getNbRessource()){
           System.out.println("Le joueur 1 gagne !");
        }else {
           System.out.println("Le joueur 2 gagne !");
        }
        int maxRessource = Math.max(j1.inventaireJoueur.getNbRessource(),j2.inventaireJoueur.getNbRessource());
    }

    public Main(){
        joueur = new Joueur();
        inventaireJoueur = new Inventaire();
        zone = new Zone();
    }

    protected void play(){
        System.out.println("_____PHASE DE PLACEMENT_____");
        phasePlacement(joueur, zone);
        System.out.println("_____PHASE DE RECUPERATION_____");
        phaseRecuperation(joueur, zone);
    }

    public void phasePlacement(Joueur j, Zone z){
        j.placement(inventaireJoueur);
        z.placeOuvrier(1);
        System.out.println("Nb d'ouvrier dans la zone "+ z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + inventaireJoueur.getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + inventaireJoueur.getNbRessource());
    }

    public void phaseRecuperation(Joueur j, Zone z){
        j.recupere(inventaireJoueur,zone);
        System.out.println("Nb d'ouvrier dans la zone "+ z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + inventaireJoueur.getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + inventaireJoueur.getNbRessource());
    }

}
