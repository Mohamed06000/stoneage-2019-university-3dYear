package stoneage;


public class Main {

    private final Inventaire inventaireJoueur;
    private final Joueur joueur;
    private final Zone zone;


    public static final void main(String[] args) {
        Main m = new Main();
        m.play();
    }

    public Main(){
        joueur = new Joueur();
        inventaireJoueur = new Inventaire();
        zone = new Zone();
    }

    protected void play(){
        System.out.println("Phase de placement des ouvriers");
        phasePlacement(joueur, zone);
        System.out.println("Phase de récupération des ouvriers");
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
        z.recuperation(inventaireJoueur);
        System.out.println("Nb d'ouvrier dans la zone "+ z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + inventaireJoueur.getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + inventaireJoueur.getNbRessource());
    }

}
