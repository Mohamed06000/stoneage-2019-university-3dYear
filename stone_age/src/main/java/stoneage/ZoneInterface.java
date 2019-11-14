
package stoneage;

/**
 * Interface du concept de " zone"
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
    default void gainZone(Joueur j){ } ; 
=======
<<<<<<< HEAD
    void gainZone(Joueur j);
=======
    default void gainZone(Joueur j){ }
>>>>>>> origin/Elarays
=======
    void gainZone(Joueur j);
>>>>>>> Baroudi
>>>>>>> c843e56bb392d9038b1d127d54689e03ea917c71

}

