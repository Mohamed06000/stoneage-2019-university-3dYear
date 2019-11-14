
package stoneage;

/**
 * Classe generalisee Village de "zone"
 */
public class  ZoneVillage implements ZoneInterface {

    /**
     * Le nombre d'ouvrier present sur la zone
     */
    private int nbOuvrierSurZone = 0;

    /**
     * Recupérer le  nombre d'ouvrier sur la zone
     *
     * @return
     */
    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
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
    public void placeOuvrier(int nbOuvrierAplacer) {
        nbOuvrierSurZone += nbOuvrierAplacer;
    }

    /**
     * retirer un nombre d'ouvrier de la zone
     *
     * @param nbOuvrierRetirer
     */
    public void retirerOuvrier(int nbOuvrierRetirer) {
        nbOuvrierSurZone -= nbOuvrierRetirer;
    }


   public void diminuerRessource() {

    }

    @Override
    public void gainZone(Joueur j) {

    }


}
