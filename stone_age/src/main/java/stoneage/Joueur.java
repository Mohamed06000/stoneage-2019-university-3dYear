package stoneage;

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
    public void placement(Inventaire i, Zone z){
        i.subOuvrier(1);
        z.placeOuvrier(1);
    }

    /**
     * Recuperer ses ouvriers et ressource de la zone
     * @param i L'inventaire du joueur
     * @param z La zone choisie
     */
    public void recupere(Inventaire i, Zone z){
        i.setNbOuvrier(i.getNbOuvrier() + 1);
        i.addRessource();
        z.retirerOuvrier(1);
    }
}
