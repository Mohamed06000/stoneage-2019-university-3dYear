
package stoneage;

/**
 * Classe generalisee Village de "zone"
 */
public class  ZoneVillage implements ZoneInterface {


    /**
     * Le nombre d'ouvrier present sur la zone
     */
<<<<<<< HEAD
    private int nbOuvrierSurZone ;

    public ZoneVillage(){
        this.nbOuvrierSurZone=0;
    }
=======
    private int nbOuvrierSurZone = 0;
    private int nbOuvrierDuJoueurI[] = new int[Joueur.getNbJoueur()];
>>>>>>> origin/mazy

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

    public int getNbOuvrierDuJoueurI(int i) {
        return nbOuvrierDuJoueurI[i-1];
    }

    /**
     * Placer un nombre d'ouvrier sur la zone
     *
     * @param nbOuvrierAplacer
     * @param id
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


<<<<<<< HEAD
   public void diminuerRessource() {

    }

    @Override
    public void gainZone(Joueur j) {

    }


=======
    public void diminuerRessource() { }
>>>>>>> origin/Elarays
}
