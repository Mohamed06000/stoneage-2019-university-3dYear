
package stoneage;


import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Classe du lancement du jeu
 */
public class Main {

    public static final void main(String[] args) {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        ZoneRessource zoneR = new ZoneRessource();
<<<<<<< HEAD
<<<<<<< HEAD
        ZoneVillage zoneV = new ZoneVillage();
<<<<<<< HEAD
        ZoneForet zonF = new ZoneForet();
=======
        Champ champ = new Champ();
>>>>>>> origin/Elarays
=======
        ZoneVillage zoneV = new ZoneVillage();
        ZoneInterface listZone[] = {zoneR, zoneV}; //IA
>>>>>>> origin/mazy
        Joueur listJoueur[] = {j1,j2};
=======
        ZoneInterface zoneV = new ZoneHutte();
        Joueur [] listJoueur = {j1,j2};
>>>>>>> Baroudi
        int tour = 1;

        System.out.println("Nb de joueur : " + Joueur.getNbJoueur());
<<<<<<< HEAD
        
<<<<<<< HEAD

        while(tour<5) {
        	System.out.println("Tour :" + tour);
        	System.out.println("_____PHASE DE PLACEMENT_____");
            for (int i=0; i < Joueur.getNbJoueur(); i++){
                phasePlacement(listJoueur[i], zonF);
=======
        while(zoneR.getNbRessourceZone()>0)
            {
        	System.out.println("Tour :" + tour);
        	System.out.println("_____PHASE DE PLACEMENT_____");
            for (int i=0; i < Joueur.getNbJoueur(); i++){
                phasePlacement(listJoueur[i], champ);
>>>>>>> origin/Elarays
            }

            System.out.println("_____PHASE DE RECUPERATION_____");
            for (int i=0; i < Joueur.getNbJoueur(); i++){
<<<<<<< HEAD
                phaseRecuperation(listJoueur[i], zonF);
=======
                phaseRecuperation(listJoueur[i], champ);
>>>>>>> origin/Elarays

            }

            System.out.println("_____PHASE NOURRIR____");
=======
        System.out.println("Nb d'ouvriers non place : " + Inventaire.getNbOuvrierNonPlace());


        while(zoneR.getNbRessourceZone()>0) {
            System.out.println("_________________________________________________");
            System.out.println("|                Tour : "+tour+"                      |");
            System.out.println("_________________________________________________");

        	System.out.println("================PHASE DE PLACEMENT================");
        	placementPhase(listJoueur, listZone);

            System.out.println("================PHASE DE RECUPERATION================");
            recuperationPhase(listJoueur);

            System.out.println("================PHASE NOURRIR================");
>>>>>>> origin/mazy
            for (int i = 0; i < Joueur.getNbJoueur(); i++) {
                phaseNourrir(listJoueur[i]);
            }
            tour++;
        }


        System.out.println("_____RESULTAT_____");
        resultat(listJoueur);

    }





    public static void placementPhase(Joueur[] listJoueur, ZoneInterface[] listZone){
        while(Inventaire.getNbOuvrierNonPlace() > 0){
            for (int i=0; i < Joueur.getNbJoueur(); i++){
                if (listJoueur[i].getInventaireJoueur().getNbOuvrier()==0)
                    continue;
                while(true){
                    int ind = new Random().nextInt(listZone.length); //IA choisit random une zone
                    System.out.println("Nb d'ouvriers  : " + listJoueur[i].getInventaireJoueur().getNbOuvrier());
                    int nbOuvrier = new Random().nextInt(listJoueur[i].getInventaireJoueur().getNbOuvrier())+1; //IA choisit random le nb d'ouvrier a placer
                    if(ArrayUtils.contains(listJoueur[i].getZoneVisit(),listZone[ind])==false){
                        if ((listJoueur[i].getZoneVisit().length+1) == listZone.length){
                            phasePlacement(listJoueur[i], listZone[ind], listJoueur[i].getInventaireJoueur().getNbOuvrier());
                            break;
                        }
                        else{
                            phasePlacement(listJoueur[i], listZone[ind], nbOuvrier);
                            break;
                        }

                    }
                }

            }
        }
    }

    public static void recuperationPhase(Joueur[] listJoueur){
        for (int i=0; i < Joueur.getNbJoueur(); i++){
            int nbZone = listJoueur[i].getZoneVisit().length;
            for (int j=0; j< nbZone; j++){
                int ind = new Random().nextInt(listJoueur[i].getZoneVisit().length);
                phaseRecuperation(listJoueur[i], listJoueur[i].getZoneVisit()[ind]);
                listJoueur[i].deleteZone(ind);
            }
            Inventaire.setNbOuvrierNonPlace(Inventaire.getNbOuvrierNonPlace() + listJoueur[i].getInventaireJoueur().getNbOuvrier());
        }
    }

    public static void resultat(Joueur[] listJoueur){
        int arrayRessource[] = new int[listJoueur.length];
        int max = 0;
        int listGagnant[] = {};


        for (int i = 0; i < Joueur.getNbJoueur(); i++) {
            arrayRessource[i] = listJoueur[i].getInventaireJoueur().getNbRessource();
            if (listJoueur[i].getInventaireJoueur().getNbRessource()> max){
                max = listJoueur[i].getInventaireJoueur().getNbRessource();
            }
        }
        for (int i=0; i<arrayRessource.length; i++){
            if (max == arrayRessource[i]){
                listGagnant = ArrayUtils.add(listGagnant,i);
            }
        }

        for (int i = 0; i < listGagnant.length; i++) {
            if (listGagnant.length>1){
                System.out.println("Egalité entre :");
                for (int el : listGagnant){
                    System.out.println("joueur " + listJoueur[el].getNum());
                }
                break;
            }
            else{
                System.out.println("Le gagnant est le joueur " + listJoueur[listGagnant[i]].getNum());
            }
        }
    }


    /**
     * Lancement de la phase de jeu de placement
     *
     * @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
<<<<<<< HEAD
    public static void phasePlacement(Joueur j, ZoneInterface z) {
        j.placement(z);
        System.out.println("Joueur " + j.getNum() + " :");
        System.out.println("Nb d'ouvrier dans la zone : " + z.getNbOuvrierSurZone());
        System.out.println("Nb bois : : " + j.getInventaireJoueur().getNbRessourceBois());
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbRessource());
        System.out.println("le niveau d'agriculture pour le "+ j.getNum()+ " : "+j.getInventaireJoueur().getNiveauAgriculture() );

=======
    public static void phasePlacement(Joueur j, ZoneInterface z, int nbOuvrier) {
        j.placement(z, nbOuvrier);
        System.out.println("********Joueur " + j.getNum() + "********");
        System.out.println("Nb d'ouvrier total dans la zone " + z.getClass().getSimpleName() + " : " + z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier du joueur dans la zone " + z.getClass().getSimpleName() + " : " + z.getNbOuvrierDuJoueurI(j.getNum()));
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbRessource());
        System.out.println("Les zones visitées : " + Arrays.deepToString(j.getZoneVisit()));
>>>>>>> origin/mazy
    }

    /**
     * Lancement de la phase de jeu de recuperation
     *  @param j L'objet de la classe Joueur
     * @param z L'objet de la classe Zone
     */
    public static void phaseRecuperation(Joueur j, ZoneInterface z) {
<<<<<<< HEAD
        System.out.println("Joueur " + j.getNum() + " :");
        j.action() ;
<<<<<<< HEAD
        z.gainZone(j);
        j.recupere(j.getInventaireJoueur(),z);
        z.gainZone(j);
        System.out.println("Nb bois : : " + j.getInventaireJoueur().getNbRessourceBois());
=======
        j.recupere(z);
>>>>>>> Baroudi
        System.out.println("Nb d'ouvrier dans la zone : "+ z.getNbOuvrierSurZone());
        //System.out.println("Nb de ressource dans la zone : "+ z.getNbRessourceZone());
=======
        System.out.println("********Joueur " + j.getNum() + "********");
        //z.gainZone(j);
        /*public void gainZone(){
        int somme=0;
        for(int i=0;i<z.getNbOuvrierDuJoueurI(j.getNum());i++){
            somme += j.de();
        }
        if(somme >= 6)
            double gain = somme/3; //formule qui change
        j.getInventaireJoueur().setBois(getBois()+gain); //si zone est Foret
        diminuerRessource(gain);
        retirerOuvrier(getNbOuvrierDuJoueurI(j.getNum()));
}*/
        j.recupere(z); //z.getNbOuvrierDuJoueur(j.getNum());

        System.out.println("Nb d'ouvrier dans la zone "  + z.getClass().getSimpleName() + " : "+ z.getNbOuvrierSurZone());
        System.out.println("Nb d'ouvrier du joueur " + j.getNum() + " dans la zone " + z.getClass().getSimpleName() + " : " + z.getNbOuvrierDuJoueurI(j.getNum()));
        if (z instanceof ZoneRessource){
            System.out.println("Nb de ressource dans la zone " + z.getClass().getSimpleName() + " : " + ((ZoneRessource) z).getNbRessourceZone());
        }
>>>>>>> origin/mazy

        System.out.println("le le niveau d'agriculture pour le "+ j.getNum()+ " : "+j.getInventaireJoueur().getNiveauAgriculture() );
        System.out.println("Nb d'ouvrier dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbOuvrier());
        System.out.println("Nb de ressource dans l'inventaire du joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbRessource());

    }



    /**
     * Lancement de la phase de jeu "nourrir"
     *
     * @param j L'objet de la classe Joueur
     */
    public static void phaseNourrir(Joueur j) {
        j.nourrir();
        System.out.println(" Quantitée de nouriture pour le joueur " + j.getNum() + " : " + j.getInventaireJoueur().getNbNourriture());

    }
}

