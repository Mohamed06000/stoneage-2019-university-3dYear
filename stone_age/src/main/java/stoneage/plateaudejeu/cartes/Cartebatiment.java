package stoneage.plateaudejeu.cartes;


import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Ressource;

import java.util.ArrayList;


/**
 * Classe qui represente les cartes btiment
 */
public class Cartebatiment {

    private int nbRessourceApayer;
    private int point;
    private int nbOuvrierSurCarte;
    ArrayList<Ressource> ressource;
    private int nbRessourceDiff;

    public boolean isPlaceReserver() {
        return PlaceReserver;
    }

    private boolean PlaceReserver;
    private int type_carte;


    /**
     * Constructeur de Cartebatiment
     *
     * @param point
     * @param ressource
     */
    public Cartebatiment(int point, ArrayList<Ressource> ressource) {
        this.nbOuvrierSurCarte = 1;
        this.nbRessourceApayer = 3;
        this.point = point;
        this.type_carte=1;
        this.ressource = ressource;
        this.PlaceReserver = false;

    }

    public Cartebatiment(int nbRessourceApayer, int nbRessourceDiff, int type_carte) {
        this.nbOuvrierSurCarte = 1;
        this.nbRessourceApayer = nbRessourceApayer;
        this.point = point;
        this.type_carte=type_carte;
        this.nbRessourceDiff = nbRessourceDiff;
        this.PlaceReserver = false;

    }

    public void point() {

    }


    public int getNbRessourceApayer() {
        return nbRessourceApayer;
    }

    /**
     * Methode de placement d'ouvrier sur une carte batiment
     */
    public void placeOuvrierSurCarte() {
        this.PlaceReserver = true;
    }


    /**
     * Methode pour retirer ouvrier sur une carte batiment
     *
     * @param inventaireJoueur
     */
    public void retirerOuvrierSurCarte(Inventaire inventaireJoueur) {
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + 1);
        this.PlaceReserver = false;
    }


    /**
     * Méthode qui permet au Joueur  de payer la carte si celui ci posséde les ressources suffisantes .
     *
     * @param inventaireJoueur L'inventaire du joueur
     */
    public void payement(Inventaire inventaireJoueur, int choixNbRessource) {


        if (this.type_carte==3) {

            for (int i = 0; i < choixNbRessource; i++) {
                if (inventaireJoueur.getNbBois() > 0) {
                    inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                    point += 1 * 3;
                }
                if (inventaireJoueur.getNbArgile() > 0) {
                    inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                    point += 1 * 4;
                }
                if (inventaireJoueur.getNbPierre() > 0) {
                    inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                    point += 1 * 5;
                }
                if (inventaireJoueur.getNbOr() > 0) {
                    inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                    point += 1 * 6;
                }
            }
        }

        if (this.type_carte==2) {
            switch (nbRessourceDiff) {
                case 1 :
                    if (inventaireJoueur.getNbBois() > 0) {
                        inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                        point += 1 * 3;
                    }
                case 2 :
                    for (int i = 0; i < 2; i++) {
                        if (inventaireJoueur.getNbBois() > 0) {
                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                            point += 1 * 3;
                        }
                        if (inventaireJoueur.getNbArgile() > 0) {
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                            point += 1 * 4;
                        }
                    }
                case 3:
                    for (int i = 0; i < 3; i++) {
                        if (inventaireJoueur.getNbBois() > 0) {
                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                            point += 1 * 3;
                        }
                        if (inventaireJoueur.getNbArgile() > 0) {
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                            point += 1 * 4;
                        }
                        if (inventaireJoueur.getNbPierre() > 0) {
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            point += 1 * 5;
                        }
                    }
                case 4 :
                    for (int i = 0; i < 4; i++) {
                        if (inventaireJoueur.getNbBois() > 0) {
                            inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - 1);
                            point += 1 * 3;
                        }
                        if (inventaireJoueur.getNbArgile() > 0) {
                            inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - 1);
                            point += 1 * 4;
                        }
                        if (inventaireJoueur.getNbPierre() > 0) {
                            inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - 1);
                            point += 1 * 5;
                        }
                        if (inventaireJoueur.getNbOr() > 0) {
                            inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - 1);
                            point += 1 * 6;
                        }
                    }
            }
        }
        if (this.type_carte==1){
            int nbargile = 0;
            int nbbois = 0;
            int nbor = 0;
            int nbpierre = 0;

            for (Ressource r : ressource) {
                switch (r) {
                    case OR:
                        nbor++;
                        break;
                    case BOIS:
                        nbbois++;
                        break;
                    case PIERRE:
                        nbpierre++;
                        break;
                    case ARGILE:
                        nbargile++;
                        break;
                }
            }
            if ((nbargile <= inventaireJoueur.getNbArgile()) && (nbbois <= inventaireJoueur.getNbBois()) && (nbpierre <= inventaireJoueur.getNbPierre())
                    && nbor <= inventaireJoueur.getNbOr()) {
                inventaireJoueur.setNbArgile(inventaireJoueur.getNbArgile() - nbargile);
                inventaireJoueur.setNbPierre(inventaireJoueur.getNbPierre() - nbpierre);
                inventaireJoueur.setNbBois(inventaireJoueur.getNbBois() - nbbois);
                inventaireJoueur.setNbOr(inventaireJoueur.getNbOr() - nbor);
            }
        }

        this.retirerOuvrierSurCarte(inventaireJoueur);
        inventaireJoueur.setNbPointTotal(inventaireJoueur.getNbPointTotal() + point);
    }

    public String toString() {
        if (nbRessourceDiff==7)
            return "CarteBatiment1-7";
        if (nbRessourceDiff>=1 && nbRessourceDiff<5)
            return "CarteBatiment-5";
        else
            return "CarteBatiment-3";
    }
}




