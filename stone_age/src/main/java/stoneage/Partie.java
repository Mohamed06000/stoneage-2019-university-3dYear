package stoneage;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Random;

public class Partie {
    private int nbJoueur;
    private final Plateau plateau = new Plateau(2);
    private int[] score;
    private static Random rand = new Random();

    Partie(int nbJoueur){
        this.nbJoueur = nbJoueur;
        score = new int[nbJoueur];
    }


    public void jouer() {
        int tour = 1;
        System.out.println("Nb de joueur : " + nbJoueur);
        System.out.println("Nb d'ouvriers total non place : " + plateau.nbOuvrierDispoTotal());


        while(tour<5) {
            System.out.println("_________________________________________________");
            System.out.println("|                Tour : "+tour+"                      |");
            System.out.println("_________________________________________________");

            System.out.println("================PHASE DE PLACEMENT================");
            plateau.placementPhase();


            System.out.println("================PHASE DE RECUPERATION================");
            plateau.recuperationPhase();

            System.out.println("================PHASE NOURRIR================");
            plateau.phaseNourrir();

            tour++;
        }


        System.out.println("_____RESULTAT_____");
        resultat(plateau.getListeInventaire());
        this.indexGagnant(score);
        this.JoueurGagnant(score);
    }


//    public static void resultat(ArrayList joueurs, ArrayList inventaires){
//        int arrayRessource[] = new int[joueurs.size()];
//        int max = 0;
//        int listGagnant[] = {};
//
//
//        for (int i = 0; i < Joueur.getNbJoueur(); i++) {
//            Inventaire inventaire = (Inventaire) inventaires.get(i);
////            arrayRessource[i] = inventaire.getNbRessource();
////            if (inventaire.getNbRessource()> max){
////                max = inventaire.getNbRessource();
////            }
//        }
//        for (int i=0; i<arrayRessource.length; i++){
//            if (max == arrayRessource[i]){
//                listGagnant = ArrayUtils.add(listGagnant,i);
//            }
//        }
//
//        for (int i = 0; i < listGagnant.length; i++) {
//            if (listGagnant.length>1){
//                System.out.println("Egalité entre :");
//                for (int el : listGagnant){
//                    Joueur joueur = (Joueur) joueurs.get(el);
//                    System.out.println("joueur " + joueur.getNum());
//                }
//                break;
//            }
//            else{
//                Joueur joueur = (Joueur) joueurs.get(listGagnant[i]);
//                System.out.println("Le gagnant est le joueur " + joueur.getNum());
//            }
//        }
//    }

    public void resultat(ArrayList<Inventaire> listInventaire){
        for (int i = 0; i < listInventaire.size(); i++) {
            this.score[i] = listInventaire.get(i).calculPoint();
        }
    }

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

    public void JoueurGagnant(int[] points){
        int gagnant = indexGagnant(points);
        System.out.println("Le Gagnant est le joueur " + (gagnant+1));
    }
}
