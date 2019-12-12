package stoneage.partie;

import stoneage.plateaudejeu.Inventaire;
import stoneage.plateaudejeu.Ressource;
import stoneage.plateaudejeu.cartes.Cartebatiment;
import stoneage.plateaudejeu.zones.Zone;
import java.util.ArrayList;

/**
 * Classe Affichage, classe qui affiche les messages d'information sur l'avancée du jeu
 * Les placements, les lancés de dé, etc
 */
public class Affichage {
    private boolean affichage;


    /**
     * Constructeur de la classe Affichage determine si l'affichage se fait ou non
     * @param affichage
     */
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
            AffichageNumJoueur(numJ);
            if (phase == 0){
                //System.out.println("Il place " + z.getNbOuvirerDuJoueur(numJ)+" ouvrier(s) dans la Zone " + z);
                //System.out.println("Il y a au total " + z.getNbOuvrierSurZone() + " ouvrier(s) dans la Zone " +z);
                //System.out.println("Il reste au Joueur "+ (numJ+1) +", "+ inventaire.getNbOuvrier() + " ouvrier(s) à placer");
                //System.out.println("Nombre d'ouvrier total dans l'inventaire du joueur " + (numJ+1) + " : " + inventaire.getNbOuvrierTotal());
            }
            if (phase != 0){
                System.out.println("Il recupère son/ses  " + z.getNbOuvirerDuJoueur(numJ)+" ouvrier(s) dans la Zone " + z);
                System.out.println("Il reste au total " + z.getNbOuvrierSurZone() + " ouvrier(s) dans la Zone " +z);
                System.out.println("Il reste au Joueur "+ (numJ+1) +", "+ (inventaire.getNbOuvrierTotal() - inventaire.getNbOuvrier()) + " ouvrier(s) à récupérer");
                //System.out.println("Nombre d'ouvrier total dans l'inventaire du joueur " + (numJ+1) + " : " + inventaire.getNbOuvrierTotal());
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

            if (phase == 0){
                //System.out.println("Il place un ouvrier sur la Carte "+ c);
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


    /**
     * Affiche un message avec le Tour dans lequel on est et le premier joueur qui va commencer le tour
     * Affiche également un message qui informe qu'on entre dans la première phase de jeu à savoir les placements.
     * @param nbTour
     * @param premierAjouer
     */
    public void AfficheInfoTour(int nbTour, int premierAjouer){
        if (this.affichage){
            System.out.println("_________________________________________________");
            System.out.println("|                TOUR : "+nbTour+"                      |");
            System.out.println("       Le joueur " + (premierAjouer+1) + " est le premier à jouer");
            System.out.println("_________________________________________________");
            System.out.println("================PHASE DE PLACEMENT================");
        }
    }


    /**
     * Affiche un message d'information lorsqu'on entre dans la deuxième phase de jeu, lorsque les joueurs récupèrent et utilisent leurs ouvriers.
     */
    public void AfficheRecup(){
        if (this.affichage){
            System.out.println(" ");
            System.out.println("================PHASE DE RECUPERATION================");
        }
    }

    /**
     *Affiche un message d'information lorsqu'on entre dans la phase de jeu où les joueurs nourrissent leurs ouvriers.
     */
    public void AffichePhaseNourrir(){
        if (this.affichage){
            System.out.println(" ");
            System.out.println("================PHASE NOURRIR================");
        }
    }

    /**
     * Affiche le resultat obtenu après le lancé de dé du joueur numero numJ
     * @param numJ
     * @param resultat
     */
    public void AfficheLanceDe(int numJ, int resultat){
        if (this.affichage){
            System.out.println("Le Joueur " + numJ + " lance le dé");
            System.out.println("Il obtient : "+ resultat);
        }
    }

    /**
     * Affiche le gain final après les lancés de dés.
     * @param somme
     * @param diviseur
     * @param gain
     */
    public void AfficheGain(int somme, int diviseur,int gain){
        if (this.affichage) {
            System.out.println("Il a un gain de  "+ somme +" divisé par " + diviseur + " soit : " + gain);
        }
    }

    /**
     * Affiche le numero du joueur.
     * @param numJ
     */
    public void AffichageNumJoueur(int numJ){
        if (this.affichage){
            System.out.println(" ");
            System.out.println("********Joueur " + (numJ+1) + "********");
        }
    }

    /**
     * Affiche un message qui informe du placement d'ouvriers du joueur numJ sur la Zone Z.
     * @param numJ
     * @param z
     */
    public void AffichePlacement(int numJ, Zone z){
        if (this.affichage){
            if (z.getNbOuvirerDuJoueur(numJ)>1){
                System.out.println("Il place " + z.getNbOuvirerDuJoueur(numJ)+ " ouvriers dans la Zone " + z);
            }
            else {
                System.out.println("Il place " + z.getNbOuvirerDuJoueur(numJ)+ " ouvrier dans la Zone " + z);
            }
        }
    }

    /**
     * Affiche le message du placement sur une carte.
     * @param c
     */
    public void AffichePlacement(Cartebatiment c){
        if (this.affichage){
            System.out.println("Il place un ouvrier sur la Carte "+ c);
        }
    }


    /**
     * Affiche le message d'utilisation des ouvriers par le joueur de numero numJ sur une Zone z.
     * @param numJ
     * @param z
     */
    public void AfficheRecup(int numJ, Zone z){
        if (this.affichage){
            if (z.getNbOuvirerDuJoueur(numJ)>1){
                System.out.println("Il utilise ses  " + z.getNbOuvirerDuJoueur(numJ)+" ouvriers dans la Zone " + z);
            }
            else {
                System.out.println("Il utilise son ouvrier dans la Zone " + z);
            }
        }
    }


    /**
     * Affiche le message d'utilisation des ouvriers sur une Carte Batiment c.
     * @param c
     */
    public void AfficheRecup(Cartebatiment c){
        if (this.affichage) {
            System.out.println("Il utilise son ouvrier placé sur la Carte " + c);
        }
    }

    /**
     * Affiche le message du nombre de ressource que les ouvriers du joueurs ont produit
     * @param gain
     * @param ressourceDeLaZone
     */
    public void AfficheGainRessource(int gain, Ressource ressourceDeLaZone) {
        if (this.affichage) {
            System.out.println("Il produit " + gain + " " + ressourceDeLaZone);
        }
    }

    /**
     * Affiche le message du gain d'un niveau d'agriculture lorsque type_zone=0,
     * un outils lorsque type_zone=1,
     * un ouvrier autrement.
     * @param type_zone
     */
    public void AfficheGainVillage(int type_zone){ /* 0 est le champ*/
        if (this.affichage) {
            if (type_zone == 0) {
                System.out.println("Il gagne 1 niveau d'agriculture");
            } else if (type_zone == 1) { /* 1 zone outils*/
                System.out.println("Il gagne un outils");
            } else { /* zone Hutte*/
                System.out.println("Il gagne un ouvrier");
            }
        }
    }


    /**
     * Affiche le message de Fin de partie
     */
    public void AfficheMessageFin() {
        if (this.affichage) {
            System.out.println(" ");
            System.out.println("====================== RESULTAT  =========================");
        }
    }

    /**
     * Affiche le gagnant du jeu
     * @param indexDuPremier L'index du joueur gagnant
     */
    public void AfficheGagnant(int indexDuPremier) {
        if (this.affichage) {
            System.out.println(" ");
            System.out.println(" Le Joueur " + indexDuPremier + " a gagné !!!");
        }
    }


    public void AfficheNourrir(Ressource choixNourrir, int numJ) {
        if (this.affichage){
            System.out.println(" ");
            System.out.println("Le Joueur " + (numJ+1) + " nourrit ses ouvriers avec la ressource "+ choixNourrir);
        }
    }

    public void AffichePenalite(int numJ) {
        System.out.println(" ");
        System.out.println("Le Joueur " + (numJ+1) + " n'a pas de quoi nourrir ses ouvriers, il prends une pénalité de 10 points");
    }
}
