package projet_stone;

/**
 * Classe de l'inventaire du joueur
 */
public class Inventaire {

    /**
     * Le nombre d'ouvrier du joueur
     */
    private int nbOuvrier;
    /**
     * Le nombre de ressource du joueur
     */
    private int nbRessource = 0;
    
    /**
     * La quantitée de nourriture du joueur (debut de jeu = 10 pour tous)
     */
    private int nbNourriture=10;
    
    /**
     * Recupere le nombre d'ouvrier du joueur
     * @return le nombre d'ouvrier
     */
    public int getNbOuvrier() {
        return nbOuvrier;
    }
    
    /**
     * Recupere la quantitée de nourriture du joueur
     * @return quantitée de nourriture
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
        this.nbOuvrier -= nbOuvrier;
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
     * Rajouter 1 ressource a l'inventaire du joueur
     */
    public void addRessource(){ this.nbRessource++; }

    /**
     * Constructeur de la classe, on assigne 1 ouvrier par default
     */
    public Inventaire(){
        setNbOuvrier(1);
    }

    /**
     * Constructeur de la classe avec 2 parametres
     * @param nOuvrier Le nombre d'ouvrier a assigner
     * @param nRessource Le nombre de ressource a assigner
     */
    public Inventaire(int nOuvrier, int nRessource){
        setNbRessource(nRessource);
        setNbOuvrier(nOuvrier);
    }
}
