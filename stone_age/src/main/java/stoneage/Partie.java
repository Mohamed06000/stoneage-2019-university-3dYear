
package stoneage;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe qui gère le déroulement du jeu
 */
public class Partie {

    //CHAMPS

    /**
     * Le nombre de joueur
     */

    private static int nbJoueur = 4;

    /**
     * Objet qui represente le plateau de jeu
     */
    private final Plateau plateau;
    /**
     * Liste des scores des joueurs
     */
    private int[] score;

    private boolean affichage = false;


    //CONSTRUCTEUR

    /**
     * Constructeur de la classe
     * @param nbJoueur Le nombre de joueurs
     */
    Partie(int nbJoueur, boolean affichage){
        this.nbJoueur = nbJoueur;
        plateau = new Plateau(nbJoueur);
        score = new int[nbJoueur];
        this.affichage = affichage;
    }


    //METHODES

    /**
     * Récupère le nombre de joueurs
     * @return Le nombre de joueurs
     */
    public static int getNbJoueur() {
        return nbJoueur;
    }

    /**
     * Lance la boucle du jeu
     */
    public void jouer() {
        int tour = 1;
        System.out.println("Nb de joueur : " + nbJoueur);
        System.out.println("Nb d'ouvriers total non place : " + plateau.nbOuvrierDispoTotal());


        while(tour<6) { //plateau.verifierNbCarteCivilisation() && plateau.verifierNbCarteBatiment()
            if (affichage){
            System.out.println("_________________________________________________");
            System.out.println("|                TOUR : "+tour+"                      |");
            System.out.println("_________________________________________________");

            System.out.println("================PHASE DE PLACEMENT================");
            }

            plateau.placementPhase(affichage);

            if (affichage){
            System.out.println("================PHASE DE RECUPERATION================");
            }
            plateau.recuperationPhase(affichage);
            if(affichage){
            System.out.println("================PHASE NOURRIR================");
            }
            plateau.phaseNourrir();

            tour++;
        }


        System.out.println("_____RESULTAT_____");
        resultat(plateau.getListeInventaire());
        int max = this.indexGagnant(score);
        this.JoueurGagnant(score);
    }

    /**
     * Stocke les scores des joueurs dans la liste score
     * @param listInventaire La liste des inventaires
     */
    public void resultat(ArrayList<Inventaire> listInventaire){
        for (int i = 0; i < listInventaire.size(); i++) {
            this.score[i] = listInventaire.get(i).calculPoint();
        }
    }

    /**
     * Affiche le gagnant du jeu
     * @param points La liste des scores
     */
    public void JoueurGagnant(int[] points){
        int gagnant = indexGagnant(points);
        System.out.println("Le Gagnant est le joueur " + (gagnant+1));
    }

    /**
     * Récupère le numero du joueur gagnant
     * @param points La liste des scores
     * @return Le numéro du joueur gagnant
     */
    public int indexGagnant(int[] points){
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            if (max < points[i]){
                max = points[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

