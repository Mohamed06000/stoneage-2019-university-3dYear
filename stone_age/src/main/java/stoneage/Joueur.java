
package stoneage;

import org.apache.commons.lang.ArrayUtils;

import java.util.* ;


/**
 * Classe Joueur qui represente les informations et actions du joueur
 */
<<<<<<< HEAD
class Joueur {
=======
public class Joueur {

>>>>>>> origin/mazy

    /**
     * La numero du joueur
     */
    private int num;

    /**
     * Le nombre de joueur de type Joueur
     */
    private static int nbJoueur;
<<<<<<< HEAD
    private Inventaire inventaireJoueur = new Inventaire(5,10);
=======
    private Inventaire inventaireJoueur = new Inventaire();
    private ZoneInterface zoneVisit[] = new ZoneInterface[0];
>>>>>>> origin/mazy

    /**
     * Constructeur de la classe Joueur qui incremente un nombre de joueur
     * en static et assigne un numero de joueur a l'objet instancie
     */
    Joueur(){
        nbJoueur ++;
        num = nbJoueur;
    }

<<<<<<< HEAD


    /**
     * Methode de classe qui recupere le nombre de joueur
     * @return Le nombre de joueur
     */
    public static int getNbJoueur(){
        return nbJoueur;
    }
=======
>>>>>>> origin/mazy

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
        return this.inventaireJoueur;
    }

    /**
     * Placer ses ouvriers sur la zone
     * @param z La zone choisie
     */
<<<<<<< HEAD
    public void placement(ZoneInterface z){
        inventaireJoueur.subOuvrier(1);
        z.placeOuvrier(1);
=======
    public void placement(ZoneInterface z, int nbOuvrier){
        inventaireJoueur.subOuvrier(nbOuvrier);
        Inventaire.setNbOuvrierNonPlace(Inventaire.getNbOuvrierNonPlace()-nbOuvrier);
        z.placeOuvrier(nbOuvrier, getNum());
        zoneVisit = Arrays.copyOf(zoneVisit,zoneVisit.length+1);
        zoneVisit[zoneVisit.length-1] = z;
>>>>>>> origin/mazy
    }

    /**
     * Recuperer ses ouvriers et ressource de la zone
     * @param z La zone choisie
     */
    public void recupere(ZoneInterface z){

<<<<<<< HEAD
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + 1);
        inventaireJoueur.addRessource(z);
        /*Censé etre z.gainZone (joueur)*/
        if (z instanceof ZoneRessource){
            z.gainZone(this);
        }
        if (z instanceof ZoneHutte){
            z.gainZone(this);
=======
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + z.getNbOuvrierDuJoueurI(getNum()));
        inventaireJoueur.addRessource(z); //suppr
        if (z instanceof ZoneRessource){//suppr
            z.diminuerRessource();
>>>>>>> origin/mazy
        }
        z.retirerOuvrier(z.getNbOuvrierDuJoueurI(getNum()), getNum());//suppr

    }

    /**
     * Nourrir ses ouvriers (1 nourriture/ouvrier)
     */
<<<<<<< HEAD
    public void nourrir(Inventaire i) {
        i.setNbNourriture(i.getNbNourriture()+i.getNiveauAgriculture());
        for (int j = 0; j < i.getNbOuvrier(); j++) {
                    if(i.getNbNourriture()>0) i.subNourriture();
                }
=======
    public void nourrir() {
        if (inventaireJoueur.getNbNourriture()>0){
            for (int j=0;j<inventaireJoueur.getNbOuvrier();j++) {
                inventaireJoueur.subNourriture();
>>>>>>> origin/mazy
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
<<<<<<< HEAD
    Random rand = new Random();
    public int dé(){
=======

    public int dé(){
        Random rand = new Random();
>>>>>>> origin/mazy
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }

<<<<<<< HEAD

=======
    public void deleteZone(int index){
        zoneVisit = (ZoneInterface[]) ArrayUtils.remove(zoneVisit, index);
    }
>>>>>>> origin/mazy
}
