package stoneage;

/**
 * Classe de l'inventaire du joueur
 */
public class Inventaire {

    /**
     * Le nombre d'ouvrier du joueur
     */
    private int nbOuvrier;
    /**
<<<<<<< HEAD
     *   Le nombre de ressource du joueur
=======
     * Le nombre de ressource du joueur
>>>>>>> origin/Baroudi
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
