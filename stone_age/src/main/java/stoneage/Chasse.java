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
public class Chasse extends ZoneRessource implements ZoneInterface {
	
    private int nbNourritureSurZone = 10000 ;
    
    public  int resultat_De=0;
    

    public Chasse(){
        super();
    }

    // methode pour retourner le nombre  des nourritures dans la zone chasse 
   public int getNbRessourceZone() {
        return nbNourritureSurZone;
    }

   
    // dimminuer les nourriture pour chaque tour
    public void diminuerRessource() {
    	if (nbNourritureSurZone-(resultat_De)>=0)   
    		nbNourritureSurZone-=resultat_De;
    }

    
    /**
     * methode gainZone qui incremente de n Nourritures (grace la lancement  de dé) pour le Joueur j ayant mis un ouvrier sur 
     * la zone chasse
     * @param j
     */
 public void  gainZone(Joueur j) {
	 
	  resultat_De = de() / 2  ;
	 
	    j.getInventaireJoueur().addNourriture(resultat_De);
	    }	 
	
    }
	  



