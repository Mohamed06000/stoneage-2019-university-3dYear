package stoneage;


public class Main {

    private final Inventaire inventaireJoueur;
    private final Joueur joueur;

    public static final void main(String[] args) {
        Main j1 = new Main();
        Main j2 = new Main();
        Zone zone = new Zone();
        Main listJoueur[] = {j1,j2};

        System.out.println("Nb de joueur : " + Joueur.getNbJoueur());

        System.out.println("_____PHASE DE PLACEMENT_____");
        for (int i=0; i < Joueur.getNbJoueur(); i++){
            listJoueur[i].phasePlacement(listJoueur[i].joueur, zone);
        }

        System.out.println("_____PHASE DE RECUPERATION_____");
        for (int i=0; i < Joueur.getNbJoueur(); i++){
            listJoueur[i].phaseRecuperation(listJoueur[i].joueur, zone);
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

    public Main(){
        joueur = new Joueur();
        inventaireJoueur = new Inventaire();
    }

    public void phasePlacement(Joueur j, Zone z){
        j.placement(inventaireJoueur, z);
        System.out.println("Joueur " + j.getNom() + " :");
        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNom() + " : " + inventaireJoueur.getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNom() + " : " + inventaireJoueur.getNbRessource());
    }

    public void phaseRecuperation(Joueur j, Zone z){
        j.recupere(inventaireJoueur,z);
        System.out.println("Joueur " + j.getNom() + " :");
        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNom() + " : " + inventaireJoueur.getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNom() + " : " + inventaireJoueur.getNbRessource());
    }

}
