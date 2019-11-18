package stoneage;

public enum Zone {
    CHASSE("Nourriture", 2,0,-1),
    FORET("Bois", 3,0,7),
    GLACIERE("Argile", 4,0,7),
    CARRIERE("Pierre", 5,0,7),
    RIVIERE("Or", 6,0,7),
    FABRIQUE("Outils",0,0,1),
    HUTTE("Ouvrier",0,0,2),
    CHAMP("Niveau d'agriculture",1,0,1);



    private String ressource;
    private int diviseur;
    private int nbOuvrierMaxSurZone; //nb d'ouvrier max sur une zone, -1 = pas de limite.
    private int nbOuvrierSurZone;

    public void setNbOuvrierSurZone(int nbOuvrierSurZone) {
        this.nbOuvrierSurZone = nbOuvrierSurZone;
    }

    public int getNbOuvrierSurZone() {
        return this.nbOuvrierSurZone;
    }

    public String getRessource() {
        return ressource;
    }

    public int getDiviseur() {
        return diviseur;
    }

    Zone(String ressource, int diviseur, int nbOuvrierSurZone, int nbOuvrierMaxSurZone) {
        this.ressource = ressource;
        this.diviseur = diviseur;
        this.nbOuvrierMaxSurZone = nbOuvrierMaxSurZone;
    }

    public void placeOuvrierSurZone(Inventaire inventaireJoueur, int nbOuvrierAplacer){
        inventaireJoueur.enleveOuvrierNonPlace(nbOuvrierAplacer);
        this.nbOuvrierSurZone += nbOuvrierAplacer;
    }

    public void retirerOuvrierSurZone(Inventaire inventaireJoueur, int nbOuvrierAretirer){
        inventaireJoueur.ajouteOuvrierNonPlace(nbOuvrierAretirer);
        this.nbOuvrierSurZone -= nbOuvrierAretirer;
    }


    public static void main(String[] args) {
        Zone chasse = Zone.FABRIQUE;
        System.out.println(chasse.nbOuvrierMaxSurZone);
    }



}
