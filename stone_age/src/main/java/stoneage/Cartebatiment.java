package stoneage;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collection;


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


    /**
     * Constructeur de Cartebatiment
     *
     * @param point
     * @param ressource
     */
    Cartebatiment(int point, ArrayList<Ressource> ressource) {
        this.nbOuvrierSurCarte = 1;
        this.nbRessourceApayer = 3;
        this.point = point;
        this.ressource = ressource;
        this.PlaceReserver = false;

    }

    Cartebatiment(int nbRessourceApayer, int nbRessourceDiff) {
        this.nbOuvrierSurCarte = 1;
        this.nbRessourceApayer = nbRessourceApayer;
        this.point = point;
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
    public void payement(Inventaire inventaireJoueur) {


        if (nbRessourceDiff == 7) {
            for (int i = 0; i < nbRessourceApayer; i++) {
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

        if (nbRessourceDiff >= 1 && nbRessourceDiff < 5) {

        } else {
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
        return "Carte Batiment";
    }
}




