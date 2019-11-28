
package stoneage;

/**
 * La classe de l'inventaire du joueur
 */
public class Inventaire {

    //CHAMPS

    /**
     * Le nombre d'ouvrier du joueur
     */
    private int nbOuvrier;

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
     *  Le niveau d'agriculture du joueur
     */
    private int niveauAgriculture = 0;

    /**
     * Nombre de points du joueur
     */
    private int nbPointTotal;


    //CONSTRUCTEUR

    /**
     * Constructeur de la classe
     */
    public Inventaire(){
        this.nbOuvrier = 5;
    }


    //METHODES

    /**
     * Recupere le niveau d'agriculture du joueur
     * @return  Le niveau d'agriculture
     */
    public int getNiveauAgriculture(){ return this.niveauAgriculture; }

    /**
     * Affecte un nombre au niveau d'agriculture du joueur
     * @param niveauAgriculture Un nombre
     */
    public void setNiveauAgriculture(int niveauAgriculture) {this.niveauAgriculture = niveauAgriculture;}

    /**
     * Recupere le nombre d'ouvrier du joueur
     * @return Le nombre d'ouvrier
     */
    public int getNbOuvrier() {
        return nbOuvrier;
    }

    /**
     * Affecte un nombre d'ouvrier au joueur
     * @param nbOuvrier Le nombre d'ouvrier
     */

    public void setNbOuvrier(int nbOuvrier) {this.nbOuvrier = nbOuvrier; }


    /**
     * Recupere la quantité de nourriture du joueur
     * @return quantitee de nourriture
     */
    public int getNbNourriture() {
        return nbNourriture;
    }

    /**
     * Affecte une quantité de nourriture au joueur
     * @param nourriture Une quantité de nourriture
     */
    public void setNbNourriture(int nourriture) {this.nbNourriture=nourriture;}

    /**
     * Recuperer la quantité de bois du joueur
     * @return La quantité de bois
     */
    public int getNbBois() {
        return nbBois;
    }

    /**
     * Affecte une quantité de bois au joueur
     * @param nbBois Une quantité de bois
     */
    public void setNbBois(int nbBois) {
        this.nbBois = nbBois;
    }

    /**
     * Recuperer la quantité d'argile du joueur
     * @return La quantité d'argile
     */
    public int getNbArgile() { return nbArgile; }

    /**
     * Affecte une quantité de d'argile au joueur
     * @param nbArgile La quantité d'argile
     */
    public void setNbArgile(int nbArgile) { this.nbArgile = nbArgile; }

    /**
     * Recuperer la quantité de pierre du joueur
     * @return La quantité de pierre
     */
    public int getNbPierre() {return nbPierre; }

    /**
     * Affecte une quantité de pierre au joueur
     * @param nbPierre Une quantité de pierre
     */
    public void setNbPierre(int nbPierre) { this.nbPierre = nbPierre; }

    /**
     * Recuperer la quantité d'or du joueur
     * @return La quantité d'or
     */
    public int getNbOr() {return nbOr; }

    /**
     * Affecte une quantité d'or au joueur
     * @param nbOr Une quantité d'or
     */
    public void setNbOr(int nbOr) {this.nbOr = nbOr; }

    /**
     * Recuperer le nombre d'outils du joueur
     * @return Le nombre d'outils
     */
    public int getNbOutils() { return nbOutils; }

    /**
     * Affecte un nombre d'outils au joueur
     * @param nbOutils Un nombre d'outils
     */
    public void setNbOutils(int nbOutils) {this.nbOutils = nbOutils; }

    /**
     * Récupère le nombre de points du joueur
     * @return Un nombre de points
     */
    public int getNbPointTotal() {
        return nbPointTotal;
    }

    /**
     * Affecte un nombre de points au joueur
     * @param nbPointTotal Un nombre de points
     */
    public void setNbPointTotal(int nbPointTotal) {
        this.nbPointTotal = nbPointTotal;
    }

    /**
     * Calcule les points du joueur
     * @return Un nombre de points
     */
    public int calculPoint(){
        int point;
        point = this.getNbArgile()+this.getNbBois()+this.getNbNourriture()+this.getNbOr();
        point += this.getNbPierre()+this.getNbOutils();
        return point;
    }


    public void restRessource ( int  i,int valeur ){
        int tab[] = {nbBois,nbArgile,nbPierre,nbOr} ;
        tab[i] = valeur ;
    }

}
