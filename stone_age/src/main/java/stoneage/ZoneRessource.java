package stoneage;

/**
 * Classe Ressource generalisee de "zone"
 */
import java.util.Random ;

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
    
    public int de(){
        Random rand = new Random();
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }



}
