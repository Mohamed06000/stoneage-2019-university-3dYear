package stoneage;

import java.util.Arrays;

public enum NourritureCards  {
    CARTE1("vert",1,1,false),
    CARTE2("vert",2,1,false),
    CARTE3("vert",3,1,false),
    CARTE4("Vert",4,1,false),
    CARTE5("Vert",5,1,false),
    CARTE6("Vert",6,1,false),
    CARTE7("Vert",7,1,false);



    private String couleur;
    private int Point;
    private int nbRessourceNourriture;
    private  boolean PlaceReserver  ;


    NourritureCards(String couleur, int nbRessourceNourriture,int Point,boolean PlaceReserver ) {
        this.couleur = couleur ;
        this.nbRessourceNourriture=nbRessourceNourriture;
        this.PlaceReserver=PlaceReserver;


        this.Point = Point ;

    }

    public String  toString(){
        return "couleur carte "+couleur+" "+" "+nbRessourceNourriture+ " nourritures |"+" place reservee "+PlaceReserver ;
    }



    public int getNbRessourceNourritures() {
        return nbRessourceNourriture;
    }

    public int getPoint() {
        return Point;
    }




    public void retirerOuvrierSurCarte( Inventaire inventaireJoueur, int id) {
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() +1);
        PlaceReserver = false ;



    }


}

