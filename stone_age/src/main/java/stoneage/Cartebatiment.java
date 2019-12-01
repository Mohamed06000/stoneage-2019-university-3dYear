package stoneage;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cartebatiment {

    int nbRessourceApayer;
    int point;
    int emplacement;
    ArrayList<Ressource> ressource;
    private boolean PlaceReserver ;



    Cartebatiment(int point , ArrayList<Ressource> ressource){
        this.emplacement=1;
        this.nbRessourceApayer=3;
        this.point=point;
        this.ressource=ressource;
        this.PlaceReserver=false;

    }
    public void placeOuvrierSurCarte(Inventaire inventaireJoueur, int nbOuvrierAplacer) {
        if (nbOuvrierAplacer == 1) {
            inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() - 1);
            this.PlaceReserver=true;
        }
    }

    public void retirerOuvrierSurCarte(@NotNull Inventaire inventaireJoueur) {
        inventaireJoueur.setNbOuvrier(inventaireJoueur.getNbOuvrier() + 1);
        this.PlaceReserver = false;
    }


    /**
     * méthode qui permet au Joueur  de payer la carte si celui ci posséde les ressources suffisantes .
     * @param inventaireJoueur L'inventaire du joueur
     * @param j Le joueur
     */
    public void payement(Inventaire inventaireJoueur, Joueur j) {
        int somme = 0;
        int[] tab = new int[4];
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
        this.retirerOuvrierSurCarte(inventaireJoueur);
    }

}

