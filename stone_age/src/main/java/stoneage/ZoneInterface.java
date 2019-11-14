
package stoneage;

/**
 * Interface du concept de "zone"
 */
public interface ZoneInterface {

    int getNbOuvrierSurZone();
    void setNbOuvrierSurZone(int nbOuvrierSurZone);
    void placeOuvrier(int nbOuvrierAplacer);
    void retirerOuvrier(int nbOuvrierRetirer);
<<<<<<< HEAD
    void diminuerRessource();
<<<<<<< HEAD
    void gainZone(Joueur j);
=======
    default void gainZone(Joueur j){ }
>>>>>>> origin/Elarays
=======
    void gainZone(Joueur j);
>>>>>>> Baroudi

}


