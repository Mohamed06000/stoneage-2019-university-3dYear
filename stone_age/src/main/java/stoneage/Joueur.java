package stoneage;

import java.util.Random ;


/**
 * Classe Joueur qui represente les informations et actions du joueur
 */
public class Joueur {

    /**
     * La numero du joueur
     */
    private int num;
    /**
     * Le nombre de joueur de type Joueur
     */
    private static int nbJoueur;

    /**
     * Constructeur de la classe Joueur qui accremente un nombre de joueur
     * en static et assigne un numero de joueur a l'objet instancie
     */
    public Joueur(){
        nbJoueur ++;
        num = nbJoueur;
    }

    /**
     * Methode de classe qui recupere le nombre de joueur
     * @return Le nombre de joueur
     */
    public static int getNbJoueur(){
        return nbJoueur;
    }

    /**
     * Recupere le numero du joueur
     * @return Le numero du joueur
     */
    public int getNum(){
        return num;
    }

    /**
     * Placer ses ouvriers sur la zone
     * @param i L'inventaire du joueur
     * @param z La zone choisie
     */
    public void placement(Inventaire i, ZoneInterface z){
        i.subOuvrier(1);
        z.placeOuvrier(1);
    }

    /**
     * Recuperer ses ouvriers et ressource de la zone
     * @param i L'inventaire du joueur
     * @param z La zone choisie
     */
    public void recupere(Inventaire i, ZoneRessource z){

        i.setNbOuvrier(i.getNbOuvrier() + 1);
        i.addRessource(z);
        z.diminuerRessource();
        z.retirerOuvrier(1);

    }
    /**
     * Nourrir ses ouvriers (1 nourriture/ouvrier)
     * @param i L'inventaire du joueur
     */
    public void nourrir(Inventaire i) {
    	for (int j=0;j<i.getNbOuvrier();j++) {
    		i.subNourriture();
    	}

    }

    public void action (){
        int valeurDee = dée();
        System.out.println("La valeur du dée est : " + valeurDee);
    }


    public int dée(){
        Random rand = new Random();
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }
}
