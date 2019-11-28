package stoneage;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum CarteCivilisation {
    CARTE1("Jaune", 4, 0, 0, 0, false, 1, 1),
    CARTE2("Jaune", 0, 0, 0, 2, false, 2, 1),
    CARTE3("Jaune", 0, 0, 1, 0, false, 3, 1),
    CARTE4("Vert", 0, 0, 2, 0, false, 4, 1),
    CARTE5("Jaune", 0, 0, 1, 0, false, 5, 1),
    CARTE6("vert",1,1,1,false),
    CARTE7("vert",2,1,1,false),
    CARTE8("vert",3,1,2,false),
    CARTE9("Vert",4,1,2,false),
    CARTE10("Vert",5,1,3,false),
    CARTE11("Vert",6,1,3,false),
    CARTE12("Vert",7,1,4,false);


    private String couleur;
    private int nbRessourceArgile;
    private int nbRessourceBois;
    private int nbRessourceOr;
    private int nbRessourcePierre;
    private int Point;
    private int nbOuvrierDuJoueurI[];
    private boolean PlaceReserver = false;
    private int prix;
    private int nbRessourceNourriture ;


    @org.jetbrains.annotations.Contract(pure = true)
    CarteCivilisation(String couleur, int nbRessourceArgile, int nbRessourceBois, int nbRessourcePierre, int nbRessourceOr, boolean PlaceReserver, int prix, int Point) {
        this.couleur = couleur;
        this.nbRessourceArgile = nbRessourceArgile;
        this.nbRessourceBois = nbRessourceBois;
        this.nbRessourcePierre = nbRessourcePierre;
        this.nbRessourceOr = nbRessourceOr;
        this.Point = Point;
        this.prix = prix;

    }

    CarteCivilisation(String couleur, int nbRessourceNourriture, int Point, int prix , boolean PlaceReserver ) {
        this.couleur = couleur ;
        this.nbRessourceNourriture=nbRessourceNourriture;
        this.prix=prix;
        this.PlaceReserver= PlaceReserver;
        this.Point = Point ;

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

    public int getNbRessourceNourritures() {
        return nbRessourceNourriture;
    }

    /**
     * on place un ouvrier sur la carte.
     * @param inventaireJoueur
     * @param nbOuvrierAplacer
     * @param id
     */
    public void placeOuvrierSurCarte(Inventaire inventaireJoueur, int nbOuvrierAplacer, int id) {
        if ((PlaceReserver == false) || (nbOuvrierAplacer == 1)) {
            inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() - nbOuvrierAplacer);
            PlaceReserver = true;
            //nbOuvrierDuJoueurI[id-1] = nbOuvrierAplacer;
        } else {
            throw new java.lang.Error("Il ne peut pas y avoir plus d'un ouvrier sur cette carte!");
        }

    }

    /**
     * on retire un ouvrier sur la carte.
     * @param inventaireJoueur
     * @param id
     */

    public void retirerOuvrierSurCarte(@NotNull Inventaire inventaireJoueur, int id) {
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
                inventaireJoueur.restRessource(i,0);
            }
        }
        if (somme > this.prix) {
            int i = 0;
            int difference = somme - this.prix;
            while (somme > difference) {
                if (tab[i] > 0) {
                    //tab[i] -= 1;
                    inventaireJoueur.restRessource(i,tab[i]-1);
                    somme -= 1;
                } else {
                    i = i + 1;
                    if (tab[i] > 0) {
                        //tab[i] -= 1;
                        inventaireJoueur.restRessource(i,tab[i]-1);
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
                if (achatCarte) {
                    payement(inventaireJoueur, j);
                    inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() + CARTE1.getNbRessourceArgile());
                    inventaireJoueur.setNbPointTotal(inventaireJoueur.getNbPointTotal() + CARTE1.getPoint());
                    break;

                }

            case CARTE2:
                if (achatCarte) {
                    payement(inventaireJoueur, j);
                    inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() + CARTE2.getNbRessourceOr());
                    inventaireJoueur.setNbPointTotal(inventaireJoueur.getNbPointTotal() + CARTE2.getPoint());
                    break;
                }
            case CARTE3:
            case CARTE4:
            case CARTE5:
                if (achatCarte) {
                    payement(inventaireJoueur, j);
                    inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() + CARTE3.getNbRessourcePierre());
                    inventaireJoueur.setNbPointTotal(inventaireJoueur.getNbPointTotal() + CARTE3.getPoint());
                    break;
                }
            case CARTE6:
            case CARTE7:
            case CARTE8:
            case CARTE9:
            case CARTE10:
            case CARTE11:
            case CARTE12:
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




