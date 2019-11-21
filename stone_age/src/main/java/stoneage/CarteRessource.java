package stoneage;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public enum CarteRessource  {
    CARTE1("Jaune",4,0,0,0,false,1),
    CARTE2("Jaune",0,0,0,2,false,1),
    CARTE3("Jaune",0,0,1,0,false,1),
    CARTE4("Vert",0,0,2,0,false,1),
    CARTE5("Jaune",0,0,1,0,false, 1);



    private String couleur;
    private int nbRessourceArgile;
    private int nbRessourceBois;
    private int nbRessourceOr;
    private int nbRessourcePierre;
    private int nbOuvrierSurCarte;
    private int Point;
    private int nbOuvrierDuJoueurI[];
    private static boolean PlaceReserver = false ;




    @org.jetbrains.annotations.Contract(pure = true)
    CarteRessource(String couleur, int nbRessourceArgile, int nbRessourceBois, int nbRessourcePierre,int nbRessourceOr,boolean PlaceReserver ,int Point) {
        this.couleur = couleur ;
        this.nbRessourceArgile = nbRessourceArgile;
        this.nbRessourceBois = nbRessourceBois;
        this.nbRessourcePierre= nbRessourcePierre;
        this.nbRessourceOr = nbRessourceOr;
        this.Point = Point ;
        nbOuvrierDuJoueurI= new int[Joueur.getNbJoueur()];

    }

    public String  toString(){
        return ""+couleur+" "+nbRessourceBois+" "+nbRessourceArgile+" "+nbRessourceOr;
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


        public void placeOuvrierSurCarte(Inventaire inventaireJoueur, int nbOuvrierAplacer, int id){
        if((PlaceReserver == false)||(nbOuvrierAplacer == 1)){
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier()-nbOuvrierAplacer);
        PlaceReserver = true ;
        //nbOuvrierDuJoueurI[id-1] = nbOuvrierAplacer;
        }
        else{
            throw new java.lang.Error("Il ne peut pas y avoir plus d'un ouvrier sur cette carte!");
        }

    }

    public void retirerOuvrierSurCarte(@NotNull Inventaire inventaireJoueur, int id) {
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + 1);
        PlaceReserver = false;

    }




    public void gainCarte(Inventaire inventaireJoueur ,Joueur j) {
        switch (this) {
            case CARTE1:
                inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() + CARTE1.getNbRessourceArgile());
                inventaireJoueur.setNbPointTotal(inventaireJoueur.getNbPointTotal() + CARTE1.getPoint());
                break;

            case CARTE2:
                inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() + CARTE2.getNbRessourceOr());
                inventaireJoueur.setNbPointTotal(inventaireJoueur.getNbPointTotal() + CARTE2.getPoint());
                break;
            case CARTE3:
                inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() + CARTE3.getNbRessourcePierre());
                inventaireJoueur.setNbPointTotal(inventaireJoueur.getNbPointTotal() + CARTE3.getPoint());
                break;
            case CARTE4:
                inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() + CARTE4.getNbRessourcePierre());
                inventaireJoueur.setNbPointTotal(inventaireJoueur.getNbPointTotal() + CARTE4.getPoint());
                break;
            case CARTE5:
                inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre()+ CARTE5.getNbRessourcePierre());



        }
    }


}
