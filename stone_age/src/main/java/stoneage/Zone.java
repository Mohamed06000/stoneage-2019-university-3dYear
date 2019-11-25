package stoneage;

import java.util.ArrayList;
import java.util.Random;

// Une enum Zone representant les differentes zones du jeu

public enum Zone {
    CHASSE("Nourriture", 12, 2, 0, Integer.MAX_VALUE),
    FORET("Bois", 12, 3, 0, 7),
    GLACIERE("Argile", 12, 4, 0, 7),
    CARRIERE("Pierre", 12, 5, 0, 7),
    RIVIERE("Or", 12, 6, 0, 7),
    FABRIQUE("Outils", 0, 0, 0, 1),
    HUTTE("Ouvrier", 0, 0, 0, 2),
    CHAMP("Niveau d'agriculture", 0, 1, 0, 1);

    private String ressource;
    private int diviseur;
    private int nbOuvrierMaxSurZone; //nb d'ouvrier max sur une zone, -1 = pas de limite.
    private int nbOuvrierSurZone;
    private int nbRessourcesZone;
    private ArrayList<Integer> nbOuvirerDuJoueur = new ArrayList<Integer>();


    public int getNbOuvirerDuJoueur(int i) {
        return  nbOuvirerDuJoueur.get(i);
    }

    /**
     * Modifie le nombre d'ouvrier dans la zone
     *
     * @param nbOuvrierSurZone
     */
    public void setNbOuvrierSurZone(int nbOuvrierSurZone) {
        this.nbOuvrierSurZone = nbOuvrierSurZone;
    }

    public int getNbOuvrierMaxSurZone() {
        return nbOuvrierMaxSurZone;
    }

    public int getNbRessourcesZone() {
        return nbRessourcesZone;
    }

    public void setNbRessourcesZone(int nbRessourcesZone) {
        this.nbRessourcesZone = nbRessourcesZone;
    }

    /**
     * Retourner le nombre d'ouvrier sur la zone
     *
     * @return nbOuvrierSurZone
     */
    public int getNbOuvrierSurZone() {
        return this.nbOuvrierSurZone;
    }

    /**
     * Retourner le nom de la ressource de la zone
     *
     * @return ressource
     */
    public String getRessource() {
        return ressource;
    }

    /**
     * Retourner le diviseur de la zone
     *
     * @return
     */
    public int getDiviseur() {
        return diviseur;
    }



    /**
     * Constructeur de Zone
     *
     * @param ressource
     * @param nbRessourcesZone
     * @param diviseur
     * @param nbOuvrierSurZone
     * @param nbOuvrierMaxSurZone
     */


    Zone(String ressource, int nbRessourcesZone, int diviseur, int nbOuvrierSurZone, int nbOuvrierMaxSurZone) {
        this.ressource = ressource;
        this.diviseur = diviseur;
        this.nbOuvrierMaxSurZone = nbOuvrierMaxSurZone;
        this.nbOuvrierSurZone = nbOuvrierSurZone;
        this.nbRessourcesZone = nbRessourcesZone;
        for (int i = 0; i < 2; i++) {
            this.nbOuvirerDuJoueur.add(0);
        }
    }



    public void placeOuvrierSurZone(Inventaire inventaireJoueur, int nbOuvrierAplacer, int nJoueur) {
        this.nbOuvrierSurZone += nbOuvrierAplacer;
        this.nbOuvirerDuJoueur.set(nJoueur, nbOuvrierAplacer);
    }

    public void retirerOuvrierSurZone(Inventaire inventaireJoueur, int nbOuvrierAretirer, int nJoueur) {
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + nbOuvrierAretirer);
        this.nbOuvrierSurZone -= nbOuvrierAretirer;
        this.nbOuvirerDuJoueur.set(nJoueur, 0);
    }

    Random rand = new Random();
    public int de(){
        int result = 0 ;
        result = rand.nextInt(6)+1 ;
        return result ;
    }

    /**
     * Methode a utilisé dans gainZone (Factorisation de code)
     *
     * @param inventaire
     */
    public void procedure(Inventaire inventaire, int nJoueur) {
        int somme = 0;
        int gain = 0;

        for (int i = 0; i < this.getNbOuvirerDuJoueur(nJoueur); i++) {
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
                inventairejoueur.addNiveauAgriculture();
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
}
