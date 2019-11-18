
package stoneage;

/**
 * Classe de l'inventaire du joueur
 */
public class Inventaire {


    private int nbOuvrierNonPlace;

    /**
     * Le nombre d'ouvrier du joueur
     */
    private int nbOuvrier = 5;
    private int nbNourriture = 5;
    private int nbBois = 0;
    private int nbArgile = 0;
    private int nbPierre = 0;
    private int nbOr = 0;
    private int nbOutils = 0;
    private int niveauAgriculture = 1;

    public void setNbOuvrierNonPlace(int nbOuvrierNonPlace) {
        this.nbOuvrierNonPlace = nbOuvrierNonPlace;
    }

    public int getNbOuvrierNonPlace() {
        return nbOuvrierNonPlace;
    }


    /**
     * Recupere le multiplicateur de Nourriture du joueur
     * @return  le multiplicateur de Nourriture
     */
    public int getNiveauAgriculture(){ return niveauAgriculture; }
    
    
    
    /**
     * Recupere le nombre d'ouvrier du joueur
     * @return le nombre d'ouvrier
     */
    public int getNbOuvrier() {
        return nbOuvrier;
    }

    /**
     *
     * @param nourriture
     * @return
     */
    public void setNbNourriture(int nourriture) {nbNourriture=nourriture;}
    
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



    public int getNbBois() {
        return nbBois;
    }

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
