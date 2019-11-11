package stoneage;

/**
 * Interface du concept de "zone"
 */
public interface ZoneInterface {

    int getNbOuvrierDuJoueurI(int id);
    int getNbOuvrierSurZone();
    void setNbOuvrierSurZone(int nbOuvrierSurZone);
    void placeOuvrier(int nbOuvrierAplacer, int id);
    void retirerOuvrier(int nbOuvrierRetirer, int id);
    void diminuerRessource();

}
