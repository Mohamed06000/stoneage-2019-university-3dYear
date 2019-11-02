package stoneage;

public class Zone {

    private int nbOuvrierSurZone = 0;

    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
    }

    public void setNbOuvrierSurZone(int nbOuvrierSurZone) {
        this.nbOuvrierSurZone = nbOuvrierSurZone;
    }

    public void placeOuvrier(int nbOuvrierAplacer){
        nbOuvrierSurZone += nbOuvrierAplacer;
    }

    public void retirerOuvrier(int nbOuvrierRetirer) { nbOuvrierSurZone -= nbOuvrierRetirer; }

    public void recuperation(Inventaire inventaireJoueur){
        inventaireJoueur.setNbRessource(inventaireJoueur.getNbRessource() + 1);

    }
}
