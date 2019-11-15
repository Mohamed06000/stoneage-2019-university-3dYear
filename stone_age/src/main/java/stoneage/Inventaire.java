
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
    private int nbOuvrier;
    /**
     *   Le nombre de ressource du joueur
     */
    private int nbRessource = 0;
    
    /**
     * La quantite de nourriture du joueur (debut de jeu = 10 pour tous)
     */
    private int nbNourriture=10;

    /**
     * La quantité de la ressource bois du joueur
     */
    private int nbRessourceBois ;

    /**
     * Recuperer la quantité de bois du joueur
     * @return La quantité de bois
     */
    public int getNbRessourceBois() {
        return nbRessourceBois;
    }

    /**
     * Modifier la quantité de bois du joueur
     * @param nbRessourceBois Une quantité de bois
     */
    public void setNbRessourceBois(int nbRessourceBois) {
        this.nbRessourceBois = nbRessourceBois;
    }

    /**
     * Modifier le nombre d'ouvriers non placés de tous les joueurs
     * @param nbOuvrierNonPlace Un nombre d'ouvrier
     */
    public static void setNbOuvrierNonPlace(int nbOuvrierNonPlace) {
        Inventaire.nbOuvrierNonPlace = nbOuvrierNonPlace;
    }

    /**
     * Recuperer le nombre d'ouvrier non placé de tous les joueurs
     * @return Le nombre d'ouvrier
     */
    public static int getNbOuvrierNonPlace() {
        return nbOuvrierNonPlace;
    }

    /**
     *  Le coefiicient multiplicateur pour la Nourriture du joueur (initialiser (1)  joueur )
     */
    private int niveauAgriculture =0;

    /**
     * Recupere le multiplicateur de Nourriture du joueur
     * @return  le multiplicateur de Nourriture
     */
    public int getNiveauAgriculture(){ return niveauAgriculture; }

    /**
     * Incremente de 1 le multiplicateurNourriture dans l'Inventaire du joueur
     */
    public void addNiveauAgriculture(){  niveauAgriculture++; }


    /**
     * Incrementer le nbNourriture  par n Nourritures  gagné de la zone chasse pendant la phase recuperation.
     * @param nbNourritures Un quantité de nourriture
     */
    public void addNourriture(int nbNourritures)
    {
    	nbNourriture += nbNourritures ;
    }
    
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
    public void setNbNourriture(int nourriture) {nbNourriture=nourriture;}
    
    /**
     * Recupere la quantite de nourriture du joueur
     * @return quantite de nourriture
     */
    public int getNbNourriture() {
    	return nbNourriture;
    }
   
    /**
     * Soustraire une nourriture
     */
    public void subNourriture() {
    	nbNourriture--;
    }

    /**
     * Assigner un nombre d'ouvrier au joueur
     * @param nbOuvrier Le nombre d'ouvrier
     */
    public void setNbOuvrier(int nbOuvrier) {
        this.nbOuvrier = nbOuvrier;
    }

    /**
     * Soustraire un nombre d'ouvrier au joueur qu'il veut placer sur une zone
     * @param nbOuvrier Le nombre d'ouvrier
     */
    public void subOuvrier(int nbOuvrier){
        if (this.nbOuvrier>0) {
            this.nbOuvrier -= nbOuvrier;
        }
    }

    /**
     * Recuperer le nombre de ressource du joueur
     * @return Le nombre de ressource
     */
    public int getNbRessource() {
        return nbRessource;
    }

    /**
     * Assigne le nombre de ressource au joueur
     * @param nbRessource Le nombre de ressource
     */
    public void setNbRessource(int nbRessource) {
        this.nbRessource = nbRessource;
    }

    /**
     * Rajouter 1 ressource a l'inventaire du joueur ou 1 ouvrier en fonction de la zone
     **/
    public void addRessource(ZoneInterface z){
        if (z instanceof ZoneRessource){
            this.nbRessource++;
            }
        else if (z instanceof ZoneHutte){
            this.nbOuvrier++;
        }
        else {
        }
    }

    /**
     * Constructeur de la classe, on assigne 1 ouvrier par default
     */
    public Inventaire(){
        setNbOuvrier(5);
        nbOuvrierNonPlace+= nbOuvrier;
    }

    /**
     * Constructeur de la classe avec 2 parametres
     * @param nOuvrier Le nombre d'ouvrier a assigner
     * @param nRessource Le nombre de ressource a assigner
     */
    Inventaire(int nOuvrier, int nRessource){
        setNbRessource(nRessource);
        setNbOuvrier(nOuvrier);
    }


}
