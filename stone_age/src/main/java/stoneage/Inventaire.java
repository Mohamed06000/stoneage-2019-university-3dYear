
package stoneage;

/**
 * Classe de l'inventaire du joueur
 */
public class Inventaire {


    /**
     * Le nombre n'ouvriers de tous les joueurs non placé sur les zones
     */
    private static int nbOuvrierNonPlace;
    /**
     * Le nombre d'ouvrier du joueur
     */
    private int nbOuvrier = 5;
    /**
     * La quantitee de nourriture du joueur (debut de jeu = 10 pour tous)
     */
    private int nbNourriture = 5;
    /**
     * La quantitée de la ressource bois du joueur
     */
    private int nbBois = 2;
    /**
     * La quantitée d'Argile du joueur
     */
    private int nbArgile = 0;
    /**
     * La quantitée de pierre du joueur
     */
    private int nbPierre = 4;
    /**
     * La quantitée d'or du joueur
     */
    private int nbOr = 0;
    /**
     * La quantité d'outils du joueur
     */
    private int nbOutils = 0;
    /**
     *  Le niveau d'agriculture du joueur (initialiser à 0)
     */
    private int niveauAgriculture = 1;

    //le nombre de points total du joueur .
    private int nbPointTotal = 0 ;


    /**
     * Modifier le nombre d'ouvriers non placés de tous les joueurs
     * @param nbOuvrierNnPlace Un nombre d'ouvrier
     */
    public static void setNbOuvrierNonPlace(int nbOuvrierNnPlace) {
        nbOuvrierNonPlace = nbOuvrierNnPlace;
    }

    /**
     * Recuperer le nombre d'ouvrier non placé de tous les joueurs
     * @return Le nombre d'ouvrier
     */
    public static int getNbOuvrierNonPlace() { return nbOuvrierNonPlace; }

    /**
     * Recupere le niveau d'agriculture du joueur
     * @return  NiveauAgriculture le niveau d'agriculture
     */
    public int getNiveauAgriculture(){ return this.niveauAgriculture; }

    /**
     * Modifier le niveau d'agriculture du joueur
     * @param niveauAgriculture
     */
    public void setNiveauAgriculture(int niveauAgriculture) {this.niveauAgriculture = niveauAgriculture;}

    /**
     * Incremente de 1 le multiplicateurNourriture dans l'Inventaire du joueur
     */
    public void addNiveauAgriculture(){ niveauAgriculture++; }

    /**
     * Recupere le nombre d'ouvrier du joueur
     * @return le nombre d'ouvrier
     */
    public int getNbOuvrier() {
        return nbOuvrier;
    }

    /**
     * Modifier la quantité de nourriture du joueur
     * @param nourriture Une quantité de nourriture
     * @return
     */
    public void setNbNourriture(int nourriture) {this.nbNourriture=nourriture;}
    
    /**
     * Recupere la quantité de nourriture du joueur
     * @return quantitee de nourriture
     */
    public int getNbNourriture() {
    	return nbNourriture;
    }

    /**
     * Assigner un nombre d'ouvrier au joueur
     * @param nbOuvrier Le nombre d'ouvrier
     */
    public void setNbOuvrier(int nbOuvrier) {this.nbOuvrier = nbOuvrier; }

    /**
     * Recuperer la quantité de bois du joueur
     * @return La quantité de bois
     */
    public int getNbBois() {
        return nbBois;
    }

    /**
     * Modifier la quantité de bois du joueur
     * @param nbBois Une quantité de bois
     */
    public void setNbBois(int nbBois) {
        this.nbBois = nbBois;
    }

    /**
     * Recuperer la quantité d'argile du joueur
     * @return nbArgile la  quantité d'argile
     */
    public int getNbArgile() { return nbArgile; }

    /**
     * Modifier la quantité de d'argile du joueur
     * @param nbArgile
     */
    public void setNbArgile(int nbArgile) { this.nbArgile = nbArgile; }

    /**
     * Recuperer la quantité de pierre du joueur
     * @return nbPierre la quantité de pierre
     */
    public int getNbPierre() {return nbPierre; }

    /**
     * Modifier la quantité de pierre du joueur
     * @param nbPierre
     */
    public void setNbPierre(int nbPierre) { this.nbPierre = nbPierre; }

    /**
     * Recuperer la quantité d'or du joueur
     * @return nbOr la quantité d'or
     */
    public int getNbOr() {return nbOr; }

    /**
     * Modifier la quantité d'or du joueur
     * @param nbOr
     */
    public void setNbOr(int nbOr) {this.nbOr = nbOr; }

    /**
     * Recuperer le nombre d'outils du joueur
     * @return nbOutils le nombre d'outils
     */
    public int getNbOutils() { return nbOutils; }

    /**
     * modifier le nombre d'outils du joueur
     * @param nbOutils
     */
    public void setNbOutils(int nbOutils) {this.nbOutils = nbOutils; }

    public int getNbPointTotal() {
        return nbPointTotal;
    }

    public void setNbPointTotal(int nbPointTotal) {
        this.nbPointTotal = nbPointTotal;
    }

    /**
     * Constructeur de la classe, on assigne 1 ouvrier par default
     */
    public Inventaire(){
        setNbOuvrier(5);
        setNbOuvrierNonPlace(5);
    }

    /* update OuvierNonPlace quand un place n ouvrier */
    public void enleveOuvrierNonPlace(int n){
        nbOuvrierNonPlace -= n;
    }


    /* update OuvrierNonPlace quand un recupere n ouvrier*/
    public void ajouteOuvrierNonPlace(int n){
        nbOuvrierNonPlace += n;
    }

}
