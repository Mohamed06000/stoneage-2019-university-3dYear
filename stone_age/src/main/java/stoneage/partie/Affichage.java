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
     * @param affichage booléen, l'affichage des phases de jeu se fait si la valeur est true, il n'y pas d'affichage dans le cas contraire
     */
    public Affichage(boolean affichage) {
        this.affichage = affichage;
    }


    /**
     * Affiche un message avec le Tour dans lequel on est et le premier joueur qui va commencer le tour
     * Affiche également un message qui informe qu'on entre dans la première phase de jeu à savoir les placements.
     * @param nbTour Le numero du tour courant
     * @param premierAjouer l'index du joueur qui commence le tour
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
     * @param numJ le numero du joueur qui lance le dé.
     * @param resultat Le résultat du lancé de dé.
     */
    public void AfficheLanceDe(int numJ, int resultat){
        if (this.affichage){
            System.out.println("Le Joueur " + numJ + " lance le dé");
            System.out.println("Il obtient : "+ resultat);
        }
    }

    /**
     * Affiche le gain final après les lancés de dés.
     * @param somme La somme des resultats des lancés de dés.
     * @param diviseur Le diviseur de la Zone.
     * @param gain Le gain final, la somme divisé par le diviseur.
     */
    public void AfficheGain(int somme, int diviseur,int gain){
        if (this.affichage) {
            System.out.println("Il a un gain de  "+ somme +" divisé par " + diviseur + " soit : " + gain);
        }
    }

    /**
     * Affiche le numero du joueur.
     * @param numJ L'index du joueur (dans le tableau tabFirstPlayer)
     */
    public void AffichageNumJoueur(int numJ){
        if (this.affichage){
            System.out.println(" ");
            System.out.println("********Joueur " + (numJ+1) + "********");
        }
    }

    /**
     * Affiche un message qui informe du placement d'ouvriers du joueur numJ sur la Zone Z.
     * @param numJ L'index du joueur (dans le tableau tabFirstPlayer).
     * @param z La zone dans laquelle le joueur d'index numJ va placer ses ouvriers.
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
     * @param c La carte sur laquelle un joueur place un ouvrier
     */
    public void AffichePlacement(Cartebatiment c){
        if (this.affichage){
            System.out.println("Il place un ouvrier sur la Carte "+ c);
        }
    }

    /**
     * Affiche le message d'utilisation des ouvriers par le joueur de numero numJ sur une Zone z.
     * @param numJ L'index du joueur (dans le tableau tabFirstPlayer)
     * @param z La zone dans laquelle le joueur d'index numJ va utiliser ses ouvriers.
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
     * @param c La carte sur laquelle un joueur utilise un ouvrier
     */
    public void AfficheRecup(Cartebatiment c){
        if (this.affichage) {
            System.out.println("Il utilise son ouvrier placé sur la Carte " + c);
        }
    }

    /**
     * Affiche le message du nombre de ressource que les ouvriers du joueurs ont produit
     * @param gain Le nombre de ressources que le joueur a gagné.
     * @param ressourceDeLaZone La ressource que le joueur a gagné.
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
     * @param type_zone Représente la Zone village : 0 représente le Champ, 1 représente la fabrique d'outils, les autres valeurs représentent la Hutte.
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
    public void AfficheGagnant(int indexDuPremier, Inventaire inventaireDuGagnant) {
        if (this.affichage) {
            System.out.println(" ");
            System.out.println(" Le Joueur " + (indexDuPremier+1) + " a gagné !!!");
            System.out.println(inventaireDuGagnant);
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

    public void AfficheGainFull(Zone zone, int gain) {
        System.out.println(" ");
        System.out.println("Il n'y a plus de " + zone.getRessource() + " dans la zone " + zone + " il prends donc " +gain+ " " + zone.getRessource());
    }
}
