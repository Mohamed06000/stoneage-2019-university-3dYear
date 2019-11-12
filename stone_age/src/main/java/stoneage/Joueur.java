package stoneage;

import java.util.Random ;


/**
 * Classe Joueur qui represente les informations et actions du joueur
 */
public class Joueur<get> {

    /**
     * La numero du joueur
     */
    private int num;
    /**
     * Le nombre de joueur de type Joueur
     */
    private static int nbJoueur;
    private Inventaire inventaireJoueur = new Inventaire();

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

    public Inventaire getInventaireJoueur() {
        return inventaireJoueur;
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
    public void recupere(Inventaire i, ZoneInterface z){

        i.setNbOuvrier(i.getNbOuvrier() + 1);
        i.addRessource(z);//ajouter une ressource au joueur 
        if (z instanceof ZoneRessource){
            z.diminuerRessource();//diminuer unr ressource de la zone
        }
        z.retirerOuvrier(1);

    }
    /**
     * Nourrir ses ouvriers (1 nourriture/ouvrier)
     * @param i L'inventaire du joueur
     */
    public void nourrir(Inventaire i) {
        if (i.getNbNourriture()>0){
            for (int j=0;j<i.getNbOuvrier();j++) {
                i.subNourriture();
            }
        }
    }

    /**
     * Pour l'instant elle affiche la valeur du lancé de dé
     */
    public void action (){
        int valeurDee = de();
        System.out.println("La valeur du de est : " + valeurDee);
    }

    /**
     * Lancer un dé
     * @return Valeur du dé
     */
    public int de(){
        Random rand = new Random();
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }
}
