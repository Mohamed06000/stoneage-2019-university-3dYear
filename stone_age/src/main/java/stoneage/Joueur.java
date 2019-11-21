
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
    private int num;

    /**
     * Le nombre de joueur de type Joueur
     */
    private static int nbJoueur;



    /**
     * Liste des zones où le joueur a placé ses ouvriers dans un tour
     */
    private final ArrayList<Zone> zoneVisite = new ArrayList<>();
    //private ZoneInterface zoneVisit[] = new ZoneInterface[0];

    /**
     * Constructeur de la classe Joueur qui incremente un nombre de joueur
     * en static et assigne un numero de joueur a l'objet instancie
     */
    Joueur(){
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


    //public int getNbOuvrierjoueurI(int id){

    //}



    /**
     * Recupere le numero du joueur
     * @return Le numero du joueur
     */
    public int getNum(){
        return num;
    }

    /**
     * Recupere la liste des zones visités du joueur
     * @return
     */
    /*public ZoneInterface[] getZoneVisit() {
        return zoneVisit;
    }*/
    public ArrayList<Zone> getZoneVisite() {
        return zoneVisite;
    }

    /**
     * Placer ses ouvriers sur la zone
     * @param zone La zone choisie
     * @param nbOuvrier Le nombre d'ouvrier a placer
     */
    public void placement(Inventaire inventaire, Zone zone, int nbOuvrier){
        //Inventaire.setNbOuvrierNonPlace(Inventaire.getNbOuvrierNonPlace()-nbOuvrier);
        zone.placeOuvrierSurZone(inventaire, nbOuvrier, getNum());
        zoneVisite.add(zone);
        //zoneVisit = Arrays.copyOf(zoneVisit,zoneVisit.length+1);
        //zoneVisit[zoneVisit.length-1] = z;
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
     * Pour l'instant elle affiche la valeur du lancé de dé
     */
    public void action (){
        int valeurDee = de();
        System.out.println("La valeur du d�e est : " + valeurDee);
    }

    public int NBressourceTotal(Inventaire inventaire){

        return inventaire.getNbArgile() + inventaire.getNbBois() + inventaire.getNbOr()+ inventaire.getNbPierre();
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


}

