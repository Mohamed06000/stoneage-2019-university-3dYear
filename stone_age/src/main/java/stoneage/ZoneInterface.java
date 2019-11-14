
package stoneage;

/**
 * Interface du concept de "zone"
 */
public interface ZoneInterface {

    int getNbOuvrierDuJoueurI(int id);
    int getNbOuvrierSurZone();
    void setNbOuvrierSurZone(int nbOuvrierSurZone);
<<<<<<< HEAD
    void placeOuvrier(int nbOuvrierAplacer);
    void retirerOuvrier(int nbOuvrierRetirer);
<<<<<<< HEAD
=======
    void placeOuvrier(int nbOuvrierAplacer, int id);
    void retirerOuvrier(int nbOuvrierRetirer, int id);
>>>>>>> origin/mazy
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


