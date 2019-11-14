
package stoneage;

import java.util.Random ;


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
    private Inventaire inventaireJoueur = new Inventaire(5,10);

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

    public Inventaire getInventaireJoueur() {
        return this.inventaireJoueur;
    }

    /**
     * Placer ses ouvriers sur la zone
     * @param z La zone choisie
     */
    public void placement(ZoneInterface z){
        inventaireJoueur.subOuvrier(1);
        z.placeOuvrier(1);
    }

    /**
     * Recuperer ses ouvriers et ressource de la zone
     * @param z La zone choisie
     */
    public void recupere(ZoneInterface z){

        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + 1);
        inventaireJoueur.addRessource(z);
        /*Censé etre z.gainZone (joueur)*/
        if (z instanceof ZoneRessource){
            z.gainZone(this);
        }
        if (z instanceof ZoneHutte){
            z.gainZone(this);
        }
        z.retirerOuvrier(1);

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
    Random rand = new Random();
    public int dé(){
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }


}
