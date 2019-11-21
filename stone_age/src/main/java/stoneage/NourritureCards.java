package stoneage;

import java.util.Arrays;
/*
* une enumeration qui contient les 7 cartes de civilisations  de nourritures
* */
public enum NourritureCards  {
    CARTE1("vert",1,1,1,false),
    CARTE2("vert",2,1,1,false),
    CARTE3("vert",3,1,2,false),
    CARTE4("Vert",4,1,2,false),
    CARTE5("Vert",5,1,3,false),
    CARTE6("Vert",6,1,3,false),
    CARTE7("Vert",7,1,4,false);



    private String couleur;
    private int Point;
    private int nbRessourceNourriture;
    private  boolean PlaceReserver  ;
    private int prix;


/*
* constructeur d'enumeration NourritureCards qui prend comme argumment:
* couleur de la carte
* nbRessourceNourriture sur cette carte
* le prix : nb et type de resssources a payer pour reccuperer la carte
*
* */
    NourritureCards(String couleur, int nbRessourceNourriture,int Point,int prix ,boolean PlaceReserver ) {
        this.couleur = couleur ;
        this.nbRessourceNourriture=nbRessourceNourriture;
        this.prix=prix;
        this.PlaceReserver=PlaceReserver;
        this.Point = Point ;

    }



    /*
    * redefinition de la methode toString pour l'enumeration*/
    public String  toString(){
        return "couleur carte "+couleur+" "+" "+nbRessourceNourriture+ " nourritures |"+" place reservee "+PlaceReserver ;
    }


/*
* methode qui retourne le nombre  de ressource de chaque carte
* */
    public int getNbRessourceNourritures() {
        return nbRessourceNourriture;
    }
/*
* methode qui retourne les points a gagner de chaque carte
* ces points seront compter a la fin de partie
* */
    public int getPoint() {
        return Point;
    }


/*
* methode qui retire le ouvrier de la carte
* */
    public void retirerOuvrierSurCarte( Inventaire inventaireJoueur, int id) {
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + 1);
        PlaceReserver = false;


    }

    public static boolean achatCarte = true;

    /**
     * méthode qui permet au Joueur  de payer la carte si celui ci posséde les ressources suffisantes .
     * @param inventaireJoueur
     * @param j
     */
    public void payement(Inventaire inventaireJoueur, Joueur j) {
        int somme = 0;
        int[] tab = new int[4];
        tab[0] = inventaireJoueur.getNbBois();
        tab[1] = inventaireJoueur.getNbArgile();
        tab[2] = inventaireJoueur.getNbPierre();
        tab[3] = inventaireJoueur.getNbOr();
        for (int k = 0; k < tab.length; k++) {
            somme += tab[k];
        }
        if (somme < this.prix) {
            retirerOuvrierSurCarte(inventaireJoueur, j.getNum());
        }
        if (somme == this.prix) {
            for (int i = 0; i < tab.length; i++) {
                tab[i] = 0;
            }
        }
        if (somme > this.prix) {
            int i = 0;
            int difference = somme - this.prix;
            while (somme > difference) {
                if (tab[i] > 0) {
                    tab[i] -= 1;
                } else {
                    i = i + 1;
                    if (tab[i] > 0) {
                        tab[i] -= 1;
                        somme -= 1;
                    }

                }
            }

        }
    }

    /**
     * methode qui permet au joueur d'acquérir la carte ;
     * @param inventaireJoueur
     * @param j
     */
    public void gainCarte(Inventaire inventaireJoueur, Joueur j) {
        switch (this) {
            case CARTE1:
            case CARTE2:
            case CARTE3:
            case CARTE4:
            case CARTE5:
            case CARTE6:
            case CARTE7:
                if (achatCarte) {
                    payement(inventaireJoueur, j);
                    inventaireJoueur.setNbNourriture(inventaireJoueur.getNbNourriture() + this.getNbRessourceNourritures());
                    inventaireJoueur.setNbPointTotal(inventaireJoueur.getNbPointTotal() + this.getPoint());
                    break;
                }


            default:
                retirerOuvrierSurCarte(inventaireJoueur, j.getNum());
                break;

        }
    }

}


