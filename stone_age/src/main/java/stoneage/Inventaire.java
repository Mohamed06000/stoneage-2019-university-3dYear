
package stoneage;

/**
 * Classe de l'inventaire du joueur
 */
public class Inventaire {


    /**
     * Le nombre n'ouvriers de tous les joueurs non placé sur les zones
     */

    private int nbOuvrierNonPlace;
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
    private int nbBois = 0;
    /**
     * La quantitée d'Argile du joueur
     */
    private int nbArgile = 0;
    /**
     * La quantitée de pierre du joueur
     */
    private int nbPierre = 0;
    /**
     * La quantitée d'or du joueur
     */
    private int nbOr = 0;
    /**
     * La quantité d'outils du joueur
     */
    private int nbOutils = 0;
    /**
     *  Le coefficient multiplicateur pour la Nourriture du joueur (initialiser à 1)
     */
    private int niveauAgriculture = 1;


    /**
     * Modifier le nombre d'ouvriers non placés de tous les joueurs
     * @param nbOuvrierNonPlace Un nombre d'ouvrier
     */
    public  void setNbOuvrierNonPlace(int nbOuvrierNonPlace) {
        this.nbOuvrierNonPlace = nbOuvrierNonPlace;
    }

    /**
     * Recuperer le nombre d'ouvrier non placé de tous les joueurs
     * @return Le nombre d'ouvrier
     */
    public int getNbOuvrierNonPlace() { return this.nbOuvrierNonPlace; }

    /**
     * Recupere le multiplicateur de Nourriture du joueur
     * @return  le multiplicateur de Nourriture
     */
    public int getNiveauAgriculture(){ return this.niveauAgriculture; }


    /**
     * Incremente de 1 le multiplicateurNourriture dans l'Inventaire du joueur
     */
    public void addNiveauAgriculture(){  niveauAgriculture++; }

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
     * Recupere la quantitee de nourriture du joueur
     * @return quantitee de nourriture
     */
    public int getNbNourriture() {
    	return nbNourriture;
    }


    /**
     * Assigner un nombre d'ouvrier au joueur
     * @param nbOuvrier Le nombre d'ouvrier
     */
    public void setNbOuvrier(int nbOuvrier) {
        this.nbOuvrier = nbOuvrier;
    }


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

    public int getNbArgile() {
        return nbArgile;
    }

    public void setNbArgile(int nbArgile) {
        this.nbArgile = nbArgile;
    }

    public int getNbPierre() {
        return nbPierre;
    }

    public void setNbPierre(int nbPierre) {
        this.nbPierre = nbPierre;
    }

    public int getNbOr() {
        return nbOr;
    }

    public void setNbOr(int nbOr) {
        this.nbOr = nbOr;
    }

    public int getNbOutils() {
        return nbOutils;
    }

    public void setNbOutils(int nbOutils) {
        this.nbOutils = nbOutils;
    }

    public void setNiveauAgriculture(int niveauAgriculture) {
        this.niveauAgriculture = niveauAgriculture;
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
