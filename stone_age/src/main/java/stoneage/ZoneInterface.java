package stoneage;

/**
 * Interface du concept de "zone"
 */
public interface ZoneInterface {

    int getNbOuvrierSurZone();
    void setNbOuvrierSurZone(int nbOuvrierSurZone);
    void placeOuvrier(int nbOuvrierAplacer);
    void retirerOuvrier(int nbOuvrierRetirer);
    void gainZone(Joueur j);

}
