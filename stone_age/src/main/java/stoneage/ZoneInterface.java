package stoneage;

/**
 * Interface du concept de "zone"
 */
public interface ZoneInterface {

    public int getNbOuvrierSurZone();
    public void setNbOuvrierSurZone(int nbOuvrierSurZone);
    public void placeOuvrier(int nbOuvrierAplacer);
    public void retirerOuvrier(int nbOuvrierRetirer);

}
