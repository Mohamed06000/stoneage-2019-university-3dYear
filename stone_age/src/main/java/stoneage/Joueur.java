
package stoneage;

import org.apache.commons.lang.ArrayUtils;

import java.util.* ;


/**
 * La classe qui représente les informations et actions du joueur
 */
class Joueur {


    //CHAMPS

    /**
     * Le numero du joueur
     */
    private int num = 0;

    /**
     * Le nombre de joueur de type Joueur
     */
    private static int nbJoueur;

    /**
     * Objet de type Random
     */
    Random rand = new Random();


    //CONSTRUCTEUR

    /**
     * Constructeur de la classe
     */
    Joueur(){
        nbJoueur ++;
        num = nbJoueur;
    }


    //METHODES

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
    public void nourrir(Inventaire i) {
        i.setNbNourriture(i.getNbNourriture()+i.getNiveauAgriculture());
        for (int j = 0; j < i.getNbOuvrier(); j++) {
                    if(i.getNbNourriture()>0) i.setNbNourriture(-1);

        }
    }

    /**
     * Lancer un de
     * @return Valeur du de
     */
    public int de(){
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }

    /**
     * Choisit la zone de placement
     * @param zonesDispo Les zones disponibles au placement
     * @return Une zone
     */
    public Zone choixZone(ArrayList<Zone> zonesDispo) {
        int alea = rand.nextInt(zonesDispo.size()); // Sans +1 a l'interieur de rand sinon ca peut retourner alea=8 alors qu'on a index max = 7.
        return zonesDispo.get(alea);
    }

    /**
     * Choisit le nombre d'ouvrier à placer
     * @param inventaire L'inventaire du joueur
     * @param choixZone La zone choisit
     * @return Un nombre d'ouvriers
     */
    public int choixNbOuvrier(Inventaire inventaire, Zone choixZone) {

        int alea=0;

        switch (choixZone) {
            case FORET:
            case CHASSE:
            case GLACIERE:
            case CARRIERE:
            case RIVIERE:
                alea = rand.nextInt(inventaire.getNbOuvrier()) + 1; //le +1 a l'exterieur de rand sinon ca peut retourner 0.
                break;
            case HUTTE:
                alea = 2;
                break;
            case CHAMP:
            case FABRIQUE:
                alea = 1;
                break;
        }

        return alea;
    }

}

