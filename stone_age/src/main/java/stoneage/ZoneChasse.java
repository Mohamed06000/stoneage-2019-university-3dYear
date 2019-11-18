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

    /**
     * La liste du nombre d'ouvrier qu'un joueur ait placé sur la zone
     */
    public int nbOuvrierDuJoueurI[] = new int[Joueur.getNbJoueur()];

    /**
     * le nombre de nourriture sur zone
     */
    private int nbNourritureSurZone = 12 ;
    public  int resultat_De=0;

    /**
     *  methode pour retourner le nombre  des nourritures dans la zone chasse
     * @return nombre de nourriture
     */
   public int getNbRessourceZone() {
        return nbNourritureSurZone;
    }

    /**
     * Recuperer le nombre d'ouvrier sur la zone
     * @return le nombre d'ouvrier
     */
    public int getNbOuvrierSurZone() {
        return nbOuvrierSurZone;
    }

    /**
     * Recuperer le nombre d'ouvrier du joueur i sur la zone
     * @param i le num du joueur
     * @return le nombre d'ouvriers
     */
    public int getNbOuvrierDuJoueurI(int i) {
        return nbOuvrierDuJoueurI[i-1];
    }

    /**
     *dimminuer les nourriture pour chaque tour
     */
    public void diminuerRessource() {
    	if (nbNourritureSurZone-(resultat_De)>=0)   
    		nbNourritureSurZone-=resultat_De;
    }

    /**
     * Placer les ouvriers sur la zone
     * @param nbOuvrierAplacer un nombre d'ouvrier
     * @param id le num du joueur
     */
    public void placeOuvrier(int nbOuvrierAplacer, int id) {
        nbOuvrierSurZone += nbOuvrierAplacer;
        nbOuvrierDuJoueurI[id-1] += nbOuvrierAplacer;
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

     int somme = 0 ;
     for (int k = 0 ; k < getNbOuvrierDuJoueurI(j.getNum());k++){
         somme = somme + j.de();
     }
     if (somme > 6) {
         resultat_De = somme / 2  ;
         j.getInventaireJoueur().addNourriture(resultat_De);
     }

	    }	 
	
    }
	  



