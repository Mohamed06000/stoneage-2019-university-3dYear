package stoneage;

/**
 * Classe generalise du concept de "zone" du jeu StoneAge
 */
public class Zone {

    /**
     * Le nombre d'ouvrier present sur la zone
     */
    private int nbOuvrierSurZone = 0;
    
    private int nbRessourcesZone = 10 ; 
    
    
    
    
    

    /**
     * Recupérer le  nombre d'ouvrier sur la zone
     *
     * @return
     */
    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
    }
    
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
<<<<<<< HEAD
    public void retirerOuvrier(int nbOuvrierRetirer) { nbOuvrierSurZone -= nbOuvrierRetirer; }
    
    public  void diminuerRessource()
    {
    	nbRessourcesZone --; 
    	
    }
    public void augmenterRessource()
    {
    	nbRessourcesZone ++; 
    	
    }
    
    
    
    
    
    
    
    
    
=======
    public void retirerOuvrier(int nbOuvrierRetirer) {
        nbOuvrierSurZone -= nbOuvrierRetirer;
    }
>>>>>>> a4a31b3d5474cc4212f69bcf89341d32ec59b409

}