package stoneage;

import java.util.Random;

/**
 * Classe qui represente la Zone chasse  qui permet de gagner la nourriture pendant chaque phase de recuperation
 * cette classe herite de la classe ressources zone donc elle herite  :
 * 
 * la variable : nbOuvrierSurZone
 * la methode : getNbOuvrierSurZone()
 * la methode : setNbOuvrierSurZone()
 * la methode : placeOuvrier()
 * la methode : retirerOuvrier()
 * et on redéfinit les restes :
 */
public class ZoneChasse extends ZoneRessource implements ZoneInterface {


    private static int nbOuvrierSurZone = 0;
    private int nbOuvrierDuJoueurI[] = new int[Joueur.getNbJoueur()];

    private int nbNourritureSurZone = 10000 ;
    public  int resultat_De=0;

    // methode pour retourner le nombre  des nourritures dans la zone chasse 
   public int getNbRessourceZone() {
        return nbNourritureSurZone;
    }

    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
    }

    public int getNbOuvrierDuJoueurI(int i) {
        return nbOuvrierDuJoueurI[i-1];
    }

   
    // dimminuer les nourriture pour chaque tour
    public void diminuerRessource() {
    	if (nbNourritureSurZone-(resultat_De)>=0)   
    		nbNourritureSurZone-=resultat_De;
    }

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

    
    /**
     * methode gainZone qui incremente de n Nourritures (grace la lancement  de d�) pour le Joueur j ayant mis un ouvrier sur 
     * la zone chasse
     * @param j
     */
 public void  gainZone(Joueur j) {
	 
	  resultat_De = j.de() / 2  ;
	 
	    j.getInventaireJoueur().addNourriture(resultat_De);
	    }	 
	
    }
	  



