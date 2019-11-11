package stoneage;

import org.apache.commons.lang.ArrayUtils;

import java.util.* ;


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
    private Inventaire inventaireJoueur = new Inventaire();
    private ZoneInterface zoneVisit[] = new ZoneInterface[0];

    /**
     * Constructeur de la classe Joueur qui accremente un nombre de joueur
     * en static et assigne un numero de joueur a l'objet instancie
     */
    public Joueur(){
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

    public ZoneInterface[] getZoneVisit() {
        return zoneVisit;
    }

    /**
     * Methode de classe qui recupere le nombre de joueur
     * @return Le nombre de joueur
     */
    public static int getNbJoueur(){
        return nbJoueur;
    }


    public Inventaire getInventaireJoueur() {
        return inventaireJoueur;
    }

    /**
     * Placer ses ouvriers sur la zone
     * @param z La zone choisie
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
     */
    public void nourrir() {
        if (inventaireJoueur.getNbNourriture()>0){
            for (int j=0;j<inventaireJoueur.getNbOuvrier();j++) {
                inventaireJoueur.subNourriture();
            }
        }
    }

    /**
     * Pour l'instant elle affiche la valeur du lancé de dé
     */
    public void action (){
        int valeurDee = dé();
        System.out.println("La valeur du dée est : " + valeurDee);
    }

    /**
     * Lancer un dé
     * @return Valeur du dé
     */

    public int dé(){
        Random rand = new Random();
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }

    public void deleteZone(int index){
        zoneVisit = (ZoneInterface[]) ArrayUtils.remove(zoneVisit, index);
    }
}
