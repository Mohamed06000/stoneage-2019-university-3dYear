<<<<<<< HEAD

package stoneage;

/**
 * Classe Ressource generalisee de "zone"
 */
public class ZoneRessource implements ZoneInterface {

    /**
     * Le nombre d'ouvrier present sur la zone
     */
    private int nbOuvrierSurZone = 0;
    /**
     * Le nombre de ressource de la zone
     */
    private int nbRessourcesZone = 10 ;

    /**
     * Recupérer le  nombre d'ouvrier sur la zone
     *
     * @return
     */
    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
    }

    /**
     * Recuperer le nombre de ressource de la zone
     * @return Le nombre de ressource
     */
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

    /**
     * Diminuer les ressources de la zone
     */
    public void diminuerRessource() {
        if (nbRessourcesZone>0)
            nbRessourcesZone--;
    }

    @Override
    public void gainZone(Joueur j) {

    }


}

=======
package stoneage;

/**
 * Classe Ressource generalisee de "zone"
 */
public class ZoneRessource implements ZoneInterface {

    /**
     * Le nombre d'ouvrier present sur la zone
     */
    private int nbOuvrierSurZone = 0;
    /**
     * Le nombre de ressource de la zone
     */
    private int nbRessourcesZone = 10 ;
<<<<<<< HEAD

    /**
     * Recup�rer le  nombre d'ouvrier sur la zone
=======
    private int nbOuvrierDuJoueurI[] = new int[Joueur.getNbJoueur()];

    @Override
    public int getNbOuvrierDuJoueurI(int i) {
        return nbOuvrierDuJoueurI[i-1];
    }

    /**
     * Recupérer le  nombre d'ouvrier sur la zone
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71
     *
     * @return
     */
    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
    }

    /**
     * Recuperer le nombre de ressource de la zone
     * @return Le nombre de ressource
     */
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
<<<<<<< HEAD
    public void placeOuvrier(int nbOuvrierAplacer) {
        nbOuvrierSurZone += nbOuvrierAplacer;
    }

    /**
     * retirer un nombre d'ouvrier de la  zone
     *
     * @param nbOuvrierRetirer
     */
    public void retirerOuvrier(int nbOuvrierRetirer) {
        nbOuvrierSurZone -= nbOuvrierRetirer;
    }

    /**
     * Diminuer les ressources de la zone
     */
    public void diminuerRessource() {
        if (nbRessourcesZone>0)
            nbRessourcesZone--;
=======
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

    /**
     * Diminuer les ressources de la zone et donne une ressource
     */
    public void gainZone(Joueur j) {
        if (this.nbRessourcesZone>0)
            this.nbRessourcesZone--;
        j.getInventaireJoueur().setNbRessource(j.getInventaireJoueur().getNbRessource()+1);
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71
    }



}
<<<<<<< HEAD
>>>>>>> Louay
=======
>>>>>>> Baroudi
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71
