
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
     * Inventaire du joueur
     */
    private Inventaire inventaireJoueur = new Inventaire();

    /**
     * Liste des zones où le joueur a placé ses ouvriers dans un tour
     */
    private ZoneInterface zoneVisit[] = new ZoneInterface[0];

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
    public ZoneInterface[] getZoneVisit() {
        return zoneVisit;
    }

    /**
     * Recupere l'inventaire du joueur
     * @return
     */
    public Inventaire getInventaireJoueur() {
        return inventaireJoueur;
    }

    /**
     * Placer ses ouvriers sur la zone
     * @param z La zone choisie
     * @param nbOuvrier Le nombre d'ouvrier a placer
     */
    public void placement(ZoneInterface z, int nbOuvrier){
        inventaireJoueur.subOuvrier(nbOuvrier);
        Inventaire.setNbOuvrierNonPlace(Inventaire.getNbOuvrierNonPlace()-nbOuvrier);
        z.placeOuvrier(nbOuvrier, getNum());
        zoneVisit = Arrays.copyOf(zoneVisit,zoneVisit.length+1);
        zoneVisit[zoneVisit.length-1] = z;
    }

    /**
     * Recuperer ses ouvriers et ressource de la zone
     * @param z La zone choisie
     */
    public void recupere(ZoneInterface z){

        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + z.getNbOuvrierDuJoueurI(getNum()));
        inventaireJoueur.addRessource(z); //suppr
        if (z instanceof ZoneRessource){//suppr
            z.diminuerRessource();
        }
        z.retirerOuvrier(z.getNbOuvrierDuJoueurI(getNum()), getNum());//suppr

    }

    /**
     * Nourrir ses ouvriers (1 nourriture/ouvrier)
     * @param i L'inventaire du joueur
     */
    public void nourrir(Inventaire i) {
        i.setNbNourriture(i.getNbNourriture()+i.getNiveauAgriculture());
        for (int j = 0; j < i.getNbOuvrier(); j++) {
                    if(i.getNbNourriture()>0) i.subNourriture();
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


    public void deleteZone(int index){
        zoneVisit = (ZoneInterface[]) ArrayUtils.remove(zoneVisit, index);
    }
}

