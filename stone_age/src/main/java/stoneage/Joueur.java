
package stoneage;

import org.apache.commons.lang.ArrayUtils;

import java.util.* ;


/**
 * Classe Joueur qui represente les informations et actions du joueur
 */

class Joueur {

    /**
     * La numero du joueur
     */
    private int num = 0;

    /**
     * Le nombre de joueur de type Joueur
     */
    private static int nbJoueur;


    /**
     * Constructeur de la classe Joueur qui incremente un nombre de joueur
     * en static et assigne un numero de joueur a l'objet instancie
     */
    Joueur(){
        nbJoueur ++;
        num = nbJoueur;
    }



    /**
     * Recupere le numero du joueur
     * @return Le numero du joueur
     */
    public int getNum(){
        return num;
    }



    /**
     * Nourrir ses ouvriers (1 nourriture/ouvrier)
     * @param i L'inventaire du joueur
     */
    public static void nourrir(Inventaire i) {
        i.setNbNourriture(i.getNbNourriture()+i.getNiveauAgriculture());
        for (int j = 0; j < i.getNbOuvrier(); j++) {
                    if(i.getNbNourriture()>0) i.setNbNourriture(-1);
                }
            }


    /**
     * Lancer un de
     * @return Valeur du de
     */
    Random rand = new Random();
    public int de(){
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        System.out.println("La valeur du dé est : " + result);
        return result ;
    }


    public Zone choixZone(ArrayList<Zone> zonesDispo) {
        int alea = rand.nextInt(zonesDispo.size()); // Sans +1 a l'interieur de rand sinon ca peut retourner alea=8 alors qu'on a index max = 7.
        return zonesDispo.get(alea);
    }

    public int choixNbOuvrier(Inventaire inventaire) {
        int alea = rand.nextInt(inventaire.getNbOuvrier())+1; //le +1 a l'exterieur de rand sinon ca peut retourner 0.
        return alea;

    }

}

