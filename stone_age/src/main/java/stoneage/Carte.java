package stoneage;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import sun.font.TrueTypeFont;

public enum Carte  {
    CARTE1("Jaune",4,0,0,1,1);



    private String couleur;
    private int nbRessourceArgile;
    private int nbRessourceBois;
    private int nbRessourceOr;
    private int nbRessourcePierre;
    private int nbOuvrierMaxSurCarte;
    private int nbOuvrierSurCarte;
    private int Point;
    private int nbOuvrierDuJoueurI[];


    @org.jetbrains.annotations.Contract(pure = true)
    Carte(String couleur, int nbRessourceArgile, int nbRessourceBois, int nbRessourcePierre, int nbOuvrierMaxSurCarte, int Point) {
        this.couleur = couleur ;
        this.nbRessourceArgile = nbRessourceArgile;
        this.nbRessourceBois = nbRessourceBois;
        this.nbRessourcePierre= nbRessourcePierre;
        this.nbOuvrierMaxSurCarte= nbOuvrierMaxSurCarte ;
        this.Point = Point ;
        nbOuvrierDuJoueurI= new int[Joueur.getNbJoueur()];

    }

    @Contract(pure = true)
    //
    public int getNbRessourceBois() {
        return nbRessourceBois;
    }

    @Contract(pure = true)
    public int getNbRessourceArgile() {
        return nbRessourceArgile;
    }

    @Contract(pure = true)
    public int getNbRessourceOr() {
        return nbRessourceOr;
    }

    @Contract(pure = true)
    public int getNbRessourcePierre() {
        return nbRessourcePierre;
    }

    @Contract(pure = true)
    public int getPoint() {
        return Point;
    }

    public void setNbOuvrierSurCarte(int nbOuvrierSurCarte) {
        if ((nbOuvrierSurCarte > 1) || (nbOuvrierSurCarte < 0)){
            throw new java.lang.Error("Il ne peut pas y avoir plus d'un ouvrier sur une carte !");
        }
        else {
            this.nbOuvrierSurCarte = nbOuvrierSurCarte;
        }
        }


        public void placeOuvrierSurCarte(Inventaire inventaireJoueur, int nbOuvrierAplacer, int id){
        if((nbOuvrierSurCarte == 0)||(nbOuvrierSurCarte < 2)){
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier()-nbOuvrierAplacer);
        this.nbOuvrierSurCarte += nbOuvrierAplacer;
        nbOuvrierDuJoueurI[id-1] = nbOuvrierAplacer;
        }
        else{
            throw new java.lang.Error("Il ne peut pas y avoir plus d'un ouvrier sur cette carte!");
        }

    }

    public void retirerOuvrierSurCarte(@NotNull Inventaire inventaireJoueur, int id){
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + getNbOuvrierDuJoueurI(id));
        this.nbOuvrierSurCarte -= getNbOuvrierDuJoueurI(id);
    }




}
