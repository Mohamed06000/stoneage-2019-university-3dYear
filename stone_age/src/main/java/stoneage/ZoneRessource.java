package stoneage;

/**
 * Classe Ressource generalisee de "zone"
 */
public class ZoneRessource implements ZoneInterface {

    /**
     * Le nombre d'ouvrier present sur la zone
     */
    private int nbOuvrierSurZone = 0;
    private int nbRessourcesZone = 10 ;
    private int nbOuvrierDuJoueurI[] = new int[Joueur.getNbJoueur()];

    @Override
    public int getNbOuvrierDuJoueurI(int i) {
        return nbOuvrierDuJoueurI[i-1];
    }

    /**
     * Recupérer le  nombre d'ouvrier sur la zone
     *
     * @return
     */
    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
    }

    public int getNbRessourceZone() {
        return nbRessourcesZone;
    }


    /**
     * Assigner un nombre d'ouvier sur la zone
     *
     * @param nbOuvrierSurZone
     */
    public void setNbOuvrierSurZone(int nbOuvrierSurZone) {
        this.nbOuvrierSurZone = nbOuvrierSurZone;
    }

    /**
     * Placer un nombre d'ouvrier sur la zone
     *
     * @param nbOuvrierAplacer
     */
    public void placeOuvrier(int nbOuvrierAplacer, int id) {
        nbOuvrierSurZone += nbOuvrierAplacer;
        nbOuvrierDuJoueurI[id-1] = nbOuvrierAplacer;
    }

    /**
     * retirer un nombre d'ouvrier de la zone
     *
     * @param nbOuvrierRetirer
     */
    public void retirerOuvrier(int nbOuvrierRetirer, int id) {
        nbOuvrierSurZone -= nbOuvrierRetirer;
        nbOuvrierDuJoueurI[id-1] -= nbOuvrierRetirer;
    }

    public int[] getNbOuvrierDuJoueurI() {
        return nbOuvrierDuJoueurI;
    }

    public  void diminuerRessource() {
        if (nbRessourcesZone>0)
            nbRessourcesZone--;
    }



}
