package stoneage;

public enum Zone {
    CHASSE("Nourriture",12, 2,0,-1),
    FORET("Bois",12, 3,0,7),
    GLACIERE("Argile",12, 4,0,7),
    CARRIERE("Pierre",12, 5,0,7),
    RIVIERE("Or",12, 6,0,7),
    FABRIQUE("Outils",0,0,0,1),
    HUTTE("Ouvrier",0,0,0,2),
    CHAMP("Niveau d'agriculture",0,1,0,1);



    private String ressource;
    private int diviseur;
    private int nbOuvrierMaxSurZone; //nb d'ouvrier max sur une zone, -1 = pas de limite.
    private int nbOuvrierSurZone;
    private int nbRessourcesZone;
    private int nbOuvrierDuJoueurI[];

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

    Zone(String ressource, int nbRessourcesZone, int diviseur, int nbOuvrierSurZone, int nbOuvrierMaxSurZone) {
        this.ressource = ressource;
        this.diviseur = diviseur;
        this.nbOuvrierMaxSurZone = nbOuvrierMaxSurZone;
        this.nbOuvrierSurZone = nbOuvrierSurZone;
        this.nbRessourcesZone = nbRessourcesZone ;
        nbOuvrierDuJoueurI= new int[Joueur.getNbJoueur()];
    }

    public void placeOuvrierSurZone(Inventaire inventaireJoueur, int nbOuvrierAplacer, int id){
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier()-nbOuvrierAplacer);
        this.nbOuvrierSurZone += nbOuvrierAplacer;
        nbOuvrierDuJoueurI[id-1] = nbOuvrierAplacer;
    }

    public void retirerOuvrierSurZone(Inventaire inventaireJoueur, int id){
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + getNbOuvrierDuJoueurI(id));
        this.nbOuvrierSurZone -= getNbOuvrierDuJoueurI(id);
    }


    public static void main(String[] args) {
        Zone chasse = Zone.FABRIQUE;
        System.out.println(chasse.nbOuvrierMaxSurZone);
    }


    public void gainZone(Joueur j) {

    }

    public int getNbOuvrierDuJoueurI(int i) {
        return nbOuvrierDuJoueurI[i-1];
    }
}
