
package stoneage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * La classe de l'inventaire du joueur
 */
public class Inventaire {

    //CHAMPS

    private int nbOuvrierTotal;

    /**
     * Le nombre d'ouvrier du joueur
     */
    private int nbOuvrier;

    /**
     * La quantitee de nourriture du joueur (debut de jeu = 10 pour tous)
     */
    private int nbNourriture;

    /**
     * La quantitée de la ressource bois du joueur
     */
    private int nbBois;

    /**
     * La quantitée d'Argile du joueur
     */
    private int nbArgile;

    /**
     * La quantitée de pierre du joueur
     */
    private int nbPierre;

    /**
     * La quantitée d'or du joueur
     */
    private int nbOr;

    /**
     * La quantité d'outils du joueur
     */
    private int nbOutils;

    /**
     *  Le niveau d'agriculture du joueur
     */
    private int niveauAgriculture;

    /**
     * Nombre de points du joueur
     */
    private int nbPointTotal;

    /**
     * tableau qui contient les cartes des civilisations gagnées par le joueur
     * */

     ArrayList<CarteCivilisation> stockCards = new ArrayList<CarteCivilisation>();
    /**
     * La liste des outils du joueur
     */
    private ArrayList<Integer> outils;

    /**
     * La liste des outils dispo du joueur
     */
    private ArrayList<Integer> outilsDispo;

    /**
     * La liste des outils non-dispo du joueur
     */
    private ArrayList<Integer> outilsNonDispo;


    //CONSTRUCTEUR

    /**
     * Constructeur de la classe
     */
    public Inventaire(){
        this.nbOuvrier = 5;
        this.nbOuvrierTotal=nbOuvrier;
        this.nbNourriture = 12;
        this.nbBois = 0;
        this.nbArgile = 0;
        this.nbPierre = 0;
        this.nbOr = 0;
        this.nbOutils = 0;
        this.niveauAgriculture = 0;
        this.outils = new ArrayList<Integer>(Arrays.asList(0,0,0));
        this.outilsDispo = new ArrayList<Integer>(Arrays.asList(0,0,0));
        this.outilsNonDispo = new ArrayList<Integer>(Arrays.asList(0,0,0));
    }


    //METHODES


    public int getNbOuvrierTotal() {
        return nbOuvrierTotal;
    }

    public void setNbOuvrierTotal(int nbOuvrierTotal) {
        this.nbOuvrierTotal = nbOuvrierTotal;
    }

    /**
     * Récupère la liste des outils non-dispo du joueur
     * @return La liste des outils
     */
    public ArrayList<Integer> getOutilsNonDispo() {
        return outilsNonDispo;
    }

    /**
     * Récupère la liste des outils du joueur
     * @return La liste des outils
     */
    public ArrayList<Integer> getOutils() {
        return outils;
    }

    /**
     * Récupère la liste des outils dispo du joueur
     * @return La liste des outils
     */
    public ArrayList<Integer> getOutilsDispo() {
        return outilsDispo;
    }

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
    
    public String toString() {
    	return "nb d'ouvrier= " +nbOuvrier+
    		     "\nnb bois = " +nbBois+
    		     "\nnbd'Argile = " +nbArgile+
    		     "\nnb Pierre = " +nbPierre+
    		     "\nnb d'or  = " +nbOr+
    		     "\nnb d'outils  = " +nbOutils+
    		     "\nnb nourriture = " +nbNourriture+
    		     "\nLe niveau d'agriculture = " +niveauAgriculture+
    		     "\nnb de points  = " +nbPointTotal ;
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
        point = this.getNbArgile()+this.getNbBois()+this.getNbNourriture()+this.getNbOr()+this.getNbPierre()+this.getNbOutils();
        return point;
    }

    /**
     * Réinitialise les ressources
     * @param i L'index du tableau
     * @param valeur La valeur à affecter
     */
    public void restRessource ( int  i,int valeur ){

        switch (i){

            case 0 :
                setNbBois(valeur);
                break;
            case 1:
                setNbArgile(valeur);
                break;
            case 2:
                setNbPierre(valeur);
                break;
            case 3:
                setNbOr(valeur);
                break;
        }
    }

    /**
     * Rècupère le nombre de ressource total du joueur
     * @return Le nombre de ressource
     */
    public int getNbRessourceTotal() {
        return getNbBois()+getNbArgile()+getNbPierre()+getNbOr();
    }
}
