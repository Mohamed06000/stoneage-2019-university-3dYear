package stoneage;

import java.util.ArrayList;
import java.util.Random;


/**
 * La classe enum qui gère les differentes zone du jeu
 */
public enum Zone {

    //ENUM

    CHASSE("Nourriture", 12, 2, 0, Integer.MAX_VALUE), //-1 marche pas, donc MAX_VALUE ok !
    FORET("Bois", 12, 3, 0, 7),
    GLACIERE("Argile", 12, 4, 0, 7),
    CARRIERE("Pierre", 12, 5, 0, 7),
    RIVIERE("Or", 12, 6, 0, 7),
    FABRIQUE("Outils", 0, 0, 0, 1),
    HUTTE("Ouvrier", 0, 0, 0, 2),
    CHAMP("Niveau d'agriculture", 0, 1, 0, 1);

    //CHAMPS

    /**
     * Un objet de Random
     */
    Random rand = new Random();

    /**
     * Le nom de la ressource
     */
    private String ressource;

    /**
     * La valeur du diviseur pour le calcul du gain
     */
    private int diviseur;

    /**
     * Le nombre maximum d'ouvriers sur la zone
     */
    private int nbOuvrierMaxSurZone;

    /**
     * Le nombre d'ouvriers sur la zone
     */
    private int nbOuvrierSurZone;

    /**
     * Le nombre de ressources de la zone
     */
    private int nbRessourcesZone;

    /**
     * La liste du nombre d'ouvriers placés sur la zone par les joueurs
     */
    private ArrayList<Integer> nbOuvirerDuJoueur = new ArrayList<Integer>(); //Pour savoir cb d'ouvriers le joueur i a placé sur la zone z.

    //CONSTRUCTEUR

    /**
     * Constructeur de la classe
     *
     * @param ressource Le nom de la ressource
     * @param nbRessourcesZone Le nombre de ressource de la zone
     * @param diviseur Le diviseur de gain de la zone
     * @param nbOuvrierSurZone Le nombre d'ouvriers sur la zone
     * @param nbOuvrierMaxSurZone Le nombre d'ouviers maximum sur la zone
     */
    Zone(String ressource, int nbRessourcesZone, int diviseur, int nbOuvrierSurZone, int nbOuvrierMaxSurZone) {
        this.ressource = ressource;
        this.diviseur = diviseur;
        this.nbOuvrierMaxSurZone = nbOuvrierMaxSurZone;
        this.nbOuvrierSurZone = nbOuvrierSurZone;
        this.nbRessourcesZone = nbRessourcesZone;
        for (int i = 0; i < Partie.getNbJoueur(); i++) { //Initialisation de la liste nbOuvrierDuJoueur par des valeurs 0.
            this.nbOuvirerDuJoueur.add(0);
        }
    }

    //METHODES

    /**
     * Récupère le nombre d'ouvriers du joueur placés sur la zone
     * @param i Le numéro du joueur
     * @return Le nombre d'ouvriers
     */
    public int getNbOuvirerDuJoueur(int i) {
        return  nbOuvirerDuJoueur.get(i);
    }

    /**
     * Récupère le nombre d'ouvriers maximum sur la zone
     * @return Le nombre d'ouvriers maximum
     */
    public int getNbOuvrierMaxSurZone() {
        return nbOuvrierMaxSurZone;
    }

    /**
     * Récupère le nombre de ressource sur la zone
     * @return Le nombre de ressource
     */
    public int getNbRessourcesZone() {
        return nbRessourcesZone;
    }

    /**
     * Récupère le nombre d'ouvriers sur la zone
     * @return Le nombre d'ouvriers sur la zone
     */
    public int getNbOuvrierSurZone() {
        return this.nbOuvrierSurZone;
    }

    /**
     * Récupère le nom de la ressource de la zone
     * @return le nom de la ressource
     */
    public String getRessource() {
        return ressource;
    }

    /**
     * Récupère le diviseur de la zone
     * @return Le diviseur
     */
    public int getDiviseur() {
        return diviseur;
    }

    /**
     * Affecte un nombre d'ouvriers sur la zone
     * @param nbOuvrierSurZone Un nombre d'ouvriers
     */
    public void setNbOuvrierSurZone(int nbOuvrierSurZone) {
        this.nbOuvrierSurZone = nbOuvrierSurZone;
    }

