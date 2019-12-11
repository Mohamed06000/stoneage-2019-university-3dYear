package stoneage.partie;

import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.cartes.Cartebatiment;
import stoneage.plateaudejeu.zones.Zone;

import java.util.ArrayList;

public class Affichage {
    private boolean affichage;

    public Affichage(boolean affichage) {
        this.affichage = affichage;
    }



    /**
     * Affiche les informations du joueur numero numJ
     * Si phase est égale à 0 alors on est dans la phase de placement, sinon on est dans la phase de récuperation
     * @param numJ Le numero du joueur
     * @param z Une zone
     * @param ZoneVisitees La  liste des zones visitées par le joueur
     * @param inventaire L'inventaire du joueur
     * @param phase Indique dans quelle phase l'affichage doit se faire
     */
    public void AfficheInfoJoueur(int numJ, Zone z, int phase,
                                         ArrayList<Zone> ZoneVisitees,
                                         ArrayList<Cartebatiment> CarteVisitees,
                                         Inventaire inventaire) {
        if(this.affichage){
            System.out.println("********Joueur " + (numJ+1) + "********");
            if (phase == 0){
                System.out.println("Il place " + z.getNbOuvirerDuJoueur(numJ)+" ouvrier(s) dans la Zone " + z);
                System.out.println("Il y a au total " + z.getNbOuvrierSurZone() + " ouvrier(s) dans la Zone " +z);
                System.out.println("Il reste au Joueur "+ (numJ+1) +", "+ inventaire.getNbOuvrier() + " ouvrier(s) à placer");
                System.out.println("Nombre d'ouvrier total dans l'inventaire du joueur " + (numJ+1) + " : " + inventaire.getNbOuvrierTotal());
            }
            if (phase != 0){
                System.out.println("Il recupère son/ses  " + z.getNbOuvirerDuJoueur(numJ)+" ouvrier(s) dans la Zone " + z);
                System.out.println("Il reste au total " + z.getNbOuvrierSurZone() + " ouvrier(s) dans la Zone " +z);
                System.out.println("Il reste au Joueur "+ (numJ+1) +", "+ (inventaire.getNbOuvrierTotal() - inventaire.getNbOuvrier()) + " ouvrier(s) à récupérer");
                System.out.println("Nombre d'ouvrier total dans l'inventaire du joueur " + (numJ+1) + " : " + inventaire.getNbOuvrierTotal());
            }
            if (ZoneVisitees.size()>0) {
                System.out.println("Les zones visitées : " + (ZoneVisitees));
                for (Zone zone: ZoneVisitees) {
                    System.out.println("Il a " + zone.getNbOuvirerDuJoueur(numJ) + " ouvrier(s) sur la Zone " + zone);
                }
            }
            if (CarteVisitees.size()>0) {
                System.out.println("Les cartes visitées : " + (CarteVisitees));
            }
        }
    }

    /**
     * Affiche les informations du joueur numero numJ
     * @param numJ
     * @param c
     * @param ZoneVisitees
     * @param CarteVisitees
     * @param inventaire
     * @param phase Indique dans quelle phase l'affichage doit se faire
     */
    public void AfficheInfoJoueur(int numJ, Cartebatiment c, int phase,
                                         ArrayList<Zone> ZoneVisitees,
                                         ArrayList<Cartebatiment> CarteVisitees,
                                         Inventaire inventaire) {
        if(this.affichage){
            System.out.println("********Joueur " + (numJ+1) + "********");
            if (phase == 0){
                System.out.println("Il place un ouvrier sur la Carte "+ c);
                System.out.println("Il reste au Joueur "+ (numJ+1) +", "+ inventaire.getNbOuvrier() + " ouvrier(s) à placer");
                System.out.println("Nombre d'ouvrier total dans l'inventaire du joueur " + (numJ+1) + " : " + inventaire.getNbOuvrierTotal());
            }
            if (phase != 0){
                System.out.println("Il récupère son ouvrier placé sur la Carte "+ c);
                System.out.println("Il reste au Joueur "+ (numJ+1) +", "+ (inventaire.getNbOuvrierTotal() - inventaire.getNbOuvrier()) + " ouvrier(s) à récupérer");
                System.out.println("Nombre d'ouvrier total dans l'inventaire du joueur " + (numJ+1) + " : " + inventaire.getNbOuvrierTotal());
            }
            if (ZoneVisitees.size()>0) {
                System.out.println("Les zones visitées : " + (ZoneVisitees));
                for (Zone zone: ZoneVisitees) {
                    System.out.println("Il a " + zone.getNbOuvirerDuJoueur(numJ) + " ouvrier(s) sur la Zone " + zone);
                }
            }
            if (CarteVisitees.size()>0) {
                System.out.println("Les cartes visitées : " + (CarteVisitees));
            }
        }
    }


    public void AfficheInfoTour(){

    }


}