    /**
     * Affecte un nombre de ressources sur la zone
     * @param nbRessourcesZone Un nombre de ressource
     */
    public void setNbRessourcesZone(int nbRessourcesZone) {
        this.nbRessourcesZone = nbRessourcesZone;
    }

    /**
     * Place un nombre d'ouvriers sur la zone
     * @param inventaireJoueur L'inventaire du joueur qui place
     * @param nbOuvrierAplacer Le nombre d'ouvriers que le joueur place
     * @param nJoueur Le numéro du joueur
     */
    public void placeOuvrierSurZone(Inventaire inventaireJoueur, int nbOuvrierAplacer, int nJoueur) {
        this.nbOuvrierSurZone += nbOuvrierAplacer;
        this.nbOuvirerDuJoueur.set(nJoueur, getNbOuvirerDuJoueur(nJoueur) + nbOuvrierAplacer); //set permet de remplacer un element à un index donné contrairement a add.
    }

    /**
     * Retire un nombre d'ouvriers de la zone
     * @param inventaireJoueur L'inventaire du joueur qui retire
     * @param nbOuvrierAretirer Le nombre d'ouvriers que le joueur retire
     * @param nJoueur Le numéro du joueur
     */
    public void retirerOuvrierSurZone(Inventaire inventaireJoueur, int nbOuvrierAretirer, int nJoueur) {
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + nbOuvrierAretirer);
        this.nbOuvrierSurZone -= nbOuvrierAretirer;
        this.nbOuvirerDuJoueur.set(nJoueur, 0); // On réinitialise a 0 une fois les ouvriers récuperés.
    }

    /**
     * Lance un dé
     * @return Un chiffre entre 1 et 6
     */
    public int de(){
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }

    /**
     * Lance la procédure de gain des zones
     * @param inventairejoueur L'inventaire du joueur
     * @param nJoueur Le numéro du joueur
     */
    public void gainZone(Inventaire inventairejoueur, int nJoueur) {

        switch (this) {
            case CHASSE:

            case FORET:

            case GLACIERE:

            case CARRIERE:

            case RIVIERE:
                procedure(inventairejoueur, nJoueur);
                break;

            case CHAMP:
                inventairejoueur.setNiveauAgriculture(inventairejoueur.getNiveauAgriculture()+1);
                retirerOuvrierSurZone(inventairejoueur, getNbOuvirerDuJoueur(nJoueur), nJoueur);
                break;

            case HUTTE:
                inventairejoueur.setNbOuvrier(inventairejoueur.getNbOuvrier() + 1);
                retirerOuvrierSurZone(inventairejoueur, getNbOuvirerDuJoueur(nJoueur), nJoueur);
                break;

            case FABRIQUE:
                inventairejoueur.setNbOutils(inventairejoueur.getNbOutils() + 1);
                retirerOuvrierSurZone(inventairejoueur, getNbOuvirerDuJoueur(nJoueur), nJoueur);
                break;
        }
    }

    /**
     * Calcule du gain des zones ressources
     * @param inventaire L'inventaire du joueur
     */
    public void procedure(Inventaire inventaire, int nJoueur) {
        int somme = 0;
        int gain = 0;

        for (int i = 0; i < this.getNbOuvirerDuJoueur(nJoueur); i++) { //Le nbOuvrierDuJoueur sur la zone en question et non pas de tous ses ouvriers.
            somme += de();
        }
        if (somme >= 6)
            gain = somme / this.getDiviseur();

        switch (this.getRessource()) {

            case "Nourriture":
                inventaire.setNbNourriture(inventaire.getNbNourriture() + gain);
                break;
            case "Bois":
                inventaire.setNbBois(inventaire.getNbBois() + gain);
                break;
            case "Argile":
                inventaire.setNbArgile(inventaire.getNbArgile() + gain);
                break;
            case "Pierre":
                inventaire.setNbPierre(inventaire.getNbPierre() + gain);
                break;
            case "Or":
                inventaire.setNbOr(inventaire.getNbOr() + gain);
                break;

            default:
                break;
        }
        this.setNbRessourcesZone(this.getNbRessourcesZone()-gain);
        retirerOuvrierSurZone(inventaire, getNbOuvirerDuJoueur(nJoueur), nJoueur);
    }
}
